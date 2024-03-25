package steps;

import baseEntities.BaseSteps;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.projects.AddProjectPage;

public class ProjectSteps extends BaseSteps {
    private AddProjectPage addProjectPage;

    public ProjectSteps(WebDriver driver) {
        super(driver);

        addProjectPage = new AddProjectPage(driver);
    }

    public void addProject(Project project) {
        addProjectPage.setName(project.getName());
        addProjectPage.setAnnouncement(project.getAnnouncement());
        addProjectPage.setProjectType(project.getProjectType());
    }

    public void editProject() {

    }

    public void deleteProject() {

    }
}
