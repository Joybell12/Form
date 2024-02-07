package com.Stageform;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;

import static java.awt.SystemColor.window;


public class testcontact {

    @Test
    public void testcontact() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./folder/chromedriver");
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://staging.sigmainfo.net/contact-us/");
        WebDriverWait we1= new WebDriverWait(driver, Duration.ofSeconds(100));

        driver.findElement(By.xpath("//a[normalize-space()='Contact us']")).click();


        Thread.sleep(5000);

        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
        WebElement dropdow =we1.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(".//span[text()='Sigma Offerings*']")));
        dropdow.click();
        WebElement offeroption =we1.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(".//div[text()='eCommerce Solutions']")));

        offeroption.click();

        WebElement name =we1.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='coname']")));
        name.sendKeys("sigma test");


        WebElement email =we1.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='coemail']")));
        email.sendKeys("testsigma@sigmainfo.net");

        WebElement org =we1.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='org']")));
        org.sendKeys("Sigma Test");




        WebElement phnumber =we1.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='coph']")));
        phnumber.sendKeys("9876543210");

        WebElement message =we1.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//textarea[@id='comsg']")));
        message.sendKeys("Sigma Test");

        Actions action=new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();


        WebElement terms =we1.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//span[@class='wpcf7-list-item first last']//label)[1]")));
        terms.click();

        WebElement submit =we1.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='cosub']")));
        submit.click();
        driver.quit();






    }
}