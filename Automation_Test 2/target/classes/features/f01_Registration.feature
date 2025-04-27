@smoke
Feature: Registration for the new user to create new account
  Scenario: Enter all valid data (user name, password, email, birth date ,Gender)
    Given Enter the URL to navigate to the website
    When Press for icon register to Create new account to go to the sign up page
    And Choose your correct Gender (male or female)
    And Enter the first name "tarek"
    And Enter the last name "sameh"
    And Choose your birthdate from the calender
    And Enter your valid Email "tarek98@gmail.com"
    And Enter your company name
    And Click on newsletter
    And Enter a new valid password "123456789"
    And Press on register icon to go for the next page
    Then click om signin to go to home page of the website will open successfully





