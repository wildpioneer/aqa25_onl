package pages;

import baseEntities.BasePage;
import configuration.ReadProperties;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final static String pagePath = "";

    // Блок описания локаторов для элементов
    private final By emailInputLocator = By.id("name");
    private final By passwordInputLocator = By.id("password");
    private final By loginButtonLocator = By.id("button_primary");

    // Блок иницализации
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return emailInputLocator;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    // Блок атомарных методов
    public WebElement getEmailInput() {
        return waitsService.waitForVisibilityLocatedBy(emailInputLocator);
    }

    public WebElement getPasswordInput() {
        return waitsService.waitForVisibilityLocatedBy(passwordInputLocator);
    }

    public WebElement getLoginButton() {
        return waitsService.waitForVisibilityLocatedBy(loginButtonLocator);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public void login(String username, String password) {
        getEmailInput().sendKeys(username);
        getPasswordInput().sendKeys(password);
        clickLoginButton();
    }
}
