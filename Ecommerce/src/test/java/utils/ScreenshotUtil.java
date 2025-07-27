package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtil {
    public static void captureScreenshot(WebDriver driver, String testName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshot.toPath(),
                    new File("screenshots/" + testName + "_" + System.currentTimeMillis() + ".png").toPath());
        } catch (IOException e) {
            System.out.println("Screenshot saving failed: " + e.getMessage());
        }
    }
}
