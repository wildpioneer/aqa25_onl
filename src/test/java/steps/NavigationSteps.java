package steps;

import baseEntities.BaseSteps;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class NavigationSteps extends BaseSteps {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    public NavigationSteps(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    private void login(String username, String password) {
        loginPage
                .setEmail(username)
                .setPassword(password)
                .clickLoginButton();
    }

    public DashboardPage successfulLogin(String username, String password) {
        login(username, password);
        return dashboardPage;
    }

    public DashboardPage successfulLogin(User user) {
        return successfulLogin(user.getEmail(), user.getPassword());
    }

    public LoginPage incorrectLogin(String username, String password) {
        login(username, password);
        return loginPage;
    }

    public void navigateToDashboardByUrl() {
        dashboardPage = new DashboardPage(driver, true);
    }
}
