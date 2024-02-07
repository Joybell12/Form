package com.Stageform;


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
        System.setProperty("webdriver.chrome.driver", "./folder/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-gpu");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(options);
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

