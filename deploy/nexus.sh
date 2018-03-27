echo "nexusUsername=$sonatypeUser\nnexusPassword=$sonatypePassword\nsigning.keyId=$signingKeyId\nsigning.password=$signingPassword\nsigning.secretKeyRingFile=$TRAVIS_BUILD_DIR/deploy/private.gpg" > gradle.properties

./gradlew uploadArchives -i
./gradlew closeAndPromoteRepository