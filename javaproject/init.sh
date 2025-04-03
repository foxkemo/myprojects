#!/bin/bash
echo "this script will delete the bin folder that is already exist , continue(y)?"
read choice
if [ "$choice" = "y" ]
then
if [ -d "bin" ]
then
rm -rf bin
fi
if [ -f "source.txt" ]
then
rm source.txt
fi
else
exit
fi
find src -name "*.java" > source.txt
javac -d bin @source.txt
jar --create --file myjar.jar --main-class com.mypack.ThreadTest  -C bin .
#jmod create --class-path myjar.jar mymod.jmod
rm source.txt
echo "it will run myjar.jar,continue(y)?"
read choice2;
if [ "$choice2" = "y" ]
then
java -jar myjar.jar
else
exit
fi
