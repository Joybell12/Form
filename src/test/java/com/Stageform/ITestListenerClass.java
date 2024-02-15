
package com.Stageform;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public  class ITestListenerClass extends BaseTest implements ITestListener {

    public ExtentReports extent;// Populate common info on the report
    public ExtentTest test;// Creating test case entries in the report and update status of the test methods
    public ExtentSparkReporter sparkReporter;// UI of the Report
    String repName;

    public void onTestStart(ITestResult context)
    {
        SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        Date dt=new Date();
        String currentdatetimestamp= df.format(dt);
        repName = "Test-report"+ currentdatetimestamp + ".html";
        sparkReporter = new ExtentSparkReporter( "./reports/"+ repName);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Sigma Form");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Automation report for Sigma form");


        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Environment","Staging");
        extent.setSystemInfo("Tester name","Patricia");
        extent.setSystemInfo("Browser name","chrome");



    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test=extent.createTest(result.getTestClass().getName());//create a new entry in the report
        test.log(Status.PASS,"Test case is Pass " + " "+  result.getName());// update status f/p/s

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        test=extent.createTest(iTestResult.getTestClass().getName());
        test.log(Status.FAIL,"Test case is Fail"+ " "+ "-" +" "+ iTestResult.getName());
        test.log(Status.FAIL,"Test case Failed is"+ " "+ iTestResult.getThrowable());

            /*String imgpath=new BaseTest().captureScreenshot(iTestResult.getName());
            test.addScreenCaptureFromPath(imgpath);*/
        if(iTestResult.getStatus() == ITestResult.FAILURE)
        {
        String screenshotpath;
        screenshotpath = captureScreenshot(iTestResult.getTestContext().getName()+ "_"+iTestResult.getMethod().getMethodName()+".png");
        test.addScreenCaptureFromPath(screenshotpath);
        }


    }


    @Override
    public void onTestSkipped(ITestResult result) {
        test=extent.createTest(result.getName());
        test.log(Status.SKIP,"Test case is skipped :"+" "+   result.getName());

    }
    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}

