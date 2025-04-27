package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

import static org.example.Step_def.Hooks.driver;

public class P06_homeSliders {

        public List<WebElement> sliders() {
            return driver.findElements(By.xpath("//*[@class='nivo-imageLink']"));
    }
}
