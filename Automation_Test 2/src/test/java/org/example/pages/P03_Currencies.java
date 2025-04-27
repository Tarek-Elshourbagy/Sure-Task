package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.Step_def.Hooks.driver;

public class P03_Currencies {
    public WebElement login_before() {  //login icon before
        return driver.findElement(By.className("ico-login"));
    }
    public WebElement login_after() {  //login icon after
        return driver.findElement(By.className("login-button"));
    }
    public WebElement Email(){ //valid Email

        return driver.findElement(By.className("email"));
    }
    public WebElement password(){ //valid password

        return driver.findElement(By.className("password"));
    }
    public WebElement concurrency_dropdown(){ // concurrency drop down list to choose euro
        return driver.findElement(By.id("customerCurrency"));
    }
    public List<WebElement> number_of_homepage_items(){ // number of items price's is euro in the homepage
        return driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[1]/div/div[2]/h2/a"));
    }
}
