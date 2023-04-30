package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.utilities.Constants;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void commonSetUp(String browser) {
        driver = WebDriverFactory.getInstance().getDriver(browser);
        driver.get(Constants.BASE_URL);
    }

    @BeforeMethod
    public void methodSetUp(){
        CheckPoint.clearHashMap();
    }

    @AfterClass
    public void commonTearDown() {
        driver.quit();
    }
}
