#!/bin/sh

# based on https://github.com/cyrus-and/chrome-remote-interface/blob/master/scripts/update-protocol.sh
set -e

browser="browser_protocol.json"
js="js_protocol.json"
version="master"

trap "rm -f '$browser' '$js'" EXIT

base='https://chromium.googlesource.com'
echo "Fetching $base/chromium/src/+/$version/third_party/WebKit/Source/core/inspector/browser_protocol.json?format=TEXT"
curl -s "$base/chromium/src/+/$version/third_party/WebKit/Source/core/inspector/browser_protocol.json?format=TEXT" | base64 --decode >"$browser"
echo "Fetching $base/v8/v8/+/master/src/inspector/js_protocol.json?format=TEXT"
curl -s "$base/v8/v8/+/master/src/inspector/js_protocol.json?format=TEXT" | base64 --decode >"$js"

echo "Merging files $js $browser"
node -p '
    const protocols = process.argv.slice(1).map((path) => JSON.parse(fs.readFileSync(path)));
    protocols[0].domains.push(...protocols[1].domains);
    JSON.stringify(protocols[0], null, 4);
' "$browser" "$js" >protocol.json

git --no-pager diff protocol.json

if [[ -n $(git status -s) ]];
then

	go run generator.go
	./gradlew ktlintFormat
	./gradlew ktlint
	git add .
	git commit -m "Update to newest protocol"
	git push origin
fi
