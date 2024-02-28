package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDriver {

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/aleksandr.trostyanko/Documents/Work/TeachMeSkills/Groups/aqa25onl/aqa25_onl/src/test/resources/chromedriver");

        return new ChromeDriver();
    }
}
