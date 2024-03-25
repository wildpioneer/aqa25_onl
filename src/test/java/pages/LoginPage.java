package pages;

import baseEntities.BasePage;
import configuration.ReadProperties;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private final static String pagePath = "";

    // Блок описания локаторов для элементов
    @FindBy(id = "name")
    public WebElement emailInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "button_primary")
    public WebElement loginButton;

    @FindBy(className = "error-text")
    public WebElement errorTextLabel;

    // Блок иницализации
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return emailInput;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    // Блок атомарных методов
    public LoginPage setEmail(String value) {
        emailInput.sendKeys(value);
        return this;
    }

    public LoginPage setPassword(String value) {
        passwordInput.sendKeys(value);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getErrorText() {
        return errorTextLabel.getText();
    }

    private void login(String username, String password) {
        this
                .setEmail(username)
                .setPassword(password)
                .clickLoginButton();
    }

    public DashboardPage successfulLogin(String username, String password) {
        login(username, password);
        return new DashboardPage(driver);
    }

    public LoginPage incorrectLogin(String username, String password) {
        login(username, password);
        return this;
    }
}
