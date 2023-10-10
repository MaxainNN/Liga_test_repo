package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        WebElement userNameInput = driver.findElement(By.xpath("//input[@id='userName']"));
        userNameInput.sendKeys("Max");
        // //h5[text()='Elements']/../. - also can use
//        Actions actions = new Actions(driver);
//        actions.scrollToElement(driver.findElement(By.xpath("")));
//        userNameInput.click();
        WebElement emailElement = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
        emailElement.sendKeys("BlindFoxKingdom@yandex.com");
//        emailElement.click();
        WebElement currentAddressElement = driver.findElement(By.xpath("//*[@id=\"currentAddress\"]"));
        currentAddressElement.sendKeys("Krukova Street 16 appartment 82");
        WebElement permanentAddressElement = driver.findElement(By.xpath("//*[@id=\"permanentAddress\"]"));
        permanentAddressElement.sendKeys("New York");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
//        button.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",button);
        button.click();
        WebElement userNameOutput = driver.findElement(By.xpath("//p[@id='name']"));
        WebElement userEmailOutput = driver.findElement(By.xpath("//p[@id='email']"));
        WebElement userCurAddOutput = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        WebElement userPerAddOutput = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String name = userNameOutput.getText();
        String email = userEmailOutput.getText();
        String curAdd = userCurAddOutput.getText();
        String perADd = userPerAddOutput.getText();
        System.out.println(name + "\n " + email + "\n " + curAdd + "\n " + perADd);


    }
}