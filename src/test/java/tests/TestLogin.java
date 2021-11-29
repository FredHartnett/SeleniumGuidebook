package tests;

import org.junit.Before;
import org.junit.Test;

import pageobjects.Login;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestLogin extends BaseTest {

//    WebDriver commented because of BaseTest class
//    private WebDriver driver;
    private Login login;

    @Before
    public void setUp() {
//      setProperty and driver commented because of BaseTest
//        System.setProperty("webdriver.chrome.driver",
//                "/Users/fredhartnett/drivers/chromedriver");
//        driver = new ChromeDriver();
        login = new Login(driver);
    }

    @Test
    public void succeeded() {
        login.with("tomsmith","SuperSecretPassword!");
        assertTrue("success message not present", login.successMessagePresent());
    }

    @Test
    public void failed() {
        login.with("tomsmith","badpassword");
        assertTrue("failure message wasn't present after providing bogus credentials",
                login.failureMessagePresent());
        assertFalse("success message was present after providing bogus credentials",
                login.successMessagePresent());
    }

//  Next method commented because of BaseTest
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}