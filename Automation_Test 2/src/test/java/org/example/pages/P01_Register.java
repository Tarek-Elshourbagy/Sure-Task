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
