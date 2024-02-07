package com.Liveform;

import com.Stageform.Sigma;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Connect {
    WebDriver driver;
    public Sigma cntus;

    @BeforeMethod
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", "./folder/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sigmainfo.net/bi-analytics/");
    }

    @AfterMethod
    public void quitDriver() {

        driver.quit();

    }

    @Test
    public void testConnectFormSubmission() throws InterruptedException {
        cntus= new Sigma(driver);
        cntus.scrollthepageforconnect();
        cntus.enteryourname("Sigma Test");
        cntus.enteryouremail("sigmatest@sigmainfo.net");
        cntus.enteryourphonenumber("8959281994");
        cntus.termsandConditions();
        cntus.submittheconnectform();

    }

}
