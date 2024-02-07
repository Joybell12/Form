package com.Liveform;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Contactus {

    WebDriver driver;
    WebDriverWait wait;
    WebDriverWait wait1;
    JavascriptExecutor executor;

    public Contactus(WebDriver driver)
    {
        this.driver=driver;
        wait =new WebDriverWait(driver, Duration.ofSeconds(15));
        wait1 =new WebDriverWait(driver, Duration.ofSeconds(15));
        this.executor = (JavascriptExecutor) this.driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath="//a[normalize-space()='Contact us']")
    WebElement contact;

    @FindBy(xpath = "//div[@id='botbutton']")
    WebElement cont_load;

    @FindBy(xpath = ".//span[text()='Sigma Offerings*']")
    WebElement selection;

    @FindBy(xpath = ".//div[text()='eCommerce Solutions']")
    WebElement offeroption;

    @FindBy(xpath="//input[@id='coname']")
    WebElement cont_name;
    @FindBy (xpath="//input[@id='coemail']")
    WebElement cont_email;
    @FindBy(xpath = "//input[@id='org']")
    WebElement cont_org;
    @FindBy(xpath="//input[@id='coph']")
    WebElement cont_phonenumber;

    @FindBy(xpath="//textarea[@id='comsg']")
    WebElement cont_message;

    @FindBy(xpath = "//label[text()='checkbox_bottom']")
    WebElement terms;

    @FindBy(xpath = "//input[@id='cosub']")
    WebElement cont_submit;


    public void contactlink()
    {
        wait1.until(ExpectedConditions.elementToBeClickable(contact));
        contact.click();
    }

    public void contactpageload()
    {
        Boolean readyStateComplete = false;
        while (!readyStateComplete)
        {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            readyStateComplete = ((String) executor.executeScript("return document.readyState")).equals("complete");
        }
    }
    public void offer() {
        wait.until(ExpectedConditions.visibilityOf(selection));
        selection.click();
        wait.until(ExpectedConditions.visibilityOf(offeroption));
        offeroption.click();



    }
    public void scrollthepage()
    {
        executor.executeScript("window.scrollBy(0,530);");

    }


    public void contactname(String name)
    {
        wait.until(ExpectedConditions.visibilityOf(cont_name));
        cont_name.sendKeys(name);

    }

    public void contactemail(String email)
    {
        wait.until(ExpectedConditions.visibilityOf(cont_email));
        cont_email.sendKeys(email);

    }

    public void contactorg(String organisation)
    {
        wait.until(ExpectedConditions.visibilityOf(cont_org));
        cont_org.sendKeys(organisation);

    }
    public void contactphonenumber(String phonenumber)
    {
        wait.until(ExpectedConditions.visibilityOf(cont_phonenumber));
        cont_phonenumber.sendKeys(phonenumber);

    }
    public void contactmessage(String message)
    {
        wait.until(ExpectedConditions.visibilityOf(cont_message));
        cont_message.sendKeys(message);

    }

    public void termsandConditions()
    {
        wait.until(ExpectedConditions.elementToBeClickable(terms));
        terms.click();

    }
    public void submitbutton()
    {
        wait.until(ExpectedConditions.elementToBeClickable(cont_submit));
        cont_submit.click();

    }
}
