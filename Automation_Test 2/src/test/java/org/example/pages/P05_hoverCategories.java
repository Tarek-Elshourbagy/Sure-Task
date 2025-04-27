package org.example.pages;

import org.example.Step_def.TC05_hoverCategories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.Step_def.Hooks.driver;

public class P05_hoverCategories {
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
    public List<WebElement> Main_Element(){
        return driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li"));
    }
    public List<WebElement> Computer_subtitles (){
        return driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li[1]/ul[@class='sublist first-level']/li/a"));
    }
    public List<WebElement> Electroncis_subtitles (){
        return driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul[@class='sublist first-level']/li/a"));
    }
    public List<WebElement> Apparel_subtitles (){
        return driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li[3]/ul[@class='sublist first-level']/li/a"));
    }
    public WebElement Sub_Title(){
        return driver.findElement(By.xpath("//div[@class='page-title']"));
    }

}
