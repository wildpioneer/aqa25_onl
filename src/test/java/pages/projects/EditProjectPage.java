package pages.projects;

import org.openqa.selenium.WebDriver;
import pages.TopMenuPage;

public class EditProjectPage extends ProjectBasePage {
    private final static String pagePath = "/index.php?/admin/projects/add/1";

    public EditProjectPage(WebDriver driver) {
        topMenuPage = new TopMenuPage();
    }
}
