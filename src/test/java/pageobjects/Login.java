package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;

public class Login extends BasePage {


    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By loginButton = By.cssSelector("button");
    By loginFormLocator = By.id("login");
    By successMessageLocator = By.cssSelector(".flash.success");
    By failureMessageLocator = By.cssSelector(".flash.error");


    public Login(WebDriver driver) {
        super(driver);
//  next line was used before Config.java
//        visit("http://the-internet.herokuapp.com/login");
        visit("/login");
        assertTrue("The login form is not present", isDisplayed(loginFormLocator));
    }

    public void with(String username, String password) {
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(loginButton);
    }

    public Boolean successMessagePresent() {
        return isDisplayed(successMessageLocator);
    }

    public Boolean failureMessagePresent() {
        return isDisplayed(failureMessageLocator);
    }
}
