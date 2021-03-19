#!/usr/bin/env bash
set -xeuo pipefail

GREEN='\033[0;32m'
NC='\033[0m'

# based on https://github.com/cyrus-and/chrome-remote-interface/blob/master/scripts/update-protocol.sh
# version="master"
version="219a9d66a51e135d96e261ebbe6bf385dc11389b" # pin to version for now
REPOSITORY_PATH="https://${ACCESS_TOKEN}@github.com/${GITHUB_REPOSITORY}.git"

trap "rm -f 'browser_protocol.json' 'js_protocol.json'" EXIT

base='https://raw.githubusercontent.com/ChromeDevTools/devtools-protocol'
printf "${GREEN}Fetching:\n\t/$version/json/browser_protocol.json...${NC}\n"
curl -s "$base/$version/json/browser_protocol.json" >"browser_protocol.json"
printf "${GREEN}Fetching:\n\t/$version/json/js_protocol.json...${NC}\n"
curl -s "$base/$version/json/js_protocol.json" >"js_protocol.json"

printf "${GREEN}Merging files js_protocol.json, browser_protocol.json into protocol.json${NC}\n"

git checkout master

node -p '
    const protocols = process.argv.slice(1).map((path) => JSON.parse(fs.readFileSync(path)));
    protocols[0].domains.push(...protocols[1].domains);
    JSON.stringify(protocols[0], null, 4);
' "js_protocol.json" "browser_protocol.json" >protocol.json

git --no-pager diff protocol.json

if [[ -n $(git status -s) ]];
then
	printf "${GREEN}Regenerating domains...\n${NC}"
	go get -u -v github.com/aymerick/raymond
	go run generator.go
	printf "${GREEN}Formatting result code...\n${NC}"
	./gradlew formatKotlin
	printf "${GREEN}Checking if code is formatted...\n${NC}"
	./gradlew lintKotlin
	printf "${GREEN}Commiting changes...\n${NC}"
	git config --global user.name 'Mateusz Gajewski' && git config --global user.email 'mateusz.gajewski@gmail.com'
	git add .
	git commit -m "Automatically updated to newest protocol"
	git push $REPOSITORY_PATH master
	printf "${GREEN}All done!\n${NC}"

else
	printf "${GREEN}No changes to the protocol.\n${NC}"
fi
