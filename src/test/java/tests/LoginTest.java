package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.NavigationSteps;

public class LoginTest extends BaseTest {

    ///fsdfsdfds


    @Test
    public void successfulLoginTest() throws InterruptedException {
        NavigationSteps navigationSteps = new NavigationSteps(driver);

        Assert.assertTrue(
                navigationSteps
                        .successfulLogin(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened());
    }

    @Test
    public void wrongPasswordLoginTest() {
        NavigationSteps navigationSteps = new NavigationSteps(driver);

        Assert.assertEquals(
                navigationSteps
                        .incorrectLogin(ReadProperties.username(), "sdasd").getErrorText(),
                "Email/Login or Password is incorrect. Please try again.");
    }

    @Test
    public void wrongEmailLoginTest() {
        NavigationSteps navigationSteps = new NavigationSteps(driver);

        Assert.assertEquals(navigationSteps.incorrectLogin("sdasd", ReadProperties.password()).getErrorText(),
                "Email/Login or Password is incorrect. Please try again.");
    }
}
