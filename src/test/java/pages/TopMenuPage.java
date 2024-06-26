package pages;

import baseEntities.BasePage;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenuPage extends BasePage {
    private static final By topPanelLocator = By.className("top-panel");

    // Блок иницализации
    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return topPanelLocator;
    }

    @Override
    protected String getPagePath() {
        return "";
    }

    @Override
    protected void load() {
    }

    // Блок атомарных методов
    public WebElement getTopPanel() {
        return driver.findElement(topPanelLocator);
    }
}
