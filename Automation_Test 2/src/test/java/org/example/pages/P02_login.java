package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.example.Step_def.Hooks.driver;

public class P02_login {
    public WebElement login() {  //login icon
        return driver.findElement(By.className("ico-login"));
    }
    public WebElement login_after_username_password() {  //login icon after
        return driver.findElement(By.className("login-button"));
    }
    public WebElement username(){ //Username

        return driver.findElement(By.className("email"));
    }
    public WebElement password(){ //password

        return driver.findElement(By.className("password"));
    }
    public WebElement myaccont(){ //validation
        return driver.findElement(By.className("ico-account"));
    }
    public WebElement invalidation_massage(){
        return driver.findElement(By.className("message-error"));
    }
    public WebElement invalidation_empty_massage(){
        return driver.findElement(By.id("Email-error"));
    }
}
