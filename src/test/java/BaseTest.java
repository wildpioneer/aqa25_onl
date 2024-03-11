import core.BrowserService;
import core.WaitsService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(Listener.class)
public class BaseTest {
    protected WebDriver driver;
    protected WaitsService waitsService;

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
        waitsService = new WaitsService(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
