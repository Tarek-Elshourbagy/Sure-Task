package org.example.Step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P05_hoverCategories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.example.Step_def.Hooks.driver;

public class TC05_hoverCategories {
    //objects
    P05_hoverCategories hover_obj = new P05_hoverCategories();
    Actions Act = new Actions(driver);
    Random rand = new Random();
    int flag;
    int ramd_no;
    String main_name;

    @Given("move to the website")
    public void move_to_the_website() {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @Then("you hover in one for random main categories [Computer,Electronics,Apparel]")
    public void hover_over_any_random_categories() throws InterruptedException {
        ArrayList<String> main_element = new ArrayList<>();
        main_element.add("Computers");
        main_element.add("Electronics");
        main_element.add("Apparel");
        ramd_no = rand.nextInt(hover_obj.Main_Element().size());
        main_name = hover_obj.Main_Element().get(ramd_no).getText();
        Act.moveToElement(hover_obj.Main_Element().get(ramd_no)).perform();
        Thread.sleep(2000);
        System.out.println(main_name);
        if (main_element.contains(main_name)) {
            flag = 0;
        } else {
            hover_obj.Main_Element().get(ramd_no).click();
            Assert.assertEquals(hover_obj.Sub_Title().getText(), main_name);
            flag = 1;
        }
    }

    @And("choose on of there subcategories and click on it and make sure for the validation")
    public void choose_from_sub_categories() throws InterruptedException {

        if (flag == 0) {
            System.out.println(flag);
            ArrayList<String> sub_element = new ArrayList<>(); //list for all subtitles
            sub_element.add("desktops");
            sub_element.add("notebooks");
            sub_element.add("software");
            sub_element.add("camera&photo");
            sub_element.add("cellphone");
            sub_element.add("others");
            sub_element.add("shoes");
            sub_element.add("clothing");
            if (main_name.equals("Computers")) {
                String subElement_name = hover_obj.Computer_subtitles().get(2).getText().toLowerCase().trim();
                hover_obj.Computer_subtitles().get(2).click();
                Thread.sleep(2000);
                Assert.assertEquals(hover_obj.Sub_Title().getText().toLowerCase().trim(), subElement_name);
            } else if (main_name.equals("Electronics")) {
                String subElement_name = hover_obj.Electroncis_subtitles().get(1).getText().toLowerCase().trim();
                hover_obj.Electroncis_subtitles().get(1).click();
                Thread.sleep(2000);
                Assert.assertEquals(hover_obj.Sub_Title().getText().toLowerCase().trim(), subElement_name);
            } else {
                String subElement_name = hover_obj.Apparel_subtitles().get(3).getText().toLowerCase().trim();
                hover_obj.Apparel_subtitles().get(3).click();
                Thread.sleep(2000);
                Assert.assertEquals(hover_obj.Sub_Title().getText().toLowerCase().trim(), subElement_name);
            }
        } else {
            System.out.println("choose main element with sub element");

        }
    }
}


