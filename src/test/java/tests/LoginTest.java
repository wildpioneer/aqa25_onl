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

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ReadProperties.username(), ReadProperties.password());

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.topMenuPage.getTopPanel();

        Assert.assertTrue(dashboardPage.isPageOpened());
    }

    @Test
    public void successfulLoginTest1() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ReadProperties.username(), ReadProperties.password());

        driver.get("https://aqa2504.testrail.io/index.php?/projects/overview/2");

        DashboardPage dashboardPage = new DashboardPage(driver, true);
        Assert.assertTrue(dashboardPage.isPageOpened());
    }
}
