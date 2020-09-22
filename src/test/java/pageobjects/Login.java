package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Login extends BasePage {

    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By loginFormLocator = By.id("login");
    By submitButton = By.cssSelector("button");
    By successMessageLocator = By.cssSelector(".flash.success");
    By failureMessageLocator = By.cssSelector(".flash.error");

    public Login(WebDriver driver) {
        super(driver);
        visit("http://the-internet.herokuapp.com/login");

        assertTrue(isDisplayed(loginFormLocator),
                "The login form is not present");
    }

    public void with(String username, String password) {
        type(username,usernameLocator);
        type(password,passwordLocator);

        click(submitButton);
    }

    public Boolean successMessagePresent() {
        return isDisplayed(successMessageLocator);
    }

    public Boolean failureMessagePresent() {
        return isDisplayed(failureMessageLocator);
    }
}
