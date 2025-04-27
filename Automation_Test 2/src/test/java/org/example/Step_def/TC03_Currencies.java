package org.example.Step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_Currencies;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.example.Step_def.Hooks.driver;
public class TC03_Currencies {
    //Objects
    P03_Currencies concurrency_obj = new P03_Currencies();
    @Given("go to the website") //open the website
    public void enter_the_url_to_navigate_to_the_website() {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }
    @And("make sure that you enter a valid password and Email to enter to the home page successfully {string} {string}")
    public void login_by_valid_data(String email,String password) {
        concurrency_obj.login_before().click(); //to go to login page
        concurrency_obj.Email().sendKeys(email); //mail
        concurrency_obj.password().sendKeys(password);   //password
        concurrency_obj.login_after().click(); //to go to home page
    }
    @When("Press to change the currency from US dollar to Euro")
    public void Change_the_concurrency() {
        Select price_dropdown = new Select(concurrency_obj.concurrency_dropdown());
        price_dropdown.selectByIndex(1); // change from US to Euro
    }
    @Then("Make sure that the four products in the home page has been changed from US to Euro")
    public void make_sure_four_probuct_have_EuroPrice(){
        for(int item_no = 0; item_no < concurrency_obj.number_of_homepage_items().size();item_no++){ //passing through each item in the home page
            String price_item = concurrency_obj.number_of_homepage_items().get(item_no).getText(); //get the price text for each items
            Assert.assertTrue(price_item.contains("€")); // check that each item contain euro sign
        }
    }
}
