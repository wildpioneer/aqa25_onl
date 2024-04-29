package stepsDefs;

import baseEntities.BaseTest;
import io.cucumber.java.en.Given;

public class ApiStepDefs extends BaseTest {
    private BaseTest baseTest;

    public ApiStepDefs(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Given("service is running")
    public void isServiceRunning() {
        System.out.println(baseTest.service);
    }
}
