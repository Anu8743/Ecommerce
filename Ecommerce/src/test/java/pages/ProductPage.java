package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    By name = By.cssSelector("h1.productname");
    By price = By.cssSelector("div.productinfo span.price");
    By addToCartButton = By.cssSelector("a.productcart");
    By outOfStock = By.xpath("//*[contains(text(),'Out Of Stock')]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        // Correct and working selector for the Add to Cart button
        driver.findElement(By.cssSelector("a.cart")).click();
        // Alternative (if above doesn't work):
        // driver.findElement(By.xpath("//a[contains(@class,'cart')]")).click();
    }

    public String getProductName() {
        return driver.findElement(name).getText();
    }

    public String getProductPrice() {
        return driver.findElement(price).getText();
    }

    public String getProductURL() {
        return driver.getCurrentUrl();
    }

    public boolean isOutOfStock() {
        return !driver.findElements(outOfStock).isEmpty();
    }

    public boolean isAddToCartPresent() {
        return !driver.findElements(addToCartButton).isEmpty();
    }


}
