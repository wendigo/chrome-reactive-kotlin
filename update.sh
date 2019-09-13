#!/bin/bash
GREEN='\033[0;32m'
NC='\033[0m'

# based on https://github.com/cyrus-and/chrome-remote-interface/blob/master/scripts/update-protocol.sh
set -e
version="master"

trap "rm -f '$browser' '$js'" EXIT

base='https://chromium.googlesource.com'
printf "${GREEN}Fetching:\n\t/chromium/src/+/$version/third_party/blink/renderer/core/inspector/browser_protocol.pdl?format=TEXT...${NC}\n"
curl -s "$base/chromium/src/+/$version/third_party/blink/renderer/core/inspector/browser_protocol.pdl?format=TEXT" | base64 --decode >"browser_protocol.pdl"
printf "${GREEN}\t/chromium/src/third_party/+/$version/inspector_protocol/convert_protocol_to_json.py?format=TEXT...${NC}\n"
curl -s "$base/chromium/src/third_party/+/$version/inspector_protocol/convert_protocol_to_json.py?format=TEXT" | base64 --decode >"convert_protocol_to_json.py"
printf "${GREEN}\t/chromium/src/third_party/+/$version/inspector_protocol/pdl.py?format=TEXT...${NC}\n"
curl -s "$base/chromium/src/third_party/+/$version/inspector_protocol/pdl.py?format=TEXT" | base64 --decode >"pdl.py"
printf "${GREEN}\t/chromium/src/third_party/WebKit/Source/platform/v8_inspector/+/a117c39c831a16088e7adf6b8ddee2607dad7039/js_protocol.json?format=TEXT...${NC}\n"
curl -s "$base/chromium/src/third_party/WebKit/Source/platform/v8_inspector/+/a117c39c831a16088e7adf6b8ddee2607dad7039/js_protocol.json?format=TEXT" | base64 --decode >"v8_protocol.json"

python convert_protocol_to_json.py browser_protocol.pdl browser_protocol.json

printf "${GREEN}Merging files v8_protocol.json, browser_protocol.json into protocol.json${NC}\n"

node -p '
    const protocols = process.argv.slice(1).map((path) => JSON.parse(fs.readFileSync(path)));
    protocols[0].domains.push(...protocols[1].domains);
    JSON.stringify(protocols[0], null, 4);
' "v8_protocol.json" "browser_protocol.json" >protocol.json

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
	git commit -m "Updated to newest protocol"
	git push origin
	printf "${GREEN}All done!\n${NC}"

else
	printf "${GREEN}No changes to the protocol.\n${NC}"
fi
