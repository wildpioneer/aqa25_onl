package tests;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.SoftAsserts;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTextCaseInsensitive;
import static com.codeborne.selenide.Selenide.*;

@Listeners({ SoftAsserts.class})
public class SelenideTest {

    @BeforeSuite
    public void setupSuite() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = ReadProperties.getUrl();
        //Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.browser = Browsers.CHROME;
        //Configuration.pageLoadTimeout = ReadProperties.pageLoadTimeout() * 1000;
        //Configuration.timeout = ReadProperties.timeout() * 1000;
        Configuration.assertionMode = AssertionMode.SOFT;
        Configuration.fastSetValue = true;
    }

    @BeforeMethod
    public void setupBrowser() {
        open("/");
        //WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Test
    public void simpleTest() {
        //open("/index.php?/auth/forgot_password");

        SelenideElement username = $(By.id("name")).setValue(ReadProperties.username());
        $("#password").val(ReadProperties.password());
        $("#button_primary").click();

        $(".page_title")
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

        open("/index.php?/admin/projects/overview");

        ElementsCollection list = $$(By.className("hoverSensitive"));

        $$(By.className("hoverSensitive"))
                .shouldHave(size(197))
                .find(text("lpdoli7j9uazix0gu4v8"))
                .find(By.tagName("a"))
                .click();

        $("#announcement_display")
                .should(exist, Duration.ofSeconds(20))
                .shouldBe(visible)
                .shouldNotHave(text("Country"));
    }

    @Test
    public void softAssertErrorTest() {
        //open("/index.php?/auth/forgot_password");

        SelenideElement username = $(By.id("name")).setValue(ReadProperties.username());
        $("#password").val(ReadProperties.password());
        $("#button_primary").click();

        $(".page_title")
                .shouldNotBe(visible)
                .shouldHave(text("All Projects1"));

        open("/index.php?/admin/projects/overview");

        ElementsCollection list = $$(By.className("hoverSensitive"));

        $$(By.className("hoverSensitive"))
                .shouldHave(size(197))
                .find(text("lpdoli7j9uazix0gu4v8"))
                .find(By.tagName("a"))
                .click();

        $("#announcement_display")
                .should(exist, Duration.ofSeconds(20))
                .shouldBe(visible)
                .shouldHave(text("Country"));
    }

    @Test
    public void fileTest() {
        open("https://the-internet.herokuapp.com/upload");

        String filePath = SelenideTest.class.getClassLoader().getResource("data" + File.separator + "download.png").getPath();

        $("#file-upload")
                .uploadFile(new File(filePath));
        $("#file-submit").submit();

        open("https://the-internet.herokuapp.com/download");

        String uri = $("#content a").download().toURI().toString();

        SelenideElement element1 = $(byText("random_data.txt"));
        SelenideElement element2 = $(byTextCaseInsensitive("Random_data.txt"));
        SelenideElement element3 = $(byText("Random_data.txt"));
        SelenideElement element4 = $(By.xpath("//*[text() = 'Random_data.txt']"));

        element1.innerHtml();
        element1.innerText();

        SelenideElement parentElement = element1.parent();
    }
}
