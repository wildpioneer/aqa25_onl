package pages;

import baseEntities.BasePage;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard";

    // Блок описания локаторов для элементов
    private static final By headerTitleLabelLocator =
            By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'All Projects')]");

    public TopMenuPage topMenuPage;

    // Блок иницализации
    public DashboardPage(WebDriver driver) {
        super(driver);

        topMenuPage = new TopMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    // Блок атомарных методов
    public WebElement getHeaderTitleLabel() {
        return waitsService.waitForVisibilityLocatedBy(headerTitleLabelLocator);
    }
}
