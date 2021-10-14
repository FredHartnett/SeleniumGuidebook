package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Login;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestLogin {

    private WebDriver driver;
    private Login login;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/fredhartnett/drivers/chromedriver");
        driver = new ChromeDriver();
        login = new Login(driver);
//        try{Thread.sleep(2000);} catch(InterruptedException e) { /* do nothing */};
    }

    @Test
    public void succeeded() {
        login.with("tomsmith","SuperSecretPassword!");
        assertTrue(login.successMessagePresent(),"success message not present");
    }

    @Test
    public void failed() {
        login.with("tomsmith","badpassword");
        assertFalse(login.successMessagePresent(),"failure message was not present after providing bogus credentials");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}