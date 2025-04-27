@smoke
Feature: users could open followUs links
  Scenario Outline: user opens link
    Given run to the website
    Then clicking on the links and make sure for the validation for each case "<icon>"
    Examples:
    |icon|
    | Facebook_icon |
    | Twitter_icon  |
    | rcc_icon      |
    | Youtube_icon  |
