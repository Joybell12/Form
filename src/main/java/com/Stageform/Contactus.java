package com.Stageform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import variables.configproperities;


public class Contactus extends BaseTest{

    public Sigma cntus;



    @Test
    public void ContactusFormSubmission() throws InterruptedException {

           cntus= new Sigma(driver);
           cntus.contactlink();
           //Thread.sleep(8000);
           cntus.offer();
           cntus.contactname(configproperities.property.getProperty("name"));
           cntus.contactemail(configproperities.property.getProperty("emailid"));
           cntus.contactorg(configproperities.property.getProperty("name"));
           cntus.contactphonenumber(configproperities.property.getProperty("phoneNumber"));
           cntus.pagedownto();
           cntus.contactmessage(configproperities.property.getProperty("name"));
           cntus.termsandConditions();
           cntus.submitbutton();
           cntus.pageloadwaitforsuccessmessage();
           cntus.cotactusvalidate();
        
    }

}
