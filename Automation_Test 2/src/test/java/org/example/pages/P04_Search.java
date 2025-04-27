package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.Step_def.Hooks.driver;

public class P04_Search {
    public WebElement login_before() {  //login icon before
        return driver.findElement(By.className("ico-login"));
    }
    public WebElement Email(){ //valid Email

        return driver.findElement(By.className("email"));
    }
    public WebElement password(){ //valid password

        return driver.findElement(By.className("password"));
    }
    public WebElement login_after() {  //login icon after
        return driver.findElement(By.className("login-button"));
    }
    public WebElement search() {
        return driver.findElement(By.id("small-searchterms"));
    }
    public WebElement search_icon() {
        return driver.findElement(By.className("search-box-button"));
    }

    public List<WebElement> Iteams_count () {
        return driver.findElements(By.className("product-title"));
    }
    public WebElement product_item () {
        return driver.findElement(By.className("product-item"));
    }
    public WebElement sku_item () {
        return driver.findElement(By.id("sku-4"));
    }
}
