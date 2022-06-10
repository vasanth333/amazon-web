
# Amazon Web Automation


Search a product and If the "About this item" section is present in a product, log the text of this section to the console/report.

# Framework Design pattern

## Appendix

The framework was designed using a page object model approach.

## Author

- [@Vasanthakumar](https://www.github.com/octokatherine)


## Framework Layers 
## src/main/java

This Framework has the following design layers

```bash
  **com.amazon.DriverFactory
    Locally and in a Docker container, a driver session will be created.
```

```bash
  **com.amazon.testBase
    Explicit waits and Extend reports logics are included in this package.
```

```bash
  **com.amazon.utils
    This package includes web page operations such as Click, Send Keys, getText, and some reused logics.
```

```bash
  **com.amazon.testListeners
    The Test Listeners class monitors all test execution operations and logs the output in Extent reports.

```

```bash
  **com.amazon.pageObjects
    Each webpage action was segregated into a different class to identify, resue idea.
```

## src/test/java
```bash
  **com.amazon.Tests
    Based on the @Test annotations and grouping of test cases, actual test execution will begin from this package.
```
## src/test/resources/WebElements

```bash
  **com.amazon.Tests
   All web page elements segregated and stored in a .Properties file.
```

## Running Tests locally
** Maven 

To run tests in maven, run the following command

```bash
Navigate to project folder location 
  example: cd /Users/vasanth/eclipse-workspace/com.amazon
  run.   : mvn test 
```


To run tests in testng.xml, follow the given steps


** testng.xml

```bash
Navigate to src/test/resources/config.properties
  1.Specify the type of browser in config.properties file "browser= chrome"
  2.Open testng.xml file and right click >> Runas >> TestNg Suite
```

## Running Tests in docker
```bash
Use docker-compose.yml file for setting up Hub and Node

Navigate to src/test/resources/config.properties
  1.Specify the type of browser in config.properties file "browser= firefox"
  2.Open testng.xml file and right click >> Runas >> TestNg Suite

```

## Reports
```bash
All html reports from test execution will be saved in the Reports folder.
```
## Import projects from git

Clone the project

```bash
  git clone https://link-to-project
```

Go to the project directory

```bash
  cd my-project
```

Install dependencies

```bash
 mvn clean
 mvn install
 mavn build
```

Start the Test Execution 

```bash
  mvn test
```

