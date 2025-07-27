package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstName = By.id("AccountFrm_firstname");
    private By lastName = By.id("AccountFrm_lastname");
    private By email = By.id("AccountFrm_email");
    private By password = By.id("AccountFrm_password");
    private By agreeCheckbox = By.name("agree");
    private By continueBtn = By.xpath("//button[@title='Continue']");
    private By errorMsg = By.xpath("//div[contains(@class,'alert-danger')]");

    public void fillFormMissingLastName() {
        driver.findElement(firstName).sendKeys("Test");
        // lastName left empty
        driver.findElement(email).sendKeys("test" + System.currentTimeMillis() + "@test.com");
        driver.findElement(password).sendKeys("Password123");
        driver.findElement(agreeCheckbox).click();
    }

    public void submitForm() {
        driver.findElement(continueBtn).click();
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }
}
