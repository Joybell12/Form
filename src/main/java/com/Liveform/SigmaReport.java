package org.sigma.report;

import com.Liveform.Contactus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SigmaReport {
    WebDriver driver;
    public Contactus cntus;

    @BeforeMethod
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", "./folder/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sigmainfo.net/");
    }

    @AfterMethod
    public void quitDriver() {

            driver.quit();

    }

    @Test
    public void testContactFormSubmission() throws InterruptedException {
            cntus= new Contactus(driver);
        //cntus.contactpageload();
           cntus.contactlink();
           cntus.scrollthepage();
            cntus.offer();
            cntus.contactname("Sigma Test");

            cntus.contactemail("sigmatest@sigmainfo.net");
            cntus.contactorg("Sigma Test");
            cntus.contactphonenumber("8959281994");
            cntus.contactmessage(" Sigma Test");
            cntus.termsandConditions();
            cntus.submitbutton();
        
    }

}
