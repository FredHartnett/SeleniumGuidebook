package tests;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Driver;

import static tests.Config.browser;

public class BaseTest {

    protected WebDriver driver;

    @Rule
    public ExternalResource resource = new ExternalResource() {

        @Override
        protected void before() throws Throwable {
            if(browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "/vendor/chromedriver");
                driver = new ChromeDriver();
            }
            else if(browser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver",
                        System.getProperty("user.dir") + "/vendor/geckodriver");
                driver = new FirefoxDriver();
            }

            //Next chunk of code for the driver has been replaced with the above code
//            System.setProperty("webdriver.chrome.driver",
//                    "/Users/fredhartnett/drivers/chromedriver");
//            driver = new ChromeDriver();
        }

        @Override
        protected void after() {
            driver.quit();
        }
    };
}
