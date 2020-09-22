package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.DynamicLoading;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDynamicLoading {

    private WebDriver driver;
    private DynamicLoading dynamicLoading;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        dynamicLoading = new DynamicLoading(driver);
    }

    @Test
    public void hiddenElementLoads() {
        dynamicLoading.loadExample("1");
        System.out.println("$$$$$$$this is the 1st test");
        assertTrue(dynamicLoading.finishTextPresent(),
                "finish text didn't display after loading");
    }

    @Test
    public void elementAppears() {
        dynamicLoading.loadExample("2");
        System.out.println("$$$$$$$$$this is the 2nd test");
        assertTrue(dynamicLoading.finishTextPresent(),
                "finish text didn't render after loading");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
