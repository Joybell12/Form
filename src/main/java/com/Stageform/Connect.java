package com.Stageform;

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
        //System.setProperty("webdriver.chrome.driver", "./folder/chromedriver");
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://staging.sigmainfo.net/magento-2-migration-services/");
    }

    @Test
    public void ConnectFormSubmission() throws InterruptedException {
        cntus= new Sigma(driver);
        cntus.contactname("name");
        cntus.contactemail("emailid");
        cntus.contactphonenumber("8959281994");
        cntus.termsandConditions();
        cntus.submitbutton();
        cntus.pageloadwaitforsuccessmessage();
        cntus.cotactusvalidate();

    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

}
