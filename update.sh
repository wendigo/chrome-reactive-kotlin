#!/bin/bash
GREEN='\033[0;32m'
NC='\033[0m'

# based on https://github.com/cyrus-and/chrome-remote-interface/blob/master/scripts/update-protocol.sh
set -e

browser="browser_protocol.json"
js="js_protocol.json"
version="master"

trap "rm -f '$browser' '$js'" EXIT

base='https://chromium.googlesource.com'
printf "${GREEN}Fetching:\n\t/chromium/src/+/$version/third_party/blink/renderer/core/inspector/browser_protocol.pdl?format=TEXT...${NC}\n"
curl -s "$base/chromium/src/+/$version/third_party/blink/renderer/core/inspector/browser_protocol.pdl?format=TEXT" | base64 --decode >"browser_protocol.pdl"
printf "${GREEN}\t/chromium/src/third_party/+/$version/inspector_protocol/convert_protocol_to_json.py?format=TEXT...${NC}\n"
curl -s "$base/chromium/src/third_party/+/$version/inspector_protocol/convert_protocol_to_json.py?format=TEXT" | base64 --decode >"convert_protocol_to_json.py"
printf "${GREEN}\t/chromium/src/third_party/+/$version/inspector_protocol/pdl.py?format=TEXT...${NC}\n"
curl -s "$base/chromium/src/third_party/+/$version/inspector_protocol/pdl.py?format=TEXT" | base64 --decode >"pdl.py"

python convert_protocol_to_json.py browser_protocol.pdl protocol.json

git --no-pager diff protocol.json

if [[ -n $(git status -s) ]];
then
	printf "${GREEN}Regenerating domains...\n${NC}"
	go run generator.go
	printf "${GREEN}Formatting result code...\n${NC}"
	./gradlew formatKotlin
	printf "${GREEN}Checking if code is formatted...\n${NC}"
	./gradlew lintKotlin
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
