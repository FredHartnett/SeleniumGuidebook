package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Login;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestLogin {

    private WebDriver driver;
    private Login login;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        login = new Login(driver);
    }

    @Test
    public void succeeded() {
        login.with("tomsmith", "SuperSecretPassword!");

        assertTrue(login.successMessagePresent(),
                "success message not present");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}