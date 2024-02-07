package com.Stageform;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class testPartners {

    @Test
    public void testpartners() {
        System.setProperty("webdriver.chrome.driver","./folder/chromedriver");
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://staging.sigmainfo.net/partners/");
        WebDriverWait we1= new WebDriverWait(driver, Duration.ofSeconds(100));
        WebDriverWait we2= new WebDriverWait(driver,Duration.ofSeconds(120));
        //JavascriptExecutor jse = (JavascriptExecutor) driver;
        //WebElement element=driver.findElement(By.xpath("//textarea[@id='comsg']"));
        //jse4.executeScript("arguments[0].scrollIntoView();",element);
        //jse.executeScript("window.scrollBy(0,1200)");

        JavascriptExecutor jse1=(JavascriptExecutor)driver;
        jse1.executeScript("window.scrollBy(0,800)");
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



        WebElement submit =we2.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='cosub']")));
        submit.click();

        driver.quit();






    }
}