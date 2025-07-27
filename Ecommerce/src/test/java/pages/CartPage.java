package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Clicks on the cart icon to go to the cart page
    public void viewCart() {
        WebElement cartButton = driver.findElement(By.id("cart"));
        cartButton.click();

        // Click "View Cart" from dropdown
        WebElement viewCartLink = driver.findElement(By.xpath("//strong[contains(text(),' View Cart')]"));
        viewCartLink.click();
    }

    // Returns the number of items currently shown in the cart icon
    public int getCartItemCount() {
        WebElement cartButton = driver.findElement(By.id("cart"));
        String cartText = cartButton.getText(); // e.g., "3 item(s) - $250.00"
        String itemPart = cartText.split(" ")[0]; // Get the first part before "item(s)"
        try {
            return Integer.parseInt(itemPart.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    // Proceeds to checkout from cart page
    public void proceedToCheckout() {
        WebElement checkoutButton = driver.findElement(By.linkText("Checkout"));
        checkoutButton.click();
    }
}
