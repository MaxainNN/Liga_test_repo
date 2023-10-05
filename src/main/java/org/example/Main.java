package org.example;

import org.openqa.selenium.By;
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
        button.click();


    }
}