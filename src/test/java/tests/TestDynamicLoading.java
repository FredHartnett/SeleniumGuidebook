package tests;

import org.junit.Before;
import org.junit.Test;
import pageobjects.DynamicLoading;
import static org.junit.Assert.assertTrue;

public class TestDynamicLoading extends BaseTest {

//    WebDriver commented because of BaseTest class
//    private WebDriver driver;
    private DynamicLoading dynamicLoading;

    @Before
    public void setUp() {
//      setProperty and driver commented because of BaseTest
//      System.setProperty("webdriver.chrome.driver",
//              "/Users/fredhartnett/drivers/chromedriver");
//      driver = new ChromeDriver();
        dynamicLoading = new DynamicLoading(driver);

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

//    Next method commented because of BaseTest
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}
