package baseEntities;

import configuration.ReadProperties;
import core.WaitsService;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected static final int WAIT_FOR_PAGE_LOADED_IN_SECONDS = 60;

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

        waitForOpen();
    }

    protected abstract By getPageIdentifier();
    protected abstract String getPagePath();

    public boolean isPageOpened() {
        try {
            return waitsService.waitForVisibilityLocatedBy(getPageIdentifier()).isDisplayed();
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public void openPageByUrl() {
        driver.get(ReadProperties.getUrl() + getPagePath());
    }

    private void waitForOpen() {
        int tryCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();

        while (!isPageOpenedIndicator
                && (tryCount < WAIT_FOR_PAGE_LOADED_IN_SECONDS / ReadProperties.timeout())) {
            tryCount++;
            isPageOpenedIndicator = isPageOpened();
        }

        if (!isPageOpenedIndicator) {
            throw new AssertionError("Page is not opened.");
        }
    }
}
