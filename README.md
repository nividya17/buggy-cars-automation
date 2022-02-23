# Buggy Cars Automation
Automation tests to verify various business flows in `Buggy Cars` web application. The tests are written in groovy based [spock framework](https://spockframework.org/)
with `Selenium` for web automations. All `Page Object Models` are written in Java.

## Known Security Best Practice Violations
`.env` files should not be committed in git repo as they are bound to contain secured credentials like DB passwords and various environment specific information.
Ideally the `.env` file should be created on the fly from CI/CD pipelines and used only during the duration of tests and cleaned-up
immediately. CI/CD is not integrated in this project yet and `.env` file is committed to repo only to make the local testing execution a bit seamless

## Cross browser Testing
All tests were run only in google chrome as the main functionalities do not work in other browsers. Refer to manual testing report for detailed information
We could look at integrating with [Browserstack](https://www.browserstack.com/) for all cross-browser testing needs.

## Running Locally

### Install JDK
This project requires JDK 11 or higher. If JAVA is not installed in your machine, then refer to detailed instructions in [this_link](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html) for your platform of choice (Windows/Linux/Macos)

### Running from Command line
1. Clone the source code from github repository into any direcotry of your choice (For example: /Users/tester)
2. Goto to the cloned repository `cd /Users/tester/buggy-cars-automation`
3. Please make sure chrome is set as your default browser as the core-functionalities does not work in other browsers as mentioned in `Cross Browser Testing` section above
4. Run command `./mvnw clean test` if you are in (Linux/MacOs platform) or `mvnw.cmd clean test` if in Windows.
5. Once the tests are complete, you can find the test reports in `/Users/tester/buggy-cars-automation/build/spock-reports/index.html` file. You can traverse through various test case executions in the report.
   An execution report `test-execution-report.pdf` is also attached in repo for reference only. Ideally these file will not be committed in repo rather attached/upload to CI/CD test runs

### Running from IDE
1. Clone the source code from github repository into any direcotry of your choice (For example: /Users/tester)
2. Open the project in IDE of your choice (InteliJ/VS Code etc)
3. Goto any of the test class present in `src/test/groovy/nz.co.buggycars.tests` and right click and run. 
