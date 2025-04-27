package org.example.pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Step_def.TC08_Wishlist;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.Step_def.Hooks.driver;

public class P08_Wishlist {
    public List<WebElement> iteams (){
        return driver.findElements(By.xpath("//*[@title='Add to wishlist']"));
    }
    public void clecking_on_wishlist(){
        driver.findElement(By.xpath("//*[@class='ico-wishlist']")).click();
    }
    public void close(){
        driver.findElement(By.xpath("//*[@class='close']")).click();
    }
    public WebElement items_name(){
        return driver.findElement(By.xpath("//*[@class='product-name']"));
    }
    public WebElement items_number(){
        return driver.findElement(By.xpath("//*[@class='wishlist-qty']"));
    }
}
