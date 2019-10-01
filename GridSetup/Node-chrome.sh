if [ -z "$1" ] && [ -z "$2" ]
then
var1="localhost"
var2="localhost"
else 
var1=$1
var2=$2
fi

java -jar selenium-server-standalone-3.4.0.jar -role webdriver -hub http://$var1:4444/grid/register -hubHost $var1 -host $var2 -port 5556 -browser  "browserName=chrome, version=ANY, maxInstances=10, platform=WINDOWS" 
