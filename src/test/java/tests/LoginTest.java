package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.projects.AddProjectPage;
import pages.projects.EditProjectPage;
import pages.projects.ProjectBasePage;
import steps.NavigationSteps;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(
                loginPage
                        .successfulLogin(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened()
        );
    }

    @Test
    public void wrongEmailLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertEquals(
                loginPage
                        .incorrectLogin("sdsads", ReadProperties.password())
                        .getErrorText(),
                "Email/Login or Password is incorrect. Please try again."
        );
    }
}
