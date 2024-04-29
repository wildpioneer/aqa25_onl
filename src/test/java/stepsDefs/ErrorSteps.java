package stepsDefs;

import baseEntities.BaseTest;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;

public class ErrorSteps extends BaseTest {
    private BaseTest baseTest;

    public ErrorSteps(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Then("error {string} is displayed")
    public void errorIsDisplayed(String errorText) {
        LoginPage loginPage = new LoginPage(baseTest.driver);
        Assert.assertEquals(loginPage.getErrorText(), errorText);
    }
}
