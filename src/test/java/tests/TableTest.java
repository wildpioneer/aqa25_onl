package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import elements.RadioButton;
import elements.Table;
import elements.TableCell;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.NavigationSteps;

public class TableTest extends BaseTest {

    @Test
    public void tableTest() {
        NavigationSteps navigationSteps = new NavigationSteps(driver);
        navigationSteps.successfulLogin(ReadProperties.username(), ReadProperties.password());

        driver.get("https://aqa2505.testrail.io/index.php?/admin/projects/overview");
        Table table = new Table(driver, By.cssSelector("table.grid"));
        TableCell cell = table.getCell("Project", "9mwsha4a9w1j2o46e137", 2);
        cell.getAsUIElement().click();
    }
}
