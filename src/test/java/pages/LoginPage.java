package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final static String pagePath = "/";

    // Блок описания локаторов для элементов
    private static final By emailInputLocator = By.id("name");
    private final By passwordInputLocator = By.id("password");
    private final By loginButtonLocator = By.id("button_primary");
    private final By errorTextLabelLocator = By.className("error-text");

    // Блок иницализации
    public void openPage() {
        open(pagePath);
    }

    // Блок атомарных методов
    public SelenideElement getEmailInput() {
        return $(emailInputLocator).shouldBe(visible);
    }

    public LoginPage setEmail(String value) {
        getEmailInput().sendKeys(value);
        return this;
    }

    public SelenideElement getPasswordInput() {
        return $(passwordInputLocator);
    }

    public LoginPage setPassword(String value) {
        getPasswordInput().sendKeys(value);
        return this;
    }

    public SelenideElement getLoginButton() {
        return $(loginButtonLocator);
    }

    public SelenideElement getErrorTextLabel() {
        return $(errorTextLabelLocator);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public String getErrorText() {
        return getErrorTextLabel().getText();
    }


    private void login(String username, String password) {
        this
                .setEmail(username)
                .setPassword(password)
                .clickLoginButton();
    }

    public DashboardPage successfulLogin(String username, String password) {
        login(username, password);
        return new DashboardPage();
    }

    public LoginPage incorrectLogin(String username, String password) {
        login(username, password);
        return this;
    }
}
