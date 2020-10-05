package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.DynamicLoading;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDynamicLoading extends BaseTest {

    private DynamicLoading dynamicLoading;

    @BeforeEach
    public void setUp() {
        dynamicLoading = new DynamicLoading(driver);
    }

    @Test
    public void hiddenElementLoads() {
        dynamicLoading.loadExample("1");

        assertTrue(dynamicLoading.finishTextPresent(),
                "finish text didn't display after loading");
    }

    @Test
    public void elementAppears() {
        dynamicLoading.loadExample("2");

        assertTrue(dynamicLoading.finishTextPresent(),
                "finish text didn't render after loading");
    }

}
