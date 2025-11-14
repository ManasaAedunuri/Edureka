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

import com.parameters.ExcelReader;
import com.stepDefinitionTestNG.Hooks;


public class CareersPage extends BasePage{

	WebDriver driver = Hooks.driver;
//	List<String[]> excelData;
//    int rowIndex = 0;

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

//	if (excelData == null || excelData.isEmpty()) {
//	        String filePath = "src/test/resources/Exceldata/Data.xlsx";
//	        excelData = com.parameters.ExcelReader.readExcel(filePath);
//	        if (excelData.isEmpty()) {
//	            throw new RuntimeException("Excel data is empty! Check file path or sheet content.");
//	        }
//	    }

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
    
    
    
    //Test_Scenario_02
    
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
    
    
    
    
    
    
    //Test_Scenario_03
    
    @FindBy(xpath = "//a[text()='Corporate Training'][1]")
    static WebElement corporateTraining;
    
    @FindBy(xpath="//button[text()='CONNECT WITH US']")
    static WebElement form;
    
    @FindBy(xpath="(//*[@id=\"popup-query-form\"]/div/div[1]/input)[2]")
    static WebElement name;
    
    @FindBy(xpath="(//*[@id=\"popup-query-form\"]/div/div[2]/input)[2]")
    static WebElement companyName;
    
    @FindBy(xpath="(//*[@id=\"learnerCount\"])[3]")
    static WebElement trainingNeed;
    
    @FindBy(xpath="(//*[@id=\"popup-query-form\"]/div/div[4]/input)[2]")
    static WebElement email;
    
    @FindBy(xpath="(//*[@id=\"popup-query-form\"]/div/div[5]/div/input)[2]")
    static WebElement phone;
    
    @FindBy(xpath="(//*[@id=\"popup-query-form\"]/div/div[6]/textarea)[2]")
    static WebElement query;
    
    @FindBy(xpath="//*[@id=\"corp-talk-modal-submit\"]")
    static WebElement submit;

    
    public  void clickonCT() throws InterruptedException {
//    	if (excelData == null || excelData.isEmpty()) {
//	        String filePath = "src/test/resources/Exceldata/Data.xlsx";
//	        excelData = com.parameters.ExcelReader.readExcel(filePath);
//	    }
        clickElement(corporateTraining);
       // waitForElementVisible(careersLink);

    }
    public  void clickonform() throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", form);
	    wait.until(ExpectedConditions.visibilityOf(name));

    }
    
    
    Map<String, String> formData;
    
    public void enterFormData(Integer sheet, Integer row) throws InterruptedException
    {
    	String sheetName = "Sheet" + sheet; // Assuming sheet names are Sheet1, Sheet2
        String rowStr = String.valueOf(row);

        CareersPage careersPage = new CareersPage();
		careersPage.enterName(sheetName, rowStr);
        careersPage.enterCompanyName(sheetName, rowStr);
        careersPage.enterTrainingNeed(sheetName, rowStr);
        careersPage.enterEmail(sheetName, rowStr);
        careersPage.enterPhone(sheetName, rowStr);
        careersPage.enterQuery(sheetName, rowStr);
    }
    
    
    public void enterName(String sheet,String row)
    {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(name));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", name);
	    int rowNum = Integer.parseInt(row);
	    formData = ExcelReader.getRowData(sheet, rowNum);
	    //name.sendKeys(excelData.get(rowIndex)[0]);
	    name.sendKeys(formData.get("Name"));
    }
    
    public void enterCompanyName(String sheet,String row) throws InterruptedException
    {
    	wait.until(ExpectedConditions.visibilityOf(companyName));
		   clickElement(companyName);
		   //companyName.sendKeys(excelData.get(rowIndex)[1]);
		   int rowNum = Integer.parseInt(row);
		    formData = ExcelReader.getRowData(sheet, rowNum);
		   companyName.sendKeys(formData.get("CompanyName"));
    }
    
    public void enterTrainingNeed(String sheet,String row) throws InterruptedException
    {
    	wait.until(ExpectedConditions.visibilityOf(trainingNeed));
		   clickElement(trainingNeed);
		   //trainingNeed.sendKeys(excelData.get(rowIndex)[2]);
		   int rowNum = Integer.parseInt(row);
		    formData = ExcelReader.getRowData(sheet, rowNum);
		   trainingNeed.sendKeys(formData.get("TrainingNeed"));
    }
    
    public void enterEmail(String sheet,String row) throws InterruptedException
    {
    	 wait.until(ExpectedConditions.visibilityOf(email));
		   clickElement(email);
		   //email.sendKeys(excelData.get(rowIndex)[3]);
		   int rowNum = Integer.parseInt(row);
		    formData = ExcelReader.getRowData(sheet, rowNum);
		   email.sendKeys(formData.get("Email"));
    }
    
    
    public void enterPhone(String sheet,String row) throws InterruptedException
    {
    	wait.until(ExpectedConditions.visibilityOf(phone));
		   clickElement(phone);
		   long phoneNum = Long.parseLong(formData.get("Phone"));
		//phone.sendKeys(String.valueOf(phoneNum));
		   int rowNum = Integer.parseInt(row);
		    formData = ExcelReader.getRowData(sheet, rowNum);
		   phone.sendKeys(String.valueOf(phoneNum));
    }
    
    public void enterQuery(String sheet,String row) throws InterruptedException
    {
    	wait.until(ExpectedConditions.visibilityOf(query));
		   clickElement(query);
		   //query.sendKeys(excelData.get(rowIndex)[5]);
		   int rowNum = Integer.parseInt(row);
		    formData = ExcelReader.getRowData(sheet, rowNum);
		   query.sendKeys(formData.get("Query"));
    }
    
    public void clickSubmit() throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
	    wait.until(ExpectedConditions.visibilityOf(name));
    	//clickElement(submit);
	       
    }
    
    
    public void formSubmitted() throws InterruptedException
    {
    	assert driver.getPageSource().contains("Thank you");
    }
    
    
    
    
    //TS_04
    
    @FindBy(xpath="//*[@id=\"corpcat-14-artificial-intel\"]/div/div[10]")
    static WebElement section;
    
    @FindBy(xpath="//*[@id=\"b2bhead\"]/article[4]/div/div[3]/div/a/span")
    static WebElement download;
    
     @FindBy(xpath="//*[@id=\"popup-query-form\"]/div/div[7]/a")
     static WebElement submitDownload;
    
    public void scrollToDownload() throws InterruptedException
    {
    	scrollToElement(section);
    }
    
    public void clickDownload() throws InterruptedException
    {
    	clickElement(download);
    }
    
    
    
    public void FillDownloadForm(Integer sheet, Integer row) throws InterruptedException
    {

String sheetName = "Sheet" + sheet; // Assuming sheet names are Sheet1, Sheet2
        String rowStr = String.valueOf(row);

        CareersPage careersPage = new CareersPage();
		careersPage.enterName(sheetName, rowStr);
        careersPage.enterCompanyName(sheetName, rowStr);
        careersPage.enterTrainingNeed(sheetName, rowStr);
        careersPage.enterEmail(sheetName, rowStr);
        careersPage.enterPhone(sheetName, rowStr);
        //careersPage.enterQuery(sheetName, rowStr);

    }
    
    public void clickOnDownloadSubmit() throws InterruptedException
    {
    	clickElement(submitDownload);
    }
    
    
    //Test Scenario_05
    
    @FindBy(xpath = "/html/body/section[2]/div/div/div[9]")
    static WebElement moreResources;
    
    @FindBy(xpath = "/html/body/section[3]/div/div/div[2]/a/div/div[2]/span[1]")
    static WebElement video;
    
    @FindBy(xpath = "/html/body/section[1]/div/div/div[29]")
    static WebElement recentVideos;
    
    @FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div/div/a[2]/div/i")
    static WebElement devopsVideo;
    
    
    public void scrollToMoreResources() throws InterruptedException
    {
    	scrollToElement(moreResources);
    }
    
    public void  clickOnVideo() throws InterruptedException
    {
    	clickElement(video);
    }
    
    public void scrollToRecentVideos() throws InterruptedException
    {
    	scrollToElement(recentVideos);
    }
    
    public void clickOnDevopsVideo() throws InterruptedException
    {
    	clickElement(devopsVideo);
    }
    
    
    
    
    
    
    
    
    
 }  
       
       
       
       
       
       
       
       
       
       
       

    
    
    
 