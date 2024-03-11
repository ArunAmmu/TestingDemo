package SauceStepdefintion;

import RunnerClass.RunnerClass;
import Suace_Base.BaseClass;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class SortingPage extends BaseClass {

    public static WebDriver driver = RunnerClass.driver;

    @Given("user sorts product listing by {string}")
    public void user_sorts_product_listing_by(String sortingOption) {

        sortingOption="'Price (low to high)']";

        WebElement sortDropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        sortDropdown.click();

        WebElement selectedOption = sortDropdown.findElement(By.xpath(".//option[text()="+sortingOption));
        selectedOption.click();
    }
    @When("user adds first {int} low-priced products to cart")
    public void user_adds_first_low_priced_products_to_cart(Integer numberOfProducts) {

        List<WebElement> addToCartButtons = driver.findElements(By.className("btn_inventory"));
        for (int i = 0; i < numberOfProducts; i++) {
            addToCartButtons.get(i).click();

        }
    }
    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() {

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
    }
    @Then("verify cart contains {int} items")
    public void verify_cart_contains_items(Integer expectedItemCount) throws IOException {

        WebElement cartIndicator = driver.findElement(By.className("shopping_cart_badge"));
        int actualItemCount = Integer.parseInt(cartIndicator.getText());

        Assert.assertEquals(actualItemCount, expectedItemCount.intValue(), "Cart item count is incorrect");

        System.out.println(actualItemCount);
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        screenshot(driver,"Product from addToCart");
    }
}
