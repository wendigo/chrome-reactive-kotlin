#!/bin/sh

# based on https://github.com/cyrus-and/chrome-remote-interface/blob/master/scripts/update-protocol.sh
set -e

browser="browser_protocol.json"
js="js_protocol.json"
trap "rm -f '$browser' '$js'" EXIT

base='https://chromium.googlesource.com'
curl -s "$base/chromium/src/+/master/third_party/WebKit/Source/core/inspector/browser_protocol.json?format=TEXT" | base64 --decode >"$browser"
curl -s "$base/v8/v8/+/master/src/inspector/js_protocol.json?format=TEXT" | base64 --decode >"$js"
node -p '
    const protocols = process.argv.slice(1).map((path) => JSON.parse(fs.readFileSync(path)));
    protocols[0].domains.push(...protocols[1].domains);
    JSON.stringify(protocols[0], null, 4);
' "$browser" "$js" >protocol.json

git diff protocol.json

go run generator.go