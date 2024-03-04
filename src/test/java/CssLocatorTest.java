import configuration.ReadProperties;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CssLocatorTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void cssLocatorTest() {
        driver.get("file:/Users/aleksandr.trostyanko/Documents/Work/TeachMeSkills/Groups/aqa25onl/aqa25_onl/src/test/resources/index.html");

        // Поиск по id
        Assert.assertTrue(driver.findElement(By.cssSelector("#my-Address")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("my-Address")).isDisplayed());               // Аналог

        // Поиск по class name
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("newsletter")).isDisplayed());        // Аналог

        // Поиск по нескольким значениям в аттрибуте class
        Assert.assertTrue(driver.findElement(By.cssSelector(".noSel.newsletter")).isDisplayed());

        // Поиск по tag name
        Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());                  // Аналог

        // Поиск по tag и значению из аттрибута class
        Assert.assertTrue(driver.findElement(By.cssSelector("div.intro")).isDisplayed());

        // Использование 2х уровневой иерархии для поиска дочернего элемента через findElement
        WebElement parent = driver.findElement(By.id("helpIntro"));
        WebElement child = parent.findElement(By.tagName("div"));
        Assert.assertEquals(1, driver.findElements(By.cssSelector("#helpIntro div")).size());
        Assert.assertEquals(2, driver.findElements(By.cssSelector("#Lastname .markup")).size());

        // Использование 3х уровневой иерархии для поиска дочернего элемента
        Assert.assertEquals(2, driver.findElements(By.cssSelector("div.intro #Lastname .markup")).size());

        // Поиск всех элементов с тэгом h1 или p
        Assert.assertEquals(8, driver.findElements(By.cssSelector("h1, p")).size());

        // Поиск всех элементов с тэгом p у которых непосредственный родитель с тэгом div
        Assert.assertEquals(6, driver.findElements(By.cssSelector("div > p")).size());

        // Поиск всех элементов с тэгом p которые идут сразу за элементом с тэго ul
        Assert.assertEquals(1, driver.findElements(By.cssSelector("ul + p")).size());

        // Поиск всех элементов с тэгом div которые являются братьями элементу с тэгом p и идут после тэга p
        Assert.assertEquals(2, driver.findElements(By.cssSelector("p ~ div")).size());

        // Поиск всех элементов у которых присутствует аттрибут title
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title]")).size());

        // Поиск всех элементов у которых присутствует аттрибут style с конкретным значением
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style='overflow: auto;']")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением заканчивающимся на какое-то value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id$='ess']")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то слово
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id|=my]")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то value
        Assert.assertEquals(2, driver.findElements(By.cssSelector("[id^=L]")).size());

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим слово целиком
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title~=beautiful]")).size());

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим какой текст
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title*=beaut]")).size());

    }
}
