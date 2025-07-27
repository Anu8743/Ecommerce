package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    By continueAsGuestBtn = By.xpath("//a[contains(text(),'Register Account')]");
    By firstname = By.name("firstname");
    By lastname = By.name("lastname");
    By email = By.name("email");
    By telephone = By.name("telephone");
    By password = By.name("password");
    By confirmPassword = By.name("confirm");
    By agreeCheckbox = By.name("agree");
    By continueBtn = By.cssSelector("input.btn.btn-orange");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegisterAccount() {
        driver.findElement(continueAsGuestBtn).click();
    }

    public void fillRegistrationForm(String first, String last, String emailAddr, String phone, String pass) {
        driver.findElement(firstname).sendKeys(first);
        driver.findElement(lastname).sendKeys(last);
        driver.findElement(email).sendKeys(emailAddr);
        driver.findElement(telephone).sendKeys(phone);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
        driver.findElement(agreeCheckbox).click();
        driver.findElement(continueBtn).click();
    }
}
