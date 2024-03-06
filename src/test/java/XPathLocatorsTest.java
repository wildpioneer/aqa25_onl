import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XPathLocatorsTest {
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
    public void xpathLocatorTest() {
        driver.get("file:/Users/aleksandr.trostyanko/Documents/Work/TeachMeSkills/Groups/aqa25onl/aqa25_onl/src/test/resources/index.html");

        // Абсолютный xpath
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[5]/form/div[1]/div[2]/input")).isDisplayed());

        // Все эелемнты на странице начина с HTML
        driver.findElements(By.xpath("//*"));

        // Поиска по tagName
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());

        // h4 на один уровень ниже родительского form
        Assert.assertTrue(driver.findElement(By.xpath("//form/h4")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("form > h4")).isDisplayed());

        // input на любом уровене ниже родительского form
        Assert.assertTrue(driver.findElement(By.xpath("//form//input")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("form input")).isDisplayed());

        // Поиск элемента с тэгом div у которого есть атрибут id
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]")).isDisplayed());
        // Поиск элемента с любым тэгом у которого есть атрибут id
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id]")).isDisplayed());

        // Поиск элемента у которого есть аттрибут id cо значением top-logo
        Assert.assertTrue(driver.findElement(By.id("cc2")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#cc2")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id = 'cc2']")).isDisplayed());

        Assert.assertTrue(driver.findElement(By.xpath("//*[@class = 'noSel']")).isDisplayed());

        // Поиск элемента у которого есть атрибут method cо значением и атрибут target со значением
        Assert.assertTrue(driver.findElement(By.xpath("//*[@method='post' and @target='_blank']")).isDisplayed());

        // Поиск элемента у которого есть атрибут method cо значением или атрибут target со значением
        Assert.assertTrue(driver.findElement(By.xpath("//*[@method='post' or @target='_blank']")).isDisplayed());

        // Поиск элемента у которого значение аттрибута начинается с
        Assert.assertTrue(driver.findElement(By.xpath("//p[starts-with(@title, 'Hell')]")).isDisplayed());

        // Поиск элемента у которого значение аттрибута содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(@title, 'beaut')]")).isDisplayed());

        // Поиск элемента у которого текстовое значение содержит равно
        Assert.assertTrue(driver.findElement(By.xpath("//h4[text() = 'Subscribe to my newsletter:']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h4[. = 'Subscribe to my newsletter:']")).isDisplayed());

        // Поиск элемента у которого текстовое значение содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'catego')]")).isDisplayed());

        // Поиск элемента по индексу
        Assert.assertTrue(driver.findElement(By.xpath("//ul/li[3]")).isDisplayed());
    }

    @Test
    public void axesXPathTest() {
        driver.get("file:/Users/aleksandr.trostyanko/Documents/Work/TeachMeSkills/Groups/aqa25onl/aqa25_onl/src/test/resources/index.html");

        // Поиск родителя у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/..")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h1/parent::div")).isDisplayed());

        // Поиск всех предков с тэгом div у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/ancestor::div")).isDisplayed());

        // Использование child - все дочерние элементы с тэго a от div
        Assert.assertTrue(driver.findElement(By.xpath("//div/h1")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div/child::h1")).isDisplayed());

        // Использование descendant - все дочерние элементы с тэго a от div
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='noSel']//ul")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='noSel']//descendant::ul")).isDisplayed());

        //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//form/div[@class='noSel']/following::h4")).isDisplayed());

        //Использование following-sibling - Выбирает все узлы одного уровня после текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//form/div[@class='noSel']/following-sibling::div")).isDisplayed());

        //Использование preceding- Выбирает все узлы, которые появляются перед текущим узлом в документе
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type=\"email\"]/preceding::h4")).isDisplayed());

        //Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type=\"email\"]/preceding::div[@style='overflow:auto;']/preceding-sibling::h4")).isDisplayed());


        //Гонки на виражах
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='text']/ancestor::div[@class='noSel newsletter']/form/h4[text() = 'Newscategories:']")).isDisplayed());
    }
}
