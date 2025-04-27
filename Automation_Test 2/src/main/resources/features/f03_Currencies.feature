@smoke
  Feature: Make sure that all website's products will be in Euro
    Scenario: make all the product on the website to be made by Euro currency
      Given go to the website
      And make sure that you enter a valid password and Email to enter to the home page successfully "tarek98@gmail.com" "123456789"
      When Press to change the currency from US dollar to Euro
      Then Make sure that the four products in the home page has been changed from US to Euro