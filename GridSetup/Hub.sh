if [ -z "$1" ]
then
var1="localhost"
else 
var1=$1
fi
java -jar selenium-server-standalone-3.4.0.jar -role hub

