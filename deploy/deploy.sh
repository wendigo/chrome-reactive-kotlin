#!/usr/bin/env bash
set -xeuo pipefail

./gradlew publishToSonatype -i -P githubToken=$GITHUB_ACCESS_TOKEN
./gradlew closeAndReleaseRepository -i -P githubToken=$GITHUB_ACCESS_TOKEN