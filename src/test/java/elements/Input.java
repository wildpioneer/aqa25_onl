package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {
    private UIElement uiElement;

    public Input(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public void sendKeys(CharSequence... keysToSend) {
        uiElement.sendKeys(keysToSend);
    }

    public void clearAndSendKeys(CharSequence... keysToSend) {
        uiElement.click();
        sendKeys(keysToSend);
    }

    public boolean isDisplayed() {
        return uiElement.isDisplayed();
    }
}
