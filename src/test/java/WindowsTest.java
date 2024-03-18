import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsTest extends BaseTest {

    @Test
    public void newTabTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/windows");

        String originalWindow = driver.getWindowHandle();

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandlesSet = driver.getWindowHandles();
        List<String> windowHandleList = new ArrayList<>(windowHandlesSet);

        driver.switchTo().window(windowHandleList.get(1));
        driver.switchTo().window(originalWindow);

        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "New Window");
    }
}
