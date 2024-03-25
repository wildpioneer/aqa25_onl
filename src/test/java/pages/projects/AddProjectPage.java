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
        this(driver, false);
    }

    public AddProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);

        topMenuPage = new TopMenuPage(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return driver.findElement(addProjectButtonLocator);
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public WebElement getAddProjectButton() {
        return waitsService.waitForVisibilityLocatedBy(addProjectButtonLocator);
    }
}
