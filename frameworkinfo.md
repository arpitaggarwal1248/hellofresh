## FRAMEWORK INSIGHT
Purpose of this document is to give detailed info about the  framework

## GETTING STARTED
Framework is based on java and can be used for UI,API and Integration testing.

## TECH STACK
```
Java
Maven
Selenium
Rest-assured
Jackson parser
TestNG
Extent reports
```
*******************
## FRAMEWORK STRUCTURE

### src/main/java

Contains all java classes and helper files.
for eg: Utilities, Listeners, UI Pages, API Pojo etc.

### src/test/java
Contains all test files and dataProviders.

### src/main/resources
Contains yaml and config files based on environment

### testxml
All testxml for running test using TestNG.

### TestReport
Extent reports for run is generated here.

### Reporting
Extent reports config files is present here.

### pom.xml
All dependencies are added here.
*****************
## FRAMEWORK HIGHLIGHTS

### Cache
A cache is created that can be used to store any information that may be required during the automation run. For eg. Environment

Similarly a product cache is also created that is reading data from a YAML file, which contains product information from different categories (Women category, Men category)

Jackson YAML parser is used to read data from YAML file.

### Enums and Constants

Various Enums and constants are used for eg: Browser, Environment and some constants for API and UI.

### Screenshot for Failed test cases

For every failed test case in UI, screenshot will be taken and image is converted into base64. This skips the complexity of uploading an image over email in case of reporting emails.

### Random Test data
Random data is generated for each test case, either it is a mobile number, email or name of a user.

### Parallel runs
Test cases can be run in parallel mode using selenium grid

****************
## EXTERNAL LIBRARIES

Few external libraries are used in this framework, names and their purpose is as follows:

#### Jackson Parser
For parsing JSON response of an API.

#### Rest Assured
For hitting and getting response of various API's

#### TestNG
A testing framework for java programming language, with features like annotations, data provider, factory and many more.

#### Selenium
For UI Automation on a web browser.

#### Extent reports
For create a test report

#### Log4j
For logging.

#### Jackson yaml
For parsing or reading a YAML file.

#### Maven surefire plugin
To run project tests. Also it give us flexibility to configure some properties at runtime like testxml, variables and properties.





