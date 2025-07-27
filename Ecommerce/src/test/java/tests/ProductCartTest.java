package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;

import java.time.Duration;

public class ProductCartTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Optional if using WebDriverManager
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://your-ecommerce-site.com"); // Replace with actual URL

        homePage = new HomePage(driver);
    }

    @Test
    public void addTwoRandomProducts() {
        homePage.goToRandomCategory();

        // Add your logic here to select and add 2 random products
        // For example: new CategoryPage(driver).addTwoRandomProducts();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
