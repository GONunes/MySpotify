cd src/ 
find -name "*.java" > ./../bin/compile.txt 
javac -cp ".;./../libs/sqlite-jdbc-3.30.1.jar" -d ./../bin/ @./../bin/compile.txt
cd ./../bin/
rm -rf compile.txt
clear
java -Dfile.encoding=UTF-8 -cp ".;./../libs/sqlite-jdbc-3.30.1.jar" application.App
