package org.example.Step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Register;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import static org.example.Step_def.Hooks.driver;
public class TC01_Registeration {
    P01_Register registeration = new P01_Register();
    @Given("Enter the URL to navigate to the website") //open the website
    public void enter_the_url_to_navigate_to_the_website() {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }
    @When("Press for icon register to Create new account to go to the sign up page") //press on register icon before
    public void press_for_icon_create_new_account_to_go_to_the_sign_up_page() {
        registeration.RegisterIcon_before().click();
    }
    @And("Choose your correct Gender \\(male or female)") //choose the gender
    public void choose_your_correct_gender_male_or_female() {
        registeration.Gender_male().click();
    }
    @And("Enter the first name {string}") //choose your first name
    public void enter_the_first_name(String m) {
        registeration.First_Name().sendKeys(m);
    }
    @And("Enter the last name {string}") //choose your last name
    public void enter_the_last_name(String sameh) {
        registeration.Last_Name().sendKeys(sameh);
    }
    @And("Choose your birthdate from the calender") // birthday
    public void choose_your_birthdate_from_the_calender() {
        Select Day = new Select(registeration.Day());
        Day.selectByIndex(21);
        Select Month = new Select(registeration.Month());
        Month.selectByIndex(11);
        Select Year = new Select(registeration.Year());
        Year.selectByIndex(48);
    }
    @And("Enter your valid Email {string}") //valid email
    public void enter_your_valid_email(String email) {
        registeration.Email().sendKeys(email);
    }
    @And ("Enter your company name") //company name
    public void enter_company_name(){
        registeration.Company_Name().sendKeys("ABC");
    }
    @And ("Click on newsletter")  //clicking on newsletter
    public void Click_on_newsletter(){
        registeration.Option().click();
    }
    @And("Enter a new valid password {string}") // enter your valid password
    public void enter_a_new_valid_password(String password) {
        registeration.New_password().sendKeys(password);
        registeration.Confirm_password().sendKeys(password);
    }
    @And("Press on register icon to go for the next page") //clicking on register icon after
    public void registeration_icon(){
        registeration.RegisterIcon_after().click();
    }
    @Then("click om signin to go to home page of the website will open successfully") //check the validation by color of message
    public void click_om_signin_to_go_to_home_page_of_the_website_will_open_successfully() {
        String color_for_the_message = registeration.Validation_message().getCssValue("color");
        String color_after_change = Color.fromString(color_for_the_message).asHex();
        Assert.assertEquals(color_after_change,"#4cb17c");
    }
}
