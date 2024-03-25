package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.Project;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.NavigationSteps;
import steps.ProjectSteps;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() throws InterruptedException {
        NavigationSteps navigationSteps = new NavigationSteps(driver);

        Assert.assertTrue(
                navigationSteps
                        .successfulLogin(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened());
    }

    @Test
    public void successfulLoginTest1() throws InterruptedException {
        NavigationSteps navigationSteps = new NavigationSteps(driver);

        User admin = new User();
        admin.setEmail(ReadProperties.username());
        admin.setPassword(ReadProperties.password());

        Project expectedProject = new Project();
        expectedProject.setName("sfsdfsd");
        expectedProject.setAnnouncement("sfsdfsd");
        expectedProject.setProjectType(1);

        navigationSteps
                .successfulLogin(admin);

        ProjectSteps projectSteps = new ProjectSteps(driver);
        projectSteps.addProject(expectedProject);
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
