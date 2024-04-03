package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
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

    @Test
    public void simpleTest() {
        LoginPage loginPage = new LoginPage(driver);

        driver.findElement(By.id("name")).sendKeys("sadasdasd");
        driver.findElement(By.id("password")).sendKeys("sadasdasd");
        driver.findElement(By.id("button_primary")).click();
    }
}
