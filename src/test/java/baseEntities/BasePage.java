package baseEntities;

import configuration.ReadProperties;
import core.WaitsService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitsService waitsService;

    public BasePage(WebDriver driver) {
        this(driver, false);
    }

    public BasePage(WebDriver driver, boolean openPageByUrl) {
        this.driver = driver;
        this.waitsService = new WaitsService(driver);

        if (openPageByUrl) {
            openPageByUrl();
        }

        PageFactory.initElements(driver, this);
    }

    protected abstract WebElement getPageIdentifier();
    protected abstract String getPagePath();

    public boolean isPageOpened() {
        return getPageIdentifier().isDisplayed();
    }

    public void openPageByUrl() {
        driver.get(ReadProperties.getUrl() + getPagePath());
    }
}
