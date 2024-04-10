package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TableCell {
    private UIElement uiElement;
    private WebDriver driver;

    public TableCell(WebDriver driver, UIElement uiElement) {
        this.driver = driver;
        this.uiElement = uiElement;
    }

    public UIElement getAsUIElement() {
        return uiElement;
    }

    public UIElement getLink() {
        return uiElement.findElement(By.tagName("a"));
    }
}
