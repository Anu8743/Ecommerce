package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By productNameLinks = By.cssSelector(".fixed_wrapper .prdocutname");  // ✅ correct class

    public List<WebElement> getAllProductElements() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productNameLinks));
    }

    public void selectProductByIndex(int index) {
        List<WebElement> products = getAllProductElements();
        if (!products.isEmpty() && index < products.size()) {
            products.get(index).click();
        } else {
            throw new RuntimeException("No products found or index out of bounds.");
        }
    }
    private By categoryLinks = By.cssSelector(".categorymenu a");
    public void goToRandomCategory() {
        List<WebElement> categories = driver.findElements(categoryLinks);

        if (categories.isEmpty()) {
            System.out.println("❌ No category links found using selector: " + categoryLinks.toString());
            throw new RuntimeException("No categories found on the homepage.");
        }

        Random random = new Random();
        WebElement randomCategory = categories.get(random.nextInt(categories.size()));
        System.out.println("🔍 Clicking category: " + randomCategory.getText());
        randomCategory.click();
    }


    public void selectRandomProduct() {
        List<WebElement> products = getAllProductElements();
        if (!products.isEmpty()) {
            int randomIndex = new Random().nextInt(products.size());
            products.get(randomIndex).click();
        } else {
            throw new RuntimeException("No products available to select.");
        }

    }
}
