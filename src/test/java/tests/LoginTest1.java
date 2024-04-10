package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.NavigationSteps;

public class LoginTest1 extends BaseTest {

    @Test
    public void successfulLoginTest() throws InterruptedException {
        NavigationSteps navigationSteps = new NavigationSteps();

        Assert.assertTrue(
                navigationSteps
                        .successfulLogin(ReadProperties.username(), ReadProperties.password())
                        .getHeaderTitleLabel().isDisplayed());
    }

    @Test
    public void wrongPasswordLoginTest() {
        NavigationSteps navigationSteps = new NavigationSteps();

        Assert.assertEquals(
                navigationSteps
                        .incorrectLogin(ReadProperties.username(), "sdasd").getErrorText(),
                "Email/Login or Password is incorrect. Please try again.");
    }

    @Test
    public void wrongEmailLoginTest() {
        NavigationSteps navigationSteps = new NavigationSteps();

        Assert.assertEquals(navigationSteps.incorrectLogin("sdasd", ReadProperties.password()).getErrorText(),
                "Email/Login or Password is incorrect. Please try again.");
    }
}
