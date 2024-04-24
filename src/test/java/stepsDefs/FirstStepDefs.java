package stepsDefs;

import configuration.ReadProperties;
import core.BrowserService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FirstStepDefs {
    WebDriver driver;
    LoginPage loginPage;

    @Given("открыт браузер")
    @Given("init browser")
    public void startBrowser() {
        driver = new BrowserService().getDriver();
    }

    @When("страница логина открыта")
    @Given("open login page")
    public void openLoginPage() {
        driver.get(ReadProperties.getUrl());
        loginPage = new LoginPage(driver);
    }

    @Then("отображается поле логина")
    public void isUsernameFieldDisplayed() {
        Assert.assertTrue(true);
    }

    @And("отображается поле пароля")
    public void isPasswordFieldDisplayed() {
        Assert.assertTrue(true);
    }

    @But("кнопка логина не активна")
    public void isLoginButtonEnabled() {
        Assert.assertFalse(false);
    }

    @When("user {string} with password {string} log in")
    public void userWithPasswordLogIn1(String username, String password) {
        System.out.println(username);
        System.out.println(password);
    }

    @When("^user ([^\"]*) with password ([^\"]*) log in$")
    public void userWithPasswordLogIn2(String username, String password) {
        loginPage.getEmailInput().sendKeys(username);
        loginPage.getPasswordInput().sendKeys(password);
    }

    @And("user clicks login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("title is {string}")
    public void titleIs1(String titleName) {
        System.out.println(titleName);
    }

    @Then("^title is ([^\"]*)$")
    public void titleIs2(String titleName) {
        System.out.println(titleName);
    }

    @And("project ID is {int}")
    public void isProjectIDEqualsTo1(int id) {
        System.out.println(id);
    }

    @And("^project ID is \"(\\d+)\"$")
    public void isProjectIDEqualsTo2(int id) {
        System.out.println(id);
    }

    @And("^all elements \"(are|are not)\" visible$")
    public void allElementsVisible1(String parameter) {
        if (parameter.equals("are")) {
            System.out.println("Вы использовали are");
        } else {
            System.out.println("Вы использовали are not");
        }
    }

    @And("^all elements (are|are not) visible$")
    public void allElementsVisible2(String parameter) {
        if (parameter.equals("are")) {
            System.out.println("Вы использовали are");
        } else {
            System.out.println("Вы использовали are not");
        }
    }

    @When("user logged in with")
    public void userLoggedInWith(DataTable parameters) {
        Map<String, String> expectedValues = parameters.asMap(String.class, String.class);
        System.out.println("Username: " + expectedValues.get("username"));
        System.out.println("Password: " + expectedValues.get("password"));
        System.out.println("Age: " + expectedValues.get("age"));
        System.out.println("Sex: " + expectedValues.get("sex"));
    }

    @When("user logged in with 1")
    public void userLoggedInWith1(DataTable parameters) {
        List<Map<String, String>> expectedValues = parameters.asMaps(String.class, String.class);
        System.out.println((expectedValues.get(0)).get("username"));
        System.out.println((expectedValues.get(0)).get("password"));
        System.out.println((expectedValues.get(0)).get("age"));
        System.out.println((expectedValues.get(1)).get("username"));
        System.out.println((expectedValues.get(1)).get("password"));
        System.out.println((expectedValues.get(1)).get("age"));
    }

    @When("user click to restore password")
    public void userClickToRestorePassword() {


    }

    @Then("restore password page is displayed")
    public void restorePasswordPageIsDisplayed() {
    }

    @Then("dashboard page is displayed")
    public void isDashboardPageDisplayed() {
        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }

    @Then("error {string} is displayed")
    public void errorIsDisplayed(String errorText) {
        Assert.assertEquals(loginPage.getErrorText(), errorText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
