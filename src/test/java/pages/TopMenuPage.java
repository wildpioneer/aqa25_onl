package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class TopMenuPage {
    private static final By topPanelLocator = By.className("top-panel");

    // Блок иницализации

    // Блок атомарных методов
    public SelenideElement getTopPanel() {
        return $(topPanelLocator);
    }
}
