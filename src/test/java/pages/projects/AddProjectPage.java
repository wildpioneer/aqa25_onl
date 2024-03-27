package pages.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.TopMenuPage;

public class AddProjectPage extends ProjectBasePage {
    private final static String pagePath = "/index.php?/admin/projects/add/1";

    // Блок описания локаторов для элементов
    private final By addProjectButtonLocator = By.id("accept");

    public AddProjectPage(WebDriver driver) {
        super(driver);

        topMenuPage = new TopMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return addProjectButtonLocator;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public WebElement getAddProjectButton() {
        return waitsService.waitForVisibilityLocatedBy(addProjectButtonLocator);
    }
}
