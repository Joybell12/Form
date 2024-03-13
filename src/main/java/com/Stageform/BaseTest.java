package com.Stageform;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import variables.configproperities;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

//import static sun.net.www.ParseUtil.toURI;


public class BaseTest {


   public static WebDriver driver;

    @BeforeMethod
    public void classLevelSetup() {
       
        //System.setProperty("webdriver.chrome.driver", "./folder/chromedriver");
       WebDriverManager.chromedriver().setup();
        //String chromeVersion = "/usr/bin/google-chrome-stable";
        //String path = System.getProperty("user.dir") + "/folder/chromedriver.exe";
        //System.setProperty("webdriver.chrome.driver", path);                          
        //System.out.println("user" + path);
       
        //System.out.println("step1" + System.getProperty("webdriver.chrome.driver"));
        //WebDriverManager.chromedriver().setup();
        //ChromeOptions options = new ChromeOptions();
        //options.setBinary("/usr/bin/google-chrome-stable");
        //options.addArguments("--headless");
        //options.addArguments("--disable-dev-shm-usage");
        //options.addArguments("--no-sandbox");
        //options.addArguments("enable-automation");
        //options.addArguments("--disable-extensions");
        //options.addArguments("--dns-prefetch-disable");
        //options.addArguments("--disable-gpu");
        //options.setExperimentalOption("useAutomationExtension",false);
        //options.setPageLoadStrategy(PageLoadStrategy.NONE);
        //options.addArguments("--start-maximized");
        //options.addArguments("window-size=1920,1080");
        //System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
        //System.setProperty("webdriver.chrome.verboseLogging", "true");
     
        driver = new ChromeDriver();
        System.out.println("step2" + driver);
       
        driver.manage().window().maximize();
        //extentTest = extentReports.createTest(context.getName());
        configproperities.initializePropertyFile();
        driver.navigate().to(configproperities.property.getProperty("AppURL"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    public String captureScreenshot(String tname)  {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFilePath = new File("./reports/" + tname);

        try{

            //File destinationfile=new File(destinationFilePath);
            FileUtils.copyFile(screenshotFile, destinationFilePath);

        }
        catch (Exception e)
        {
            System.out.println("Error capturing screenshot: " + e.getMessage());
        }


        return tname;
    }


}

