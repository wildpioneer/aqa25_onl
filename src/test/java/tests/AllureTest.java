package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllureTest {

    @Test(description = "Human-readable test name")
    public void testName() {
        Assert.assertTrue(true);
    }

    @Test
    @Description("Some detailed test description.")
    public void testDescription() {
        Assert.assertTrue(true);
    }

    @Test(description = "Тест на проверку логина")
    @Description("Проверяем логин с корректными кредами")
    public void testNameAndDescription() {
        Assert.assertTrue(true);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testSeverity() {
        Assert.assertTrue(true);
    }

    @Test
    @TmsLink("TMS-123")
    @TmsLink("TMS-456")
    public void testTMS() {
        Assert.assertTrue(true);
    }

    @Test
    @Issue("BUG-123")
    public void testIssue() {
        Assert.assertTrue(true);
    }

}
