package SauceStepdefintion;

import RunnerClass.RunnerClass;
import Sauce_Page.Login_Page;
import Sauce_Utils.Test_Data;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

import static Suace_Base.BaseClass.screenshot;

public class LoginPage {

    Login_Page login = new Login_Page ();

    public static WebDriver driver = RunnerClass.driver;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
driver.get("https://www.saucedemo.com/ ");
driver.manage().window().maximize();
    }
    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() throws IOException {
        driver.findElement(login.userName).sendKeys(Test_Data.USERNAME);
        driver.findElement(login.passWord).sendKeys(Test_Data.PASSWORD);
        driver.findElement(login.loginBtn).click();
        screenshot(driver,"productPage");
    }
    @Then("product listing is displayed")
    public void product_listing_is_displayed() {

        WebElement productListing = driver.findElement(By.className("inventory_container"));
        Assert.assertTrue(productListing.isDisplayed(),"product listing is displayed");

    }


}
