package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenuPage extends BasePage {
    private final By topPanelLocator = By.className("top-panel");

    // Блок иницализации
    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return driver.findElement(topPanelLocator);
    }

    @Override
    protected String getPagePath() {
        return "";
    }

    @Override
    public void openPageByUrl() {
    }

    // Блок атомарных методов
    public WebElement getTopPanel() {
        return driver.findElement(topPanelLocator);
    }
}
