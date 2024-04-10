package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DashboardPage {
    private final static String pagePath = "/index.php?/dashboard";

    // Блок описания локаторов для элементов
    private static final By headerTitleLabelLocator =
            By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'All Projects')]");

    public TopMenuPage topMenuPage;

    // Блок иницализации
    public void openPage() {
        open(pagePath);
    }

    // Блок атомарных методов
    public SelenideElement getHeaderTitleLabel() {
        return $(headerTitleLabelLocator);
    }
}
