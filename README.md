# Sure Task

## Rest-Assured-Project TEST 01
### User API Testing Project
This project is designed to test the various API endpoints of a user management system using RestAssured for API requests and TestNG for organizing and executing the tests. It also uses ExtentReports for generating detailed HTML reports after running the tests.

### Table of Contents
 - Overview
 - Technologies Used
 - Setup Instructions
 - Test Case Descriptions
 - Contributing
### Overview
This project includes test cases for performing CRUD operations (Create, Read, Update, Delete) on user data via a REST API. The tests are built using the TestNG framework, and RestAssured is used to interact with the API.

### Technologies Used
 - Java: Programming language used for writing test scripts.
 - RestAssured: A Java-based library for testing RESTful APIs.
 - TestNG: A testing framework used for running and organizing tests.
 - Maven: Dependency management tool to manage libraries and dependencies.
### Setup Instructions
#### Prerequisites:
 - Java 8 or above installed.
 - Maven installed for dependency management.
 - An IDE like IntelliJ IDEA, Eclipse, or VS Code to run the project.
### Test Case Descriptions
This project includes five test cases that interact with the API as follows:

#### TC_01_Create_User:
 - Description: Creates a new user via a POST request.
 - Verifications: Confirms the response status code is 201, and verifies the name and year fields in the response body.

#### TC_02_List_of_Users:
 - Description: Retrieves a list of users via a GET request.
 - Verifications: Checks the status code 200, ensures the per_page field is 6, the total number of users is 12, and that all users have an avatar URL.

#### TC_03_Search_for_User:
 - Description: Searches for a user by ID via a GET request.
 - Verifications: Ensures the correct user is returned, verifying the name in the response body.

#### TC_04_Update_user:
 - Description: Updates a user's information via a PUT request.
 - Verifications: Verifies that the user’s name and ID are correctly updated in the response body.

#### TC_05_Delete_user:
 - Description: Deletes a user via a DELETE request.
 - Verifications: Verifies that the user is successfully deleted, ensuring the response status code is 204 (No Content).

.................................................................................................................................................................................................

## Selenium Test Automation Project_Test 02

Ecommerce
#### Link :
[Demo Ecommerce](https://demo.nopcommerce.com/)
The project uses Selenium WebDriver for automation and includes both automated test cases and a traditional test plan.
## Project Structure
```
/selenium-test-automation
├── /src
│   ├── /main
│   │   ├── /java
│   │   ├── /resouces
│   │   │   ├── /Features
│   │   │   │   ├── f01_Registration.feature
│   │   │   │   ├── f02_Login.feature
│   │   │   │   ├── f03_Currencies.feature
│   │   │   │   ├── f04_Search.feature
│   │   │   │   ├── f05_HoverCategories.feature
│   │   │   │   ├── f06_Homesliders.feature
│   │   │   │   ├── f07_FolluwUS.feature
│   │   │   │   ├── f08_Wishlist.feature
│   │   │   ├── /WebDriver
│   ├── /test
│   │   ├── /java
│   │   │   ├── /example
│   │   │   │   ├── /Pages
│   │   │   │   │   ├── P01_Registration
│   │   │   │   │   ├── P02_Login
│   │   │   │   │   ├── P03_Currencies
│   │   │   │   │   ├── P04_Search
│   │   │   │   │   ├── P05_HoverCategories
│   │   │   │   │   ├── P06_Homesliders
│   │   │   │   │   ├── P07_FolluwUS
│   │   │   │   │   ├── P08_Wishlist
│   │   │   │   ├── /Step_Def
│   │   │   │   │   ├── Hooks.java
│   │   │   │   │   ├── TC01_Registration
│   │   │   │   │   ├── TC02_Login
│   │   │   │   │   ├── TC03_Currencies
│   │   │   │   │   ├── TC04_Search
│   │   │   │   │   ├── TC05_HoverCategories
│   │   │   │   │   ├── TC06_Homesliders
│   │   │   │   │   ├── TC07_FolluwUS
│   │   │   │   │   ├── TC08_Wishlist
│   │   │   │   ├── /testRunner
│   │   │   │   │   ├── runner
├── pom.xml

```
## Configuration
### WebDriver Configuration HOOKS FILE
Edit the WebDriverConfig.java file to set the path to your WebDriver executable if it’s not in your system’s PATH:

```
package org.example.Step_def;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.concurrent.TimeUnit;

public class Hooks {
    public static ChromeDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver","D:\\Tarek_D\\TESTING\\projects\\ODC_GP_updated\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void quit() {
        driver.quit();
    }
}
```
## Test Cases
### using Cucamber to explain the test cases steps
    f01_Registration.feature
    
    f02_Login.feature
    
    f03_View_Account_balance.feature
    
    f04_Open_account.feature
    
    f05_Tranfer_funds.feature
```
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

```
## Page Object Model (POM)
### i used POM creating all locators in one class for each flow
```
package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.Step_def.Hooks.driver;


public class P01_Register {

    public WebElement RegisterIcon_before (){
        return driver.findElement(By.className("ico-register"));
    }
    public WebElement Gender_male (){
        return driver.findElement(By.id("gender-male"));
    }
    public WebElement Gender_female (){
        return driver.findElement(By.id("gender-female"));
    }
    public WebElement First_Name (){
        return driver.findElement(By.id("FirstName"));
    }
    public WebElement Last_Name (){
            return driver.findElement(By.id("LastName"));
    }
    public WebElement Day (){
            return driver.findElement(By.name("DateOfBirthDay"));
    }
    public WebElement Month (){
            return driver.findElement(By.name("DateOfBirthMonth"));
    }
    public WebElement Year (){
            return driver.findElement(By.name("DateOfBirthYear"));
    }
    public WebElement Email (){
            return driver.findElement(By.id("Email"));
    }
    public WebElement Company_Name (){
            return driver.findElement(By.id("Company"));
    }
    public WebElement Option (){
            return driver.findElement(By.id("Newsletter"));
    }
    public WebElement New_password (){
            return driver.findElement(By.id("Password"));
    }
    public WebElement Confirm_password (){
            return driver.findElement(By.id("ConfirmPassword"));
    }
    public WebElement RegisterIcon_after (){
            return driver.findElement(By.id("register-button"));
    }
    public WebElement Validation_message (){
            return driver.findElement(By.className("result"));
    }

}

```
### i linked each POM class with main class where we can provide an action with this locators
```
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

```
## Runner
### used to genarate all test cases to run in sequancy
```
package org.example.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                features = {"src/main/resources/features"},
                glue = {"Step_def"},
                tags = "@smoke",
                plugin = {
                        "pretty",
                        "html:target/cucumber.html",
                        "json:target/cucumber.json",
                        "junit:target/cukes.xml",
                        "rerun:target/rerun.txt"
                }
        )


public class runner extends AbstractTestNGCucumberTests {

}
```


