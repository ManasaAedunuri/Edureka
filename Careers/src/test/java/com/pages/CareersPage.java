package com.pages;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.Reports;
import com.stepDefinitionTestNG.Hooks;

import io.cucumber.java.en.Then;


public class CareersPage extends BasePage{

	WebDriver driver = Hooks.driver;
//	List<String[]> excelData;
//    int rowIndex = 0;
	//*[@id=\"lazyhome_Footer\"]/section/div/div[2]/div[2]
	//*[@id='lazyhome_Footer']//div[2]
	 @FindBy(xpath = "//*[@id='lazyhome_Footer']//div[2]")
     static WebElement footerLink;
	
    @FindBy(xpath = "//a[text()='Careers']")
     static WebElement careersLink;

    @FindBy(xpath = "//h4[text()='OPEN POSITIONS']")
    static WebElement openPositions;
    
    @FindBy(xpath = "//h4[text()='REASONS TO WORK WITH US']")
    static WebElement joinUs;

    @FindBy(xpath = "//a[text()='Internship - Research Analyst']")
    static WebElement internshipLink;
    
    @FindBy(xpath = "//h4[text()='Internship - Research Analyst                                ']")
    static WebElement internship;

    
    @FindBy(xpath="//h4[text()='Internship - Research Analyst                                ']")
    static WebElement jobFooter;
    
    @FindBy(xpath = "//h4[text()='Job Details']")
    static WebElement jobDetails;

    public CareersPage() {
        PageFactory.initElements(driver, this);
	 }
    
    

    public  void scrollToFooter() throws InterruptedException {
        //scrollToElement(footerLink);

try {
            scrollToElement(footerLink);
            Reports.generateReport(driver, Hooks.test, Status.PASS, "Scrolled to footer");
        } catch (Exception e) {
            Reports.generateReport(driver, Hooks.test, Status.FAIL, "Failed to scroll to footer");
            throw e;
        }

    }

    public  void clickCareersLink() throws InterruptedException {
        //clickElement(careersLink);

try {
            clickElement(careersLink);
            Reports.generateReport(driver, Hooks.test, Status.PASS, "Clicked Careers link");
        } catch (Exception e) {
            Reports.generateReport(driver, Hooks.test, Status.FAIL, "Failed to click Careers link");
            throw e;
        }

 
    }

    public  void verifyJoinUsPage() throws InterruptedException {
        
//       wait.until(ExpectedConditions.visibilityOf(joinUs));
//      Assert.assertTrue(joinUs.isDisplayed(),"Join Us Page is Displayed");


    	 try {
    	        wait.until(ExpectedConditions.visibilityOf(joinUs));
    	        Assert.assertTrue(joinUs.isDisplayed(), "Join Us Page is Displayed");
    	        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Join Us page verified successfully");
    	    } catch (Exception e) {
    	        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Join Us page verification failed");
    	        throw e;
    	    }


    	


   }

    public  void scrollToOpenPositions() throws InterruptedException {
        //scrollToElement(openPositions);

try {
            scrollToElement(openPositions);
            Reports.generateReport(driver, Hooks.test, Status.PASS, "Scrolled to Open Positions");
        } catch (Exception e) {
            Reports.generateReport(driver, Hooks.test, Status.FAIL, "Failed to scroll to Open Positions");
            throw e;
        }

    }

    public  void clickInternshipLink() throws InterruptedException {
       // clickElement(internshipLink);

try {
            clickElement(internshipLink);
            Reports.generateReport(driver, Hooks.test, Status.PASS, "Clicked Internship link");
        } catch (Exception e) {
            Reports.generateReport(driver, Hooks.test, Status.FAIL, "Failed to click Internship link");
            throw e;
        }

    }

    public  void switchToJobDescriptionTab() {
        //switchToNewTab();

try {
            switchToNewTab();
            Reports.generateReport(driver, Hooks.test, Status.PASS, "Switched to Job Description tab");
        } catch (Exception e) {
            Reports.generateReport(driver, Hooks.test, Status.FAIL, "Failed to switch tab");
            throw e;
        }

    }


    public void verifyJobDescriptionPage() throws InterruptedException {
//   wait.until(ExpectedConditions.visibilityOf(internship));
//      Assert.assertTrue(internship.isDisplayed(),"Internsip Page is Displayed");

try {
        wait.until(ExpectedConditions.visibilityOf(internship));
        Assert.assertTrue(internship.isDisplayed(), "Internship Page is Displayed");
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Internship page verified successfully");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Internship page verification failed");
        throw e;
    }



    }

    public void scrollToJobDetails() throws InterruptedException  {
        //scrollToElement(jobFooter);

try {
            scrollToElement(jobFooter);
            Reports.generateReport(driver, Hooks.test, Status.PASS, "Scrolled to Job Details section");
        } catch (Exception e) {
            Reports.generateReport(driver, Hooks.test, Status.FAIL, "Failed to scroll to Job Details section");
            throw e;
        }

          
    }
    
    public void verifyJobDetails() throws InterruptedException
    {
//    	wait.until(ExpectedConditions.visibilityOf(jobDetails));
//        Assert.assertTrue(jobDetails.isDisplayed(),"Job Details are not Displayed");
//        Thread.sleep(2000);

try {
            wait.until(ExpectedConditions.visibilityOf(jobDetails));
            Assert.assertTrue(jobDetails.isDisplayed(), "Job Details are not displayed");
            Reports.generateReport(driver, Hooks.test, Status.PASS, "Job details verified");
        } catch (Exception e) {
            Reports.generateReport(driver, Hooks.test, Status.FAIL, "Job details verification failed");
            throw e;
        }
Thread.sleep(2000);

    }
    
    
    
    
    
    //Test_Scenario_02
    
    @FindBy(xpath = "//a[text()='Blog']")
    static WebElement blog;
    
    @FindBy(xpath="(//a[contains(@href,'ebook')])[1]")
    static WebElement ebook;
    
    @FindBy(xpath="(//img[@alt='AWS-2-1-300x175.jpg'])[1]")
    static WebElement awsBook;
    
    @FindBy(xpath="(//h1)[1]")
    static WebElement verifyEbook;
    
    public  void clickBlog() throws InterruptedException {
        //clickElement(blog);

try {
        clickElement(blog);
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked Blog link");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click Blog link");
        throw e;
    }

        

    }
    
    public  void clickEbook() throws InterruptedException {
        //clickElement(ebook);

try {
        clickElement(ebook);
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked Ebook link");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click Ebook link");
        throw e;
    }

       

    }
    
    public  void clickAWSBook() throws InterruptedException {
        //clickElement(awsBook);

try {
        clickElement(awsBook);
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked AWS Book");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click AWS Book");
        throw e;
    }

       

    }
    
    public void verifyEbook() throws InterruptedException
    {
//    	    wait.until(ExpectedConditions.visibilityOf(verifyEbook));
//            Assert.assertTrue(verifyEbook.isDisplayed(),"Ebook Details are not displayed");
//            Thread.sleep(2000);

try {
        wait.until(ExpectedConditions.visibilityOf(verifyEbook));
        Assert.assertTrue(verifyEbook.isDisplayed(), "Ebook Details are not displayed");
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Verified Ebook page successfully");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Ebook page verification failed");
        throw e;
    }
//Thread.sleep(1000);
           
    }
    
    
    
    
    
    
    //Test_Scenario_03
    
    @FindBy(xpath = "//a[text()='Corporate Training'][1]")
    static WebElement corporateTraining;
    
    @FindBy(xpath="//button[text()='CONNECT WITH US']")
    static WebElement form;
    
    @FindBy(xpath="(//input[@name='first_name'])[3]")
    static WebElement name;
    
    @FindBy(xpath="(//input[@name='organization'])[3]")
    static WebElement companyName;
    
    @FindBy(xpath="(//*[@id=\"learnerCount\"])[3]")
    static WebElement trainingNeed;
    
    @FindBy(xpath="(//input[@name='email'])[3]")
    static WebElement email;
    
    @FindBy(xpath="(//input[@name='phone'])[3]")
    static WebElement phone;
    
    @FindBy(xpath="(//textarea[@name='query'])[3]")
    static WebElement query;
    
    @FindBy(xpath="//button[@id='corp-talk-modal-submit']")
    static WebElement submit;
    
    @FindBy(xpath="(//span[text()='Thank You!'])[3]")
    static WebElement thankYouForSubmission;

    
    public  void clickonCT() throws InterruptedException {

        //clickElement(corporateTraining);

try {
        clickElement(corporateTraining);
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked Corporate Training link");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click Corporate Training link");
        throw e;
    }

       

    }
    public  void clickonform() throws InterruptedException {
    	

    	//clickElement(form);

try {
        clickElement(form);
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked form button");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click form button");
        throw e;
    }


    }
    
    
    Map<String, String> formData;
    PropertyReader propertyreader=new PropertyReader();
    
    public void enterFormData(Integer sheet, Integer row) throws InterruptedException
    {
//    	String sheetName = "Sheet" + sheet; // Assuming sheet names are Sheet1, Sheet2
//        String rowStr = String.valueOf(row);
//
//        CareersPage careersPage = new CareersPage();
//		careersPage.enterName(sheetName, rowStr);
//        careersPage.enterCompanyName(sheetName, rowStr);
//        careersPage.enterTrainingNeed(sheetName, rowStr);
//        careersPage.enterEmail(sheetName, rowStr);
//        careersPage.enterPhone(sheetName, rowStr);
//        careersPage.enterQuery(sheetName, rowStr);
    	

try {
        String sheetName = "Sheet" + sheet;
        String rowStr = String.valueOf(row);

        enterName(sheetName, rowStr);
        enterCompanyName(sheetName, rowStr);
        enterTrainingNeed(sheetName, rowStr);
        enterEmail(sheetName, rowStr);
        enterPhone(sheetName, rowStr);
        enterQuery(sheetName, rowStr);

Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Entered form data from Excel successfully");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to enter form data");
        throw e;
    }

    }
    
    
    
    
    public void enterName(String sheet,String row)
    {
    	
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.elementToBeClickable(name));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", name);
//	    int rowNum = Integer.parseInt(row);
//	    formData = ExcelReader.getRowData(sheet, rowNum);
//	    String fieldName=propertyreader.getProperty("nameField");
//	    name.sendKeys(formData.get(fieldName));
    	

try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(name));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", name);

        int rowNum = Integer.parseInt(row);
        formData = ExcelReader.getRowData(sheet, rowNum);
        String fieldName = propertyreader.getProperty("nameField");
        name.sendKeys(formData.get(fieldName));

        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Entered Name: " + formData.get(fieldName));
    }
catch (Exception e) {
    Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to enter Name");
    throw e;
}


    }
    
    public void enterCompanyName(String sheet,String row) throws InterruptedException
    {
//    	wait.until(ExpectedConditions.visibilityOf(companyName));
//		   clickElement(companyName);
//		   //companyName.sendKeys(excelData.get(rowIndex)[1]);
//		   int rowNum = Integer.parseInt(row);
//		    formData = ExcelReader.getRowData(sheet, rowNum);
//		    String fieldCompanyName=propertyreader.getProperty("companyNameField");
//		   companyName.sendKeys(formData.get(fieldCompanyName));
    	

try {
        wait.until(ExpectedConditions.visibilityOf(companyName));
        clickElement(companyName);

        int rowNum = Integer.parseInt(row);
        formData = ExcelReader.getRowData(sheet, rowNum);
        String fieldCompanyName = propertyreader.getProperty("companyNameField");
        companyName.sendKeys(formData.get(fieldCompanyName));

        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Entered Company Name: " + formData.get(fieldCompanyName));

} catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to enter Company Name");
        throw e;
    }

    }
    
    public void enterTrainingNeed(String sheet,String row) throws InterruptedException
    {
//    	wait.until(ExpectedConditions.visibilityOf(trainingNeed));
//		   clickElement(trainingNeed);
//		   //trainingNeed.sendKeys(excelData.get(rowIndex)[2]);
//		   int rowNum = Integer.parseInt(row);
//		    formData = ExcelReader.getRowData(sheet, rowNum);
//		    String fieldTrainingNeed=propertyreader.getProperty("trainingNeedField");
//		   trainingNeed.sendKeys(formData.get(fieldTrainingNeed));
    	

try {
        wait.until(ExpectedConditions.visibilityOf(trainingNeed));
        clickElement(trainingNeed);

        int rowNum = Integer.parseInt(row);
        formData = ExcelReader.getRowData(sheet, rowNum);
        String fieldTrainingNeed = propertyreader.getProperty("trainingNeedField");
        trainingNeed.sendKeys(formData.get(fieldTrainingNeed));

        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Entered Training Need: " + formData.get(fieldTrainingNeed));
    } catch (Exception e) {

Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to enter Training Need");
        throw e;
    }

    }
    
    public void enterEmail(String sheet,String row) throws InterruptedException
    {
//    	 wait.until(ExpectedConditions.visibilityOf(email));
//		   clickElement(email);
//		   //email.sendKeys(excelData.get(rowIndex)[3]);
//		   int rowNum = Integer.parseInt(row);
//		    formData = ExcelReader.getRowData(sheet, rowNum);
//		    String fieldEmail=propertyreader.getProperty("emailField");
//		   email.sendKeys(formData.get(fieldEmail));
    	

    	 try {
    	        wait.until(ExpectedConditions.visibilityOf(email));
    	        clickElement(email);

    	        int rowNum = Integer.parseInt(row);
    	        formData = ExcelReader.getRowData(sheet, rowNum);
    	        String fieldEmail = propertyreader.getProperty("emailField");
    	        email.sendKeys(formData.get(fieldEmail));

    	        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Entered Email: " + formData.get(fieldEmail));
    	    }
    	 catch (Exception e) {
    	        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to enter Email");
    	        throw e;
    	    }


    }
    
    
    public void enterPhone(String sheet,String row) throws InterruptedException
    {
//    	wait.until(ExpectedConditions.visibilityOf(phone));
//		   clickElement(phone);
//		   int rowNum = Integer.parseInt(row);
//		    formData = ExcelReader.getRowData(sheet, rowNum);
//		    String fieldPhone=propertyreader.getProperty("phoneField");
//		    		
//		    long phoneNum = Long.parseLong(formData.get(fieldPhone));
//		   phone.sendKeys(String.valueOf(phoneNum));

try {
        wait.until(ExpectedConditions.visibilityOf(phone));
        clickElement(phone);

        int rowNum = Integer.parseInt(row);
        formData = ExcelReader.getRowData(sheet, rowNum);
        String fieldPhone = propertyreader.getProperty("phoneField");
        long phoneNum = Long.parseLong(formData.get(fieldPhone));
        phone.sendKeys(String.valueOf(phoneNum));

        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Entered Phone: " + phoneNum);
    }
catch (Exception e) {
    Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to enter Phone");
    throw e;
}


    }
    
    public void enterQuery(String sheet,String row) throws InterruptedException
    {
//    	wait.until(ExpectedConditions.visibilityOf(query));
//		   clickElement(query);
//		   //query.sendKeys(excelData.get(rowIndex)[5]);
//		   int rowNum = Integer.parseInt(row);
//		    formData = ExcelReader.getRowData(sheet, rowNum);
//		    String fieldQuery=propertyreader.getProperty("queryField");
//		   query.sendKeys(formData.get(fieldQuery));

try {
        wait.until(ExpectedConditions.visibilityOf(query));
        clickElement(query);

        int rowNum = Integer.parseInt(row);
        formData = ExcelReader.getRowData(sheet, rowNum);
        String fieldQuery = propertyreader.getProperty("queryField");
        query.sendKeys(formData.get(fieldQuery));

        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Entered Query: " + formData.get(fieldQuery));
    }
catch (Exception e) {
    Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to enter Query");
    throw e;
}


    }
    
    public void clickSubmit() throws InterruptedException
    {
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
//	    //wait.until(ExpectedConditions.visibilityOf(name));
//	    Thread.sleep(2000);
    	//clickElement(submit);

try {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
        Thread.sleep(2000);
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked Submit button");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click Submit button");
        throw e;
    }
Thread.sleep(2000);
	       
    }
    
    
    public void formSubmitted() throws InterruptedException
    {
    	
//    	wait.until(ExpectedConditions.visibilityOf(thankYouForSubmission));
//        Assert.assertTrue(thankYouForSubmission.isDisplayed(),"Form not Submitted,Please Enter Valid Data");
//        Thread.sleep(2000);


    	 try {
    	        wait.until(ExpectedConditions.visibilityOf(thankYouForSubmission));
    	        Assert.assertTrue(thankYouForSubmission.isDisplayed(), "Form not Submitted, Please Enter Valid Data");
    	        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Form submitted successfully");
    	    } catch (Exception e) {
    	        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Form submission verification failed");
    	        throw e;
    	    }
    	 Thread.sleep(2000);

    }
    
    
    
    
    //TS_04
    
    @FindBy(xpath="(.//div[@class='coursename'])[10]")
    static WebElement section;
    
    @FindBy(xpath=".//a[span[text()='Download Full Course List']]")
    static WebElement download;
    
     @FindBy(xpath=".//a[text()='Download Full Course List']")
     static WebElement submitDownload;
     
     @FindBy(xpath="(//span[text()='Thank You!'])[3]")
     static WebElement thankYouForDownload;
    
    public void scrollToDownload() throws InterruptedException
    {
    	//scrollToElement(section);

try {
        scrollToElement(section);
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Scrolled to Download section");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to scroll to Download section");
        throw e;
    }

    }
    
    public void clickDownload() throws InterruptedException
    {
//    	clickElement(download);

try {
        clickElement(download);
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked Download button");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click Download button");
        throw e;
    }

    }
    
    
    
    public void FillDownloadForm(Integer sheet, Integer row) throws InterruptedException
    {

//    	String sheetName = "Sheet" + sheet; // Assuming sheet names are Sheet1, Sheet2
//        String rowStr = String.valueOf(row);
//
//        CareersPage careersPage = new CareersPage();
//		careersPage.enterName(sheetName, rowStr);
//        careersPage.enterCompanyName(sheetName, rowStr);
//        careersPage.enterTrainingNeed(sheetName, rowStr);
//        careersPage.enterEmail(sheetName, rowStr);
//        careersPage.enterPhone(sheetName, rowStr);
    	

try {
        String sheetName = "Sheet" + sheet;
        String rowStr = String.valueOf(row);

        enterName(sheetName, rowStr);
        enterCompanyName(sheetName, rowStr);
        enterTrainingNeed(sheetName, rowStr);
        enterEmail(sheetName, rowStr);
        enterPhone(sheetName, rowStr);

        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Filled download form successfully");
    }
catch (Exception e) {
    Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to fill download form");
    throw e;
}


        

    }
    
    public void clickOnDownloadSubmit() throws InterruptedException
    {
//    	clickElement(submitDownload);

try {
        clickElement(submitDownload);
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked Submit for download form");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click Submit for download form");
        throw e;
    }

    }
    
    public void verifySuccessfulDownload() throws InterruptedException
    {

//		try {
//		        wait.until(ExpectedConditions.visibilityOf(thankYouForDownload));
//		        Assert.assertTrue(thankYouForDownload.isDisplayed(),"Download Unsuccessful, Please enter valid Data");
//		    } 
//		catch (Exception e) {
//		        Assert.fail("Download Unsuccessful, Please enter valid Data");
//		    }
//		Thread.sleep(2000);
    	

try {
        wait.until(ExpectedConditions.visibilityOf(thankYouForDownload));
        Assert.assertTrue(thankYouForDownload.isDisplayed(), "Download Unsuccessful, Please enter valid Data");
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Download verified successfully");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Download verification failed");
        throw e;
    }
Thread.sleep(2000);


    }
    
    
    //Test Scenario_05
    
    @FindBy(xpath = "(.//a[@href='https://www.edureka.co/blog/install-kubernetes-on-ubuntu'])[2]")
    static WebElement moreResources;
    
    @FindBy(xpath = ".//span[text()='211+ Videos']")
    static WebElement video;
    
    @FindBy(xpath = ".//h3[text()='Systems & Architecture']")
    static WebElement recentVideos;
    
    @FindBy(xpath = ".//i[@class='icon-Video_icon']")
    static WebElement devopsVideo;
    
    @FindBy(xpath = ".//span[text()='DevOps Engineer Masters Program '] ")
    static WebElement devopsVideoSeries;
    
    
    public void scrollToMoreResources() throws InterruptedException
    {
    	//scrollToElement(moreResources);

try {
        scrollToElement(moreResources);
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Scrolled to More Resources section");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to scroll to More Resources section");
        throw e;
    }

    }
    
    public void  clickOnVideo() throws InterruptedException
    {
//    	clickElement(video);

try {
        clickElement(video);
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked Video link");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click Video link");
        throw e;
    }

    }
    
    public void scrollToRecentVideos() throws InterruptedException
    {
//    	scrollToElement(recentVideos);

    	 try {
    	        scrollToElement(recentVideos);
    	        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Scrolled to Recently Added Videos");
    	    } catch (Exception e) {
    	        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to scroll to Recently Added Videos");
    	        throw e;
    	    }

    }
    
    public void clickOnDevopsVideo() throws InterruptedException
    {
//    	clickElement(devopsVideo);

try {
        clickElement(devopsVideo);
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked DevOps Video link");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click DevOps Video link");
        throw e;
    }

    }
    
    public void verifyDevopsVideoSeriesPage() throws InterruptedException
    {
    	
//       	try {
//	        wait.until(ExpectedConditions.visibilityOf(devopsVideoSeries));
//	        Assert.assertTrue(devopsVideoSeries.isDisplayed(),"Video Lectures Page is Not Displayed!!!!");
//	    } 
//       	catch (Exception e) {
//	        Assert.fail("Download Unsuccessful, Please enter valid Data");
//	    }
//       	

try {
        wait.until(ExpectedConditions.visibilityOf(devopsVideoSeries));
        Assert.assertTrue(devopsVideoSeries.isDisplayed(), "Video Lectures Page is Not Displayed!!!!");
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Verified DevOps Video Series page successfully");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "DevOps Video Series page verification failed");
        throw e;
    }

Thread.sleep(2000);

    }
    
    
    //TS_06   negative scenario
    
    
    @FindBy(xpath = "//*[@id=\"email-error\"]")
    static WebElement errormessage;
    
    
    public void verifyErrorMessage() throws InterruptedException {
        
    	try {
            wait.until(ExpectedConditions.visibilityOf(errormessage));
            Assert.assertTrue(errormessage.isDisplayed(), "Error message is Displayed!!!!");
            Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Verified Error message successfully");
        } catch (Exception e) {
            Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "submitting with Invalid Data is failed");
            throw e;
        }

    Thread.sleep(2000);
    	
    }
 
 }  
       
       
       
       
       
       
       
       
       
       
       

    
    
    
 