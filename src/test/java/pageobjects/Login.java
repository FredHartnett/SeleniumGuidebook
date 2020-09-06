package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {

    private WebDriver driver;
    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By submitButton = By.cssSelector("button");
    By successMessageLocator = By.cssSelector(".flash.success");

    public Login(WebDriver driver) {
        this.driver = driver;
        driver.get("http://the-internet.herokuapp.com/login");
    }

    public void with(String username, String password) {
        driver.findElement(usernameLocator).sendKeys("tomsmith");
        driver.findElement(passwordLocator).sendKeys("SuperSecretPassword!");

        WebElement button = driver.findElement(submitButton);
        button.click();
    }

    public Boolean successMessagePresent() {
        return driver.findElement(successMessageLocator).isDisplayed();
    }
}
