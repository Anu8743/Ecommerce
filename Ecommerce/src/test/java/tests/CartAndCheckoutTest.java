package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

public class CartAndCheckoutTest {

    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://tutorialsninja.com/demo"); // Change to your URL

        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void addItemsToCart() {
        for (int i = 0; i < 2; i++) {
            homePage.selectRandomProduct();
            productPage.addToCart();
            driver.navigate().back();
        }

        int cartCount = cartPage.getCartItemCount();
        Assert.assertTrue(cartCount >= 2, "❌ Test Failed: Expected at least 2 items in cart but found " + cartCount);
    }

    @Test(dependsOnMethods = "addItemsToCart")
    public void completeCheckoutWithRegistration() {
        cartPage.viewCart();

        // Read test data
        try {
            File file = new File("src/test/resources/testdata.csv");
            if (!file.exists()) {
                throw new RuntimeException("CSV test data not found!");
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Test data row: " + line);
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("❌ Failed to read test data CSV.");
        }

        cartPage.proceedToCheckout();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
