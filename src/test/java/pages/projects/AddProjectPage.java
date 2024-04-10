package pages.projects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.TopMenuPage;

import static com.codeborne.selenide.Selenide.$;

public class AddProjectPage extends ProjectBasePage {
    private final static String pagePath = "/index.php?/admin/projects/add/1";

    // Блок описания локаторов для элементов
    private final By addProjectButtonLocator = By.id("accept");

    public AddProjectPage(WebDriver driver) {
        topMenuPage = new TopMenuPage();
    }

    public SelenideElement getAddProjectButton() {
        return $(addProjectButtonLocator);
    }
}
