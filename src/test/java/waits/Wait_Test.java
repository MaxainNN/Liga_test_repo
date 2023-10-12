package waits;

import browser.Browser;
import main_pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.base.BasePage;
import pages.elements.ElementsPage;

import java.time.Duration;

import static constants.Constant.URLS.START_PAGE_URL;

public class Wait_Test {
    private WebDriver driver;
//    private BasePage basePage;
    private MainPage mainPage;
    private ElementsPage elementsPage;

    @BeforeClass
    public void beforeClass(){
        driver = Browser.createDriver();
//        basePage = new BasePage(driver);
        mainPage = new MainPage(driver);
        mainPage.openStartPage();
//        basePage.openStartPage();

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
    @Test
    public void step_01(){
        String xpath = "//button[@id='visibleAfter']";
        elementsPage = mainPage.openCategoryElements();
        elementsPage.click("//span[text()='Dynamic Properties']");
        elementsPage.waitElementDisplay(xpath);
        elementsPage.click(xpath);
        Assert.assertTrue(elementsPage.findElement(xpath).isEnabled());
    }

    @Test
    public void step_02(){
        elementsPage.openStartPage();
        mainPage.openCategoryElements();
        String xpath = "//button[@id='enableAfter']";
        elementsPage.click("//span[text()='Dynamic Properties']");
//        elementsPage.waitElementDisplay(xpath);
//        elementsPage.click(xpath);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d-> elementsPage.findElement(xpath).isEnabled());
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(elementsPage.findElement(xpath)));
        Assert.assertTrue(elementsPage.findElement(xpath).isEnabled());
    }
}
