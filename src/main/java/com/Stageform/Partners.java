package com.Stageform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Partners {
    WebDriver driver;
    public Sigma cntus;

    @BeforeMethod
    public void createDriver() {
        //System.setProperty("webdriver.chrome.driver", "./folder/chromedriver");
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://staging.sigmainfo.net/partners/");
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

    @Test
    public void PartnersFormSubmission() throws InterruptedException {
        cntus= new Sigma(driver);

        cntus.scrollthepageforpartners();
        cntus.contactname("Sigma Test");
        cntus.contactemail("sigmatest@sigmainfo.net");
        cntus.contactorg("Sigma Test");
        cntus.contactphonenumber("8959281994");
        cntus.pagedownto();
        cntus.contactmessage(" Sigma Test");
        cntus.termsandConditions();
        cntus.submitbutton();
        cntus.pageloadwaitforsuccessmessage();
        cntus.cotactusvalidate();

    }

}
