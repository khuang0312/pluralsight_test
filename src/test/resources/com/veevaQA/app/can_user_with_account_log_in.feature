Feature: Can user with account login?
  Users with an existing account should be able to login.

  Scenario: Logging in with an existing account
    Given I am on the login page
    When I put my username and password
    Then I should be on the main page