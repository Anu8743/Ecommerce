package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utilities.BaseTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class RegistrationNegativeTest extends BaseTest {

    @Test
    public void testMissingLastName() {
        driver.get("https://automationteststore.com/index.php?rt=account/create");

        RegistrationPage regPage = new RegistrationPage(driver);
        regPage.fillFormMissingLastName();
        regPage.submitForm();

        // Validate error and take screenshot if failed
        if (regPage.isErrorDisplayed()) {
            System.out.println("Validation error displayed as expected.");
        } else {
            takeScreenshot("missing_lastname_error");
            Assert.fail("Expected validation error was NOT displayed!");
        }
    }

    private void takeScreenshot(String filename) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshots/" + filename + ".png");
        destFile.getParentFile().mkdirs(); // ensure directory exists
        try {
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved to " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
