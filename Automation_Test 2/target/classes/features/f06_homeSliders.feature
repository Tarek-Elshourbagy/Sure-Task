@smoke
  Feature: clicking on one of slider which you find two sliders when you open home page
    Scenario Outline: slider is clickable on home page
      Given navigation to the website
      Then you clicking on one of two slider you will go to its page "<slider>"
      Examples:
        | slider |
        | block |
