package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.Step_def.Hooks.driver;

public class P07_followUs {
    public List<WebElement> Icons(){
        return driver.findElements(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li"));
    }
}
