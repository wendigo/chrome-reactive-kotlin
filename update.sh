#!/bin/sh
GREEN='\033[0;32m'
NC='\033[0m'

# based on https://github.com/cyrus-and/chrome-remote-interface/blob/master/scripts/update-protocol.sh
set -e

browser="browser_protocol.json"
js="js_protocol.json"
version="master"

trap "rm -f '$browser' '$js'" EXIT

base='https://chromium.googlesource.com'
printf "${GREEN}Fetching:\n\t/chromium/src/+/$version/third_party/WebKit/Source/core/inspector/browser_protocol.json?format=TEXT...${NC}\n"
curl -s "$base/chromium/src/+/$version/third_party/WebKit/Source/core/inspector/browser_protocol.json?format=TEXT" | base64 --decode >"$browser"
printf "${GREEN}\t/v8/v8/+/master/src/inspector/js_protocol.json?format=TEXT...${NC}\n"
curl -s "$base/v8/v8/+/master/src/inspector/js_protocol.json?format=TEXT" | base64 --decode >"$js"

printf "${GREEN}Merging files $js $browser into protocol.json${NC}\n"

node -p '
    const protocols = process.argv.slice(1).map((path) => JSON.parse(fs.readFileSync(path)));
    protocols[0].domains.push(...protocols[1].domains);
    JSON.stringify(protocols[0], null, 4);
' "$browser" "$js" >protocol.json

git --no-pager diff protocol.json

if [[ -n $(git status -s) ]];
then
	printf "${GREEN}Regenerating domains...\n${NC}"
	go run generator.go
	printf "${GREEN}Formatting result code...\n${NC}"
	./gradlew ktlintFormat
	printf "${GREEN}Checking if code is formatted...\n${NC}"
	./gradlew ktlint
	printf "${GREEN}Commiting changes...\n${NC}"
	git add .
	git commit -m "Update to newest protocol"
	git push origin
	printf "${GREEN}Releasing new version!\n${NC}"
	./gradlew release
	printf "${GREEN}All done!\n${NC}"

else
	printf "${GREEN}No changes to the protocol.\n${NC}"
fi
