package org.example.Step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.testng.Assert;
import static org.example.Step_def.Hooks.driver;
public class TC02_Login {
    P02_login Login = new P02_login();
    @Given("Navigate to URL website")
    public void navigation(){
        // Navigate to URL
        driver.navigate().to("https://demo.nopcommerce.com/");
    }
    @And("Go to login page")
    public void login_page(){
        Login.login().click();
    }
    @When("Enter email and password {string} {string}")
    public void valid_email_password(String email ,String password){
        //valid username
        Login.username().sendKeys(email);
        //valid password
        Login.password().sendKeys(password);
    }
    @When("Enter invalid email and password {string} {string}")
    public void invalid_email_password(String invemail ,String invpassword){
        //invalid username
        Login.username().sendKeys(invemail);
        //invalid password
        Login.password().sendKeys(invpassword);
    }
    @When ("Enter Empty email and password")
    public void  empty_mail_password(){
        //empty mail
        Login.username().sendKeys("");
        //empty password
        Login.password().sendKeys("");
    }
    @And("Click on login icon")
    public void Clicking_login(){
        // click on login icon after enter username and password
        Login.login_after_username_password().click();
    }
    @Then("Verify that the user had login successfully")
    public void Login_successfully() {
        Assert.assertTrue(Login.myaccont().isDisplayed());
    }
    @Then("Verify that the user had not login successfully")
    public void Login_insuccess(){
        Assert.assertTrue(Login.invalidation_massage().isDisplayed());
    }
    @Then("Verify that the empty user had not login successfully")
    public void Login_empty_insuccess(){
        Assert.assertTrue(Login.invalidation_empty_massage().isDisplayed());
    }
}
