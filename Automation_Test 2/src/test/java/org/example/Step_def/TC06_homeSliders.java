package org.example.Step_def;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P06_homeSliders;
import org.testng.Assert;

import static org.example.Step_def.Hooks.driver;

public class TC06_homeSliders {
    P06_homeSliders slider_obj = new P06_homeSliders();

    @Given("navigation to the website")
    public void navigation_to_the_website() {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @Then("you clicking on one of two slider you will go to its page {string}")
    public void you_clicking_on_one_of_two_slider_you_will_go_to_its_page(String slider) throws InterruptedException {
        Thread.sleep(2000);
        if (slider.contains("block")) {
            slider_obj.sliders().get(0).click();
            String currenturl = driver.getCurrentUrl();
            if (currenturl.contains("https://demo.nopcommerce.com/iphone14")) {
                Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/iphone14");
            } else {
                System.out.println("an error had be found");
            }
        }else{
            slider_obj.sliders().get(1).click();
            String currenturl = driver.getCurrentUrl();
            if (currenturl.contains("https://demo.nopcommerce.com/GalaxyS22")) {
                Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/GalaxyS22");
            } else {
                System.out.println("an error had be found");
            }
        }
    }
}
