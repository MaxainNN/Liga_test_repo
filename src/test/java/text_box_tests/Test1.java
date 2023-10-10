package text_box_tests;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.base.BasePage;


import java.time.Duration;

import static constants.Constant.URLS.START_PAGE_URL;

public class Test1 {
    private WebDriver driver;
    private BasePage basePage;

//    private WebElement blockElements = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[3]/h5"));
//    private WebElement textBoxElements = driver.findElement(By.xpath("//*[@id=\"item-0\"]/span"));
//    private WebElement textResultElement = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']"));

    @BeforeClass
    public void beforeClass(){
        driver = Browser.createDriver();
        driver.get(START_PAGE_URL);
        basePage.openStartPage();

    }

    @Test
    public void step_01(){
//        WebElement blockElements = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[3]/h5"));
//        WebElement textBoxElements = driver.findElement(By.xpath("//*[@id=\"item-0\"]/span"));


//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView()", blockElements);
//        blockElements.click();
        basePage.click("//*[@id=\\\"app\\\"]/div/div/div[2]/div/div[1]/div/div[3]/h5");
//        WebElement textResultElement = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']"));
//        js.executeScript("arguments[0].scrollIntoView()", textBoxElements);
//        String text = textResultElement.getText();
        String text = basePage.getText("div[@class='col-12 mt-4 col-md-6");
        String textResult = "Please select an item from left to start practice.";
        Assert.assertTrue(text.equals(textResult));
//        Assert.assertEquals(text,textResult);


    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
