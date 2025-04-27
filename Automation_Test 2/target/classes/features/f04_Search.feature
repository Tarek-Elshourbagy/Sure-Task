@smoke
  Feature: Search for product in the website
    Scenario: user could search using product name (book,laptop,nike)
      Given navigate to the website
      When Enter a valid data to login to the home page "tarek98@gmail.com" "123456789"
      Then you start the search for the product [book,laplop,nike]

    Scenario: user could search for product using sku
      Given navigate to the website
      When Enter a valid data to login to the home page "tarek98@gmail.com" "123456789"
      And Enter the sku for the product in search bar
      And press on the product which had been found to moke to anther page
      Then make sure it contains the sku that you are using in search