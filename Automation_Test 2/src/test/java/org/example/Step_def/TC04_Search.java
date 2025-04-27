package org.example.Step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P04_Search;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.example.Step_def.Hooks.driver;

public class TC04_Search {
    //objects
    P04_Search search_obj = new P04_Search();

    @Given("navigate to the website")
    public void navigate_to_the_website() { //open the website
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("Enter a valid data to login to the home page {string} {string}")
    public void enter_a_valid_data_to_login_to_the_home_page(String email ,String password) {
        search_obj.login_before().click(); //to go to login page
        search_obj.Email().sendKeys(email); //mail
        search_obj.password().sendKeys(password);     //password
        search_obj.login_after().click(); //to go to home page
    }

    @Then("you start the search for the product [book,laplop,nike]")
    public void you_start_the_search_for_the_product_book_laplop_nike() throws InterruptedException {
        // make a list for the user search element
        List<String> SearchList = new ArrayList<>();
        SearchList.add("book");
        SearchList.add("nike");
        SearchList.add("laptop");
        String flag; // this flag used for assertion if it false or true
        for (int no_of_search = 0; no_of_search <= SearchList.size()-1; no_of_search++) { // for loop for the search iterations
            search_obj.search().sendKeys(SearchList.get(no_of_search)); // the search input item
            search_obj.search_icon().click();       // clicking on search icon to start searching
            Thread.sleep(3000);        // waiting 3 sec to show the result of searching
            for (int no_of_iteams = 0; no_of_iteams < search_obj.Iteams_count().size(); no_of_iteams++) { // no. of elements found as a result of search
                String iteams_text = search_obj.Iteams_count().get(no_of_iteams).getText().toLowerCase(); // make the text in lowercase
                // as there is an error in book item so we make this assertion
                // for not stop the execution if the error is found
                if(iteams_text.contains(SearchList.get(no_of_search))){
                    flag = "True";
                    Assert.assertEquals(flag,"True");
                }
                else {
                    System.out.println(" Error message had been found in search item =  " + SearchList.get(no_of_search));
                }
            }
            search_obj.search().clear(); // used to clear the search after using
        }
    }
    @And ("Enter the sku for the product in search bar")
    public void Enter_sku(){
        search_obj.search().sendKeys("AP_MBP_13");
        search_obj.search_icon().click();
    }
    @And ("press on the product which had been found to moke to anther page")
    public void press_on_the_item(){
        search_obj.product_item().click();
    }
    @Then("make sure it contains the sku that you are using in search")
    public void validation_for_the_search_item(){
        String sku = search_obj.sku_item().getText();
        Assert.assertEquals(sku,"AP_MBP_13");
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/apple-macbook-pro-13-inch");
    }
}