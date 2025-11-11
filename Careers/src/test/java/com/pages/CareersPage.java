package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stepDefinitionTestNG.Hooks;


public class CareersPage extends BasePage{

	WebDriver driver = Hooks.driver;

	 @FindBy(xpath = "//*[@id=\"lazyhome_Footer\"]/section/div/div[2]/div[2]")
     static WebElement footerLink;
	
    @FindBy(xpath = "//a[text()='Careers']")
     static WebElement careersLink;

    @FindBy(xpath = "//h4[text()='OPEN POSITIONS']")
    static WebElement openPositions;

    @FindBy(xpath = "//a[text()='Internship - Research Analyst']")
    static WebElement internshipLink;

    
    @FindBy(xpath="/html/body/section[2]/article/div[2]/div/div/div/div[1]/div[2]")
    static WebElement jobFooter;
    
    @FindBy(xpath = "//h4[text()='Job Details']")
    static WebElement jobDetails;

    public CareersPage() {
        PageFactory.initElements(driver, this);
    }

    public  void scrollToFooter() throws InterruptedException {
        scrollToElement(footerLink);
       // waitForElementVisible(careersLink);

    }

    public  void clickCareersLink() throws InterruptedException {
        clickElement(careersLink);
       // waitForElementVisible(careersLink);

    }

    public  void verifyJoinUsPage() throws InterruptedException {
        
        if(driver.getTitle().equals("REASONS TO WORK WITH US"))
        {
        	Thread.sleep(1000);
        }
    }

    public  void scrollToOpenPositions() throws InterruptedException {
        scrollToElement(openPositions);
    }

    public  void clickInternshipLink() throws InterruptedException {
        clickElement(internshipLink);
    }

    public  void switchToJobDescriptionTab() {
        switchToNewTab();
    }


    public void verifyJobDescriptionPage() throws InterruptedException {
    if(driver.getTitle().equals("Internship - Research Analyst,Edureka")) 
    {
    		Thread.sleep(1000);
    }
    }

    public void scrollToJobDetails() throws InterruptedException  {
        scrollToElement(jobFooter);
        
        
        
    }
    
    
    
    
    
    @FindBy(xpath = "//a[text()='Blog']")
    static WebElement blog;
    
    @FindBy(xpath="//*[@id=\"navbarSupportedContent\"]/ul[1]/li[4]/a")
    static WebElement ebook;
    
    @FindBy(xpath="/html/body/section[2]/div/div/div[1]/div/div/a/img")
    static WebElement awsBook;
    
    public  void clickBlog() throws InterruptedException {
        clickElement(blog);
       // waitForElementVisible(careersLink);

    }
    
    public  void clickEbook() throws InterruptedException {
        clickElement(ebook);
       // waitForElementVisible(careersLink);

    }
    
    public  void clickAWSBook() throws InterruptedException {
        clickElement(awsBook);
       // waitForElementVisible(careersLink);

    }
    
    public void verifyEbook()
    {
    	    if(driver.getTitle().equals("Free AWS Ebook"))
    	    {
    	    	   System.out.println(driver.getTitle());
    	    }
    }
    
}
