package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Login;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestLogin extends BaseTest {

    private Login login;

    @BeforeEach
    public void setUp() {
        login = new Login(driver);
    }

    @Test
    public void succeeded() {
        login.with("tomsmith", "SuperSecretPassword!");

        assertTrue(login.successMessagePresent(),
                "success message not present");
    }

    @Test
    public void failed() {
        login.with("tomsmith", "bad password");

        assertFalse(login.successMessagePresent(),
                "failure message wasn't present after providing bogus credentials");
    }

}