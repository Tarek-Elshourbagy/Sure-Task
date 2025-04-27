package org.example.Step_def;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P08_Wishlist;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Random;

import static org.example.Step_def.Hooks.driver;

public class TC08_Wishlist {

    P08_Wishlist wishlist_obj = new P08_Wishlist();
    @Given("go to the website and navigate to it")
    public void go_to_the_website_and_navigate_to_it() {
        driver.navigate().to("https://demo.nopcommerce.com");
    }
    @When("you click on any one of the product a green light with message will be appeared")
    public void you_click_on_any_one_of_the_product_a_green_light_with_message_will_be_appeared() {
            wishlist_obj.iteams().get(2).click();
            WebElement message_wait =  new WebDriverWait(driver, Duration.ofSeconds(10) ).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='content']")));
            String valid_msg = message_wait.getText();
            Assert.assertTrue(valid_msg.contains("The product has been added to your wishlist"));
            System.out.println(valid_msg);
            String color_validate = driver.findElement(By.xpath("//*[@class='bar-notification success']")).getCssValue("background-color");
            System.out.println(color_validate);
            String color = Color.fromString(color_validate).asHex();
            System.out.println(color);
            Assert.assertTrue(color.contains("#4bb07a"));
            wishlist_obj.close();
    }
    @Then("you need to get the total number in the wishlist should be more than one")
    public void you_need_to_get_the_total_number_in_the_wishlist_should_be_more_than() {
            String items_QYT = wishlist_obj.items_number().getText();
            System.out.println(items_QYT);
            Assert.assertEquals(items_QYT,"(1)");
            wishlist_obj.clecking_on_wishlist();
            String items_name = wishlist_obj.items_name().getText();
            System.out.println(items_name);
            Assert.assertEquals(items_name,"HTC One M8 Android L 5.0 Lollipop");
    }
}
