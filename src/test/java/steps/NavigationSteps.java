package steps;

import baseEntities.BaseSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class NavigationSteps extends BaseSteps {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    public NavigationSteps(WebDriver driver) {
        super(driver);
    }

    @Step("успешный логин")
    public DashboardPage successfulLogin(String username, String password) {
        loginPage = new LoginPage(driver);
        return loginPage.successfulLogin(username, password);
    }

    @Step("incorrectLogin")
    public LoginPage incorrectLogin(String username, String password) {
        loginPage = new LoginPage(driver);
        return loginPage.incorrectLogin(username, password);
    }

    public void navigateToDashboardByUrl() {
        dashboardPage = new DashboardPage(driver);
    }
}
