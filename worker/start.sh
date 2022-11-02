#!/bin/bash

rm -r /kafka/tools/build/dependant-libs-2.13.6/slf4j-log4j12-1.7.30.jar
rm -r /kafka/trogdor/build/dependant-libs-2.13.6/slf4j-log4j12-1.7.30.jar
rm -r /kafka/connect/api/build/dependant-libs/slf4j-log4j12-1.7.30.jar
rm -r /kafka/connect/transforms/build/dependant-libs/slf4j-log4j12-1.7.30.jar
rm -r /kafka/connect/runtime/build/dependant-libs/slf4j-log4j12-1.7.30.jar
rm -r /kafka/connect/mirror/build/dependant-libs/slf4j-log4j12-1.7.30.jar
rm -r /kafka/connect/mirror-client/build/dependant-libs/slf4j-log4j12-1.7.30.jar
rm -r /kafka/connect/json/build/dependant-libs/slf4j-log4j12-1.7.30.jar
rm -r /kafka/connect/basic-auth-extension/build/dependant-libs/slf4j-log4j12-1.7.30.jar


touch ccc.txt
echo "siema" >> ccc.txt

javac SolutionExecutor.java
java SolutionExecutor "CODE" "COMMANDS" "FILENAME"
