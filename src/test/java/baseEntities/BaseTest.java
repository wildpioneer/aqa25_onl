package baseEntities;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.SoftAsserts;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Listeners({SoftAsserts.class})
public class BaseTest {

    @BeforeSuite
    public void setupSuite() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.headless = ReadProperties.isHeadless();
        Configuration.browser = ReadProperties.browserName();
        Configuration.pageLoadTimeout = ReadProperties.pageLoadTimeout() * 1000;
        Configuration.timeout = ReadProperties.timeout() * 1000;
        Configuration.assertionMode = AssertionMode.SOFT;
        Configuration.fastSetValue = true;
    }

    @BeforeMethod
    public void setupBrowser() {
        open("/");
        //WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
