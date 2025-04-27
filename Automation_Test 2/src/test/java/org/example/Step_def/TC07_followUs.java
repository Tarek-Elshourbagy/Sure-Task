package org.example.Step_def;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P07_followUs;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.Set;

import static org.example.Step_def.Hooks.driver;

public class TC07_followUs {
    P07_followUs followUs_obj = new P07_followUs();

    @Given("run to the website")
    public void run_to_the_website() {
        driver.navigate().to("https://demo.nopcommerce.com");
    }

    @Then("clicking on the links and make sure for the validation for each case {string}")
    public void clicking_on_the_links_and_make_sure_for_the_validation_for_each_case(String icon) throws InterruptedException {
        if (icon.contains("Facebook_icon")) {
            //parent window
            String parent_window = driver.getWindowHandle();
            WebElement facebook = followUs_obj.Icons().get(0);
            facebook.click();
            String icon_name = facebook.getText().toLowerCase();
            //child windows
            Set<String> child_windows = driver.getWindowHandles();
            if (child_windows.size() == 2) {
                for (String handel : child_windows) {
                    if (handel.equals(parent_window)) {
                        continue;
                    } else {
                        driver.switchTo().window(handel);
                        String child_url = driver.getCurrentUrl().toLowerCase();
                        System.out.println("child_url =  " + child_url);
                        System.out.println("icon name =  " + icon_name);
                        if (child_url.contains(icon_name)) {
                            Assert.assertTrue(child_url.contains(icon_name));
                            Thread.sleep(5000);
                            driver.close();
                        } else {
                            continue;
                        }
                    }
                }
                driver.switchTo().window(parent_window);
            } else {
                System.out.println("An error message had been found");
                driver.navigate().to("https://demo.nopcommerce.com/");
            }
        } else if (icon.contains("Twitter_icon")) {
            //parent window
            String parent_window = driver.getWindowHandle();
            WebElement twitter = followUs_obj.Icons().get(1);
            twitter.click();
            String icon_name = twitter.getText().toLowerCase();
            //child windows
            Set<String> child_windows = driver.getWindowHandles();
            if (child_windows.size() == 2) {
                for (String handel : child_windows) {
                    if (handel.equals(parent_window)) {
                        continue;
                    } else {
                        driver.switchTo().window(handel);
                        String child_url = driver.getCurrentUrl().toLowerCase();
                        System.out.println("child_url =  " + child_url);
                        System.out.println("icon name =  " + icon_name);
                        if (child_url.contains(icon_name)) {
                            Assert.assertTrue(child_url.contains(icon_name));
                            Thread.sleep(5000);
                            driver.close();
                        } else {
                            System.out.println("An error message had been found");
                            driver.navigate().to("https://demo.nopcommerce.com/");
                        }
                    }
                }
                driver.switchTo().window(parent_window);
            } else {
                System.out.println("An error message had been found");
                driver.navigate().to("https://demo.nopcommerce.com/");
            }
        } else if (icon.contains("rcc_icon")) {
            //parent window
            String parent_window = driver.getWindowHandle();
            WebElement rcc = followUs_obj.Icons().get(2);
            rcc.click();
            String icon_name = rcc.getText().toLowerCase();
            //child windows
            Set<String> child_windows = driver.getWindowHandles();
            if (child_windows.size() == 2) {
                for (String handel : child_windows) {
                    if (handel.equals(parent_window)) {
                        continue;
                    } else {
                        driver.switchTo().window(handel);
                        String child_url = driver.getCurrentUrl().toLowerCase();
                        System.out.println("child_url =  " + child_url);
                        System.out.println("icon name =  " + icon_name);
                        if (child_url.contains(icon_name)) {
                            Assert.assertTrue(child_url.contains(icon_name));
                            Thread.sleep(5000);
                            driver.close();
                        } else {
                            System.out.println("An error message had been found");
                            driver.navigate().to("https://demo.nopcommerce.com/");
                        }
                    }
                }
                driver.switchTo().window(parent_window);
            } else {
                System.out.println("An error message had been found");
                driver.navigate().to("https://demo.nopcommerce.com/");
            }
        } else {
            String parent_window = driver.getWindowHandle();
            WebElement youtube = followUs_obj.Icons().get(3);
            youtube.click();
            String icon_name = youtube.getText().toLowerCase();
            //child windows
            Set<String> child_windows = driver.getWindowHandles();
            if (child_windows.size() == 2) {
                for (String handel : child_windows) {
                    if (handel.equals(parent_window)) {
                        continue;
                    } else {
                        driver.switchTo().window(handel);
                        String child_url = driver.getCurrentUrl().toLowerCase();
                        System.out.println("child_url =  " + child_url);
                        System.out.println("icon name =  " + icon_name);
                        if (child_url.contains(icon_name)) {
                            Assert.assertTrue(child_url.contains(icon_name));
                            Thread.sleep(5000);
                            driver.close();
                        } else {
                            System.out.println("An error message had been found");
                            driver.navigate().to("https://demo.nopcommerce.com/");
                        }
                    }
                }
                driver.switchTo().window(parent_window);
            } else {
                System.out.println("An error message had been found");
                driver.navigate().to("https://demo.nopcommerce.com/");
            }
        }
    }
}