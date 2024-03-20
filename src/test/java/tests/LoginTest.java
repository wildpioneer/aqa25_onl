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
    public void successfulLoginTest() throws InterruptedException {
        NavigationSteps navigationSteps = new NavigationSteps(driver);
        navigationSteps.login(ReadProperties.username(), ReadProperties.password());

        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }

    @Test
    public void wrongPasswordLoginTest() {
        NavigationSteps navigationSteps = new NavigationSteps(driver);
        navigationSteps.login(ReadProperties.username(), "sdasd");

        LoginPage loginPage = new LoginPage(driver);

        Assert.assertEquals(loginPage.getErrorText(), "Email/Login or Password is incorrect. Please try again.");
    }

    @Test
    public void wrongEmailLoginTest() {
        NavigationSteps navigationSteps = new NavigationSteps(driver);
        navigationSteps.login("sdasd", ReadProperties.password());

        LoginPage loginPage = new LoginPage(driver);

        Assert.assertEquals(loginPage.getErrorText(), "Email/Login or Password is incorrect. Please try again.");
    }
}
