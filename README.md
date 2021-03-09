# Cucumber-Java-API

Cucumber-Java framework for testing APIs. Make use of https://github.com/sitture/env-config repo and maven profiles to run tests in multiple configs and environments.

## Dependencies
- Java
- Cucumber plugin for IDE
- Maven

## Usage
To compile and download dependencies:

``mvn clean test-compile -U``

To run all tests using `default` config:

``mvn clean test``

To run tests using profiles:

``mvn clean test -P <PROFILE>``

For example:

``mvn clean test -P integration``

##TODO:
- implement tags in the profiles 
- add additional tests
