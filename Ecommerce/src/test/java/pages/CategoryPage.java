package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class CategoryPage {
    WebDriver driver;

    By productBlocks = By.cssSelector(".product-grid .fixed_wrapper");
    By productLinks = By.cssSelector(".prdocutname");

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getAllProducts() {
        return driver.findElements(productBlocks);
    }

    public void openRandomProduct() {
        List<WebElement> products = driver.findElements(productLinks);
        products.get(new Random().nextInt(products.size())).click();
    }
}