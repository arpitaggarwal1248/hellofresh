# INTRODUCTION

A test automation framework that can be used for API,UI and Integration testing using JAVA.

# GETTING STARTED

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## PREREQUISITES:

```
JAVA-8.0 minimum
MAVEN
TestNG
```

## INSTALLATION:

### Java

#### Windows:
Go to page and download java executor. [Download-Link](https://java.com/en/download/manual.jsp/)
```
*   Run executor and install java.
```

#### Ubuntu:
```
*   sudo apt-get update
*   sudo apt-get install default-jdk
```

#### Mac:
```
*  brew cask install java
```

### Maven

#### Windows:
Visit [Maven official website](http://maven.apache.org/download.cgi)
, download the Maven zip file, for example : apache-maven-3.6.0-bin.zip.
```
*   Add a MAVEN_HOME system variables,
*   To verify, type mvn –version
```
### Ubuntu:
```
$ sudo apt install maven
$ mvn –version
```
### Mac:
```
$ brew install maven
$ mvn –version
```

## RUNNING TEST:

#### To run API test:

Go to path
```
./testxml/APIXml/{xmlname}.xml
```
Right click and run as TestNG, 
for eg: ./testxml/APIXml/APITestGetAll.xml

#### To run UI test:

Go to path
```
./testxml/UIXml/{xmlname}.xml
```
Right click and run as TestNG, 
for eg: ./testxml/UIXml/UITest.xml

## RUNNING TEST BY CONFIGURING ENVIRONMENT:
If you want to set environment at runtime like PROD,QA. default environment is PROD.

#### To run API test:

Go to path of project directory
```
cd helloFreshAutomation
```

run below command to run test using maven
```
mvn clean test -Denv=prod -DSUITE_NAME=APIXml/{xmlname}.xml
```

#### To run UI test:

Go to path of project directory
```
cd helloFreshAutomation
```
run below command to run test using maven
```
mvn clean test -Denv=qa -DSUITE_NAME=UIXml/{xmlname}.xml
```
#### Please note:
This can also be configured on jenkins, using two parameter variables
```
*  SUITE_NAME
*  env
```

## RUNNING TEST IN PARALLEL
Go to folder GridSetup in project directory and run below files
#### For windows:
```
Hub.bat & Node-chrome.bat
```

#### For linux and mac run shell script
```
Hub.sh & Node-chrome.sh
```
##### Dont forget to add parallel methods or test in test xml and thread-count. Sample present in UIXml folder with file name UITestParallel.xml


## LOGGING:
Log4j is used for logging purpose.

## REPORTING:
Extent reports are used for reporting, report can be found at below path
```
Path: /TestReport/Test-Automaton-Report.html
```
