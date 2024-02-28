import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
    }

    @Test
    public void validateIKTCalculation() throws InterruptedException {
        driver.get("https://clinic-cvetkov.ru/company/kalkulyator-imt/");

        WebElement weight = driver.findElement(By.name("weight"));
        WebElement height = driver.findElement(By.name("height"));
        WebElement button = driver.findElement(By.id("calc-mass-c"));

        weight.sendKeys("58");
        height.sendKeys("183");
        button.click();

        Thread.sleep(2000);

        WebElement result = driver.findElement(By.id("imt-result"));

        Assert.assertEquals(result.getText(), "17.4 - Недостаточная (дефицит) масса тела");
    }

    @Test
    public void validateSKF() throws InterruptedException {
        driver.get("https://bymed.top/calc/%D1%81%D0%BA%D1%84-2148");
        Thread.sleep(2000);

        driver.switchTo().frame(1);

        WebElement selectWebElement = driver.findElement(By.id("cr-size"));
        Select selectSex = new Select(selectWebElement);

        selectSex.selectByIndex(1);
        Thread.sleep(2000);

        selectSex.selectByValue("mm");
        Thread.sleep(2000);

        selectSex.selectByVisibleText("мг/дл");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
