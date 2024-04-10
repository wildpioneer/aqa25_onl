package pages.projects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.TopMenuPage;

import static com.codeborne.selenide.Selenide.$;

public abstract class ProjectBasePage {
    public TopMenuPage topMenuPage;

    // Блок описания локаторов для элементов
    private final By nameInputLocator = By.id("name");
    private final By announcementTextAreaLocator = By.id("announcement_display");
    private final By show_announcementCheckboxLocator = By.id("show_announcement");
    private final By suiteModeSingleTypeLocator = By.id("suite_mode_single");

    public SelenideElement nameInput() {
        return $(nameInputLocator);
    }

    public SelenideElement announcementTextArea() {
        return $(announcementTextAreaLocator);
    }

    public SelenideElement show_announcementCheckbox() {
        return $(show_announcementCheckboxLocator);
    }

    public SelenideElement suiteModeSingleType() {
        return $(suiteModeSingleTypeLocator);
    }
}
