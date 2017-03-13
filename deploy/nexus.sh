echo "Uploading archives"
./gradlew -i uploadArchives -PnexusUsername=$sonatypeUser -PnexusPassword=$sonatypePassword -Psigning.keyId=$signingKeyId -Psigning.password=$signingPassword -Psigning.secretKeyRingFile=$TRAVIS_BUILD_DIR/deploy/private.gpg
echo "Promoting repository"
./gradlew -i closeAndPromoteRepository -PnexusUsername=$sonatypeUser -PnexusPassword=$sonatypePassword