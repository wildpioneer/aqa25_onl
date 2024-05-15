package tests.api;

import baseEntities.BaseApiTest;
import models.Project;
import models.enums.ProjectTypes;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CrudProjectTest extends BaseApiTest {
    Project actualProject;
    Project expectedProject;

    @BeforeClass
    public void beforeClass() {
        expectedProject = new Project();
        expectedProject.setName("WP_Project_02");
        expectedProject.setAnnouncement("This is a test announcement.");
        expectedProject.setShowAnnouncement(true);
        expectedProject.setSuiteMode(ProjectTypes.SINGLE_SUITE_BASELINES);
    }

    @Test
    public void createProjectTest() {
        actualProject = projectService.addProject(expectedProject);
    }

    @Test (dependsOnMethods = "createProjectTest")
    public void getProjectTest() {
        Project currentProject = projectService.getProject(actualProject.getId());
        Assert.assertTrue(expectedProject.equals(currentProject));
    }

    @Test
    public void updateProjectTest() {}

    @Test
    public void deleteProjectTest() {}
}
