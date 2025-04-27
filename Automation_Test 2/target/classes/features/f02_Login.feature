@smoke
Feature: Login_ user could login to the system with valid account
  Scenario: Valid login
    Given Navigate to URL website
    And Go to login page
    When Enter email and password "tarek98@gmail.com" "123456789"
    And Click on login icon
    Then Verify that the user had login successfully

  Scenario: inValid login
    Given Navigate to URL website
    And Go to login page
    When Enter invalid email and password "tarek9@gm" "ttttr"
    And Click on login icon
    Then Verify that the user had not login successfully

  Scenario: Empty login
    Given Navigate to URL website
    And Go to login page
    When Enter Empty email and password
    And Click on login icon
    Then Verify that the empty user had not login successfully