package tests;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.DynamicLoading;

import static org.junit.Assert.assertTrue;


public class TestDynamicLoading {

    private WebDriver driver;
    private DynamicLoading dynamicLoading;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/fredhartnett/drivers/chromedriver");
        driver = new ChromeDriver();
        dynamicLoading = new DynamicLoading(driver);
//        try{Thread.sleep(2000);} catch(InterruptedException e) { /* do nothing */};
    }

    @Test
    public void hiddenElementLoads() {
        dynamicLoading.loadExample("1");
        assertTrue("finish text didn't display after loading",
                dynamicLoading.finishTextPresent());
    }

    @Test
    public void elementAppears() {
        dynamicLoading.loadExample("2");
        assertTrue("finish text didn't display after loading",
                dynamicLoading.finishTextPresent());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
