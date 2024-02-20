package com.Stageform;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Sigma extends BaseTest{

    WebDriverWait wait;
    WebDriverWait wait1;
    JavascriptExecutor executor;
    WebDriverWait wait2;
    Actions action;

    String pageLoadStatus = null;



    public Sigma(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait2 = new WebDriverWait(driver, Duration.ofSeconds(40));
        this.executor = (JavascriptExecutor) this.driver;
        action=new Actions(driver);
        PageFactory.initElements(driver, this);

    }


     @FindBy(xpath = "//ul[contains(@class, 'sf-menu')]/li/a[text()='Contact Us']")
    WebElement contact;

    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    WebElement contactlive;




    @FindBy(xpath = "//div[@id='botbutton']")
    WebElement cont_load;

    @FindBy(xpath = ".//span[text()='Sigma Offerings*']")
    WebElement selection;

    @FindBy(xpath = ".//div[text()='eCommerce Solutions']")
    WebElement offeroption;

    @FindBy(xpath = "//input[@id='coname']")
    WebElement cont_name;
    @FindBy(xpath = "//input[@id='coemail']")
    WebElement cont_email;
    @FindBy(xpath = "//input[@id='org']")
    WebElement cont_org;
    @FindBy(xpath = "//input[@id='coph']")
    WebElement cont_phonenumber;

    @FindBy(xpath = "//textarea[@id='comsg']")
    WebElement cont_message;

    @FindBy(xpath = "(//span[@class='wpcf7-list-item first last']//label)[1]")
    WebElement terms;

    @FindBy(xpath = "//input[@id='cosub']")
    WebElement cont_submit;

    @FindBy(xpath = "//input[@id='coname']")
    WebElement Yourname;

    @FindBy(xpath = "//input[@id='coemail']")
    WebElement Youremail;


    @FindBy(xpath = "//input[@name='tel-564']")
    WebElement Yourphonenumber;

    @FindBy(xpath = "//p[text()='CONNECT WITH US']")
    WebElement connectwithus;

    @FindBy(xpath = "//input[@id='dropsub']")
    WebElement connect_submit;

    @FindBy(xpath = "//p[text()='Thanks for Contacting Us!']")
    WebElement success_message;

    @FindBy(xpath = "//h2[text()='Interested in learning more about our services?']")
    WebElement contact_text;

     @FindBy(xpath="//body[contains(@class,'page-template-default')]")
     WebElement animation;
    public void contactlink() {
        wait.until(ExpectedConditions.elementToBeClickable(contact));
        contact.click();
    }

    public void contactpageload() {
        do {

            executor = (JavascriptExecutor) driver;

            pageLoadStatus = (String)executor.executeScript("return document.readyState");

        } while ( !pageLoadStatus.equals("complete") );

        System.out.println("Page Loaded.");



        }


    public void offer() {
        wait2.until(ExpectedConditions.elementToBeClickable(selection));
        scrollIntoView(selection);
        selection.click();
        wait2.until(ExpectedConditions.elementToBeClickable(offeroption));
        offeroption.click();


    }

    public void scrollIntoView(WebElement selection) {
        executor.executeScript("arguments[0].scrollIntoView()", selection);
    }


    public void contactname(String name) {
        wait.until(ExpectedConditions.visibilityOf(cont_name));
        cont_name.sendKeys(name);

    }

    public void contactemail(String email) {
        wait.until(ExpectedConditions.visibilityOf(cont_email));
        cont_email.sendKeys(email);

    }

    public void contactorg(String organisation) {
        wait.until(ExpectedConditions.visibilityOf(cont_org));
        cont_org.sendKeys(organisation);

    }

    public void contactphonenumber(String phonenumber) {
        wait.until(ExpectedConditions.visibilityOf(cont_phonenumber));
        cont_phonenumber.sendKeys(phonenumber);

    }

    public void scrollthepage() {
        executor.executeScript("window.scrollBy(0,250);");

    }
    public void scrollthepageforpartners() {
        executor.executeScript("window.scrollBy(0,800);");

    }

    public void contactmessage(String message) {
        wait.until(ExpectedConditions.visibilityOf(cont_message));
        cont_message.sendKeys(message);

    }

    public void termsandConditions() {

        wait1.until(ExpectedConditions.elementToBeClickable(terms));

        terms.click();

    }
    public void pagedownto()
    {
         action.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public void submitbutton() throws InterruptedException {
        wait1.until(ExpectedConditions.elementToBeClickable(cont_submit));
        cont_submit.click();


    }

    public void scrollthepageforconnect() {
        executor.executeScript("arguments[0].scrollIntoView();", connectwithus);
    }

    public void enteryourname(String yourname) {
        wait.until(ExpectedConditions.visibilityOf(Yourname));
        Yourname.sendKeys(yourname);

    }

    public void enteryouremail(String youremail) {
        wait.until(ExpectedConditions.visibilityOf(Youremail));
        Youremail.sendKeys(youremail);
    }

    public void enteryourphonenumber(String yourphonenumber) {
        wait.until(ExpectedConditions.visibilityOf(Yourphonenumber));
        Yourphonenumber.sendKeys(yourphonenumber);
    }

    public void submittheconnectform() {
        wait.until(ExpectedConditions.visibilityOf(connect_submit));
        connect_submit.click();
    }

    public void pageload() {
        wait.until(ExpectedConditions.visibilityOf(cont_submit));

    }

    public void pageloadconnect() {
        wait2.until(ExpectedConditions.visibilityOf(connect_submit));

    }

    public void pageloadwaitforsuccessmessage() {
        wait.until(ExpectedConditions.visibilityOf(success_message));
    }

    public void cotactusvalidate() {
        String t = "Thanks for Contacting Us!";
        if (driver.getPageSource().contains("Thanks for Contacting Us!")) {
            System.out.println("Text: " + t + " is present. ");
        } else {
            System.out.println("Text: " + t + " is not present. ");
        }
    }


    public void scrollthepagepartners() {
        executor.executeScript("arguments[0].scrollIntoView();", cont_submit);

    }
    public void loadrefresh() {
        wait2.until(ExpectedConditions.visibilityOf(contact_text));

    }

}
