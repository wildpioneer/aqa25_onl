package stepsDefs;

import baseEntities.BaseTest;
import core.BrowserService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook extends BaseTest {
    private BaseTest baseTest;

    public Hook(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Before(value = "@gui")
    public void initGuiScenario(Scenario scenario) {
        baseTest.driver = new BrowserService().getDriver();
    }

    @Before(value = "@gui and @smoke", order = 10002)
    public void initGuiSmokeScenario1(Scenario scenario) {
        System.out.println("@gui and @smoke 1");
    }

    @Before(value = "@gui and @smoke", order = 10001)
    public void initGuiSmokeScenario2(Scenario scenario) {
        System.out.println("@gui and @smoke 2");
    }

    @Before(value = "@api")
    public void initApiScenario(Scenario scenario) {
        baseTest.service = scenario.getName();
        System.out.println("Инициализируем сервис");
    }

    @After(value = "@gui")
    public void guiTearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Attach screenshot");
        }

        baseTest.driver.quit();
    }

    @After(value = "@api")
    public void apiTearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Attach text screenshot");
        }
        System.out.println("Закрываем сервис");
    }
}
