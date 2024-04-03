package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScreenShotTest extends BaseTest {

    @Test
    public void failedTest() {
        Assert.assertTrue(false);
    }
}
