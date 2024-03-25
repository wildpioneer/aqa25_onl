package baseEntities;

import configuration.ReadProperties;
import core.BrowserService;
import core.Listener;
import core.WaitsService;
import models.Project;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(Listener.class)
public class BaseTest {
    protected WebDriver driver;
    protected WaitsService waitsService;

    protected User admin;
    protected Project mainProject;

    @BeforeTest
    public void setupData() {
        admin = new User();
        mainProject = new Project();
    }

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
        waitsService = new WaitsService(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
