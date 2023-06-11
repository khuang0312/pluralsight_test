# About this project

I wanted to explore modern QA practices in Java using Java 11, Selenium, Cucumber, JUnit 5, and Pluralsight. Through this project, I learned a lot about writing functional test cases, behavior-driven development, the page object model in Selenium, implementation of Unicode characters, and managing projects using Maven and Gradle.

# Important files to pay attention to

1. `Functional Test Cases.md` has written functional test cases.
2. `Anagram.java` has a method that detects whether two words of anagrams of each other. `AnagramTest.java` tests the functionality of said method.
3. `can_user_with_account_log_in.feature` outlines a specification of a Cucumber scenario to test. `UserWithAccountLoginStepDefinitions.java` implements the automated testing of said scenario.

# How to get it to work

1. Create a Pluralsight account and assign values to environment variables `PLURALSIGHT_USERNAME` and `PLURALSIGHT_PASSWORD`.
2. Use Maven to install and run the project.
3. `mvn test` to run the Cucumber and JUnit tests.
