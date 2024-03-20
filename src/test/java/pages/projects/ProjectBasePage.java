package pages.projects;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.TopMenuPage;

public abstract class ProjectBasePage extends BasePage {
    public TopMenuPage topMenuPage;

    // Блок описания локаторов для элементов
    private final By nameInputLocator = By.id("name");
    private final By announcementTextAreaLocator = By.id("announcement_display");
    private final By show_announcementCheckboxLocator = By.id("show_announcement");
    private final By suiteModeSingleTypeLocator = By.id("suite_mode_single");

    public ProjectBasePage(WebDriver driver) {
        this(driver, false);
    }

    public ProjectBasePage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);

        topMenuPage = new TopMenuPage(driver);
    }

    public WebElement nameInput() {
        return waitsService.waitForVisibilityLocatedBy(nameInputLocator);
    }

    public WebElement announcementTextArea() {
        return waitsService.waitForVisibilityLocatedBy(announcementTextAreaLocator);
    }

    public WebElement show_announcementCheckbox() {
        return waitsService.waitForVisibilityLocatedBy(show_announcementCheckboxLocator);
    }

    public WebElement suiteModeSingleType() {
        return waitsService.waitForVisibilityLocatedBy(suiteModeSingleTypeLocator);
    }
}
