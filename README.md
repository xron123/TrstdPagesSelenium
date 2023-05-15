# TrstdPagesSelenium
:

## How to Run the Selenium Project

This project is a Maven-based Selenium project with a POM structure. You can execute the tests using either the individual test file or the TestNG test suite file.

### Prerequisites
Before running the tests, make sure you have the following requirements met:
- Java Development Kit (JDK) installed on your machine
- Maven installed on your machine
- Web browsers (Chrome, Edge, Firefox) installed

### Steps to Run the Tests

1. Clone the repository to your local machine.
2. Open the project in your preferred IDE (such as Eclipse or IntelliJ).
3. Update the configurations in the `config.properties` file located in the `src/main/resources` folder. Modify the `browser` property to choose between Chrome, Edge, or Firefox.
4. Update the `testData` path in the `Base` class with the correct path to your test data files.
5. To run the tests individually:
   - Navigate to the `ProfilePageTestCases.java` file located in the `src/test/java/trustedShops/TestCases` folder.
   - Right-click on the file and select "Run" (or equivalent in your IDE).
6. To run the tests using TestNG test suite:
   - Open the `testNG.xml` file located in the project root directory.
   - Right-click on the file and select "Run As" > "TestNG Suite" (or equivalent in your IDE).
7. The tests will be executed, and you can view the test results in the IDE's console or test runner.

Make sure to review the test results and any console output for any failures or errors during the test execution.

Please note that the tests are designed to run with different web browsers. Ensure that the specified browser is installed on your machine before executing the tests.
If you feel, you need more enhancements like screenshot for failed test cases, reports, cucumber frame work please feel free to ask.
Thank you very much.
