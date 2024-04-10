package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.NavigationSteps;

public class RadioButtonTest extends BaseTest {

    @Test
    public void radioButtonTest() {
        NavigationSteps navigationSteps = new NavigationSteps(driver);
        navigationSteps.successfulLogin(ReadProperties.username(), ReadProperties.password());

        driver.get("https://aqa2505.testrail.io/index.php?/admin/projects/add");
        RadioButton radioButton = new RadioButton(driver, By.name("suite_mode"));
        radioButton.selectByValue2("3");
        radioButton.selectByText1("Use a single repository with baseline support");
/*
        radioButton.selectByIndex(1);
        radioButton.selectByIndex(2);
        radioButton.selectByIndex(0);
*/

        driver.get("https://aqa2505.testrail.io/index.php?/admin/site_settings#");
        radioButton = new RadioButton(driver, By.name("restore_backup"));
        radioButton.selectByText1("5th Apr 2024 04:00");
/*
        radioButton.selectByIndex(1);
        radioButton.selectByIndex(2);
        radioButton.selectByIndex(0);
        radioButton.selectByIndex(5);
*/
    }
}
