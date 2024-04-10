package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class BaseSteps {
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;

    public BaseSteps() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
    }
}
