package com.pages;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reports;

public class ViewMorePage {
	ExtentTest test;
    WebDriver driver;
    Properties prop;
    WebDriverWait wait;
    
    @FindBy(xpath="//*[@id=\"applyScholarshipForm\"]/div/div/div/div[2]/form/div[1]/input")
    private WebElement EnterName;
    @FindBy(xpath="//*[@id=\"applyScholarshipForm\"]/div/div/div/div[2]/form/div[2]/input")
    private WebElement EnterEmail;
    @FindBy(xpath="//*[@id=\"applyScholarshipForm\"]/div/div/div/div[2]/form/div[3]/input[2]")
    private WebElement EnterPhone;
    
    
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/div/div[1]/div/div/div/div[2]")
    WebElement viewMoreButton;

    @FindBy(xpath = "/html/body/section[5]/div/div/div[2]/button")
    WebElement sampleCertificateButton;
    
    private By getCertificateNowButton = By.xpath("//*[@id='applyScholarshipForm']/div/div/div/div[2]/form/button");

    @FindBy(xpath = "//*[@id=\"applyScholarshipForm\"]/div/div/div/div[3]/div/div/h4")
    WebElement thanksCardText;

    
    public ViewMorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        loadProperties();
    }

    private void loadProperties() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src\\test\\resources\\PropertiesFile\\trending_course.properties");
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initLocators() {
        viewMoreButton = driver.findElement(By.xpath(prop.getProperty("viewMoreButton")));
        sampleCertificateButton = driver.findElement(By.xpath(prop.getProperty("sampleCertificateButton")));
        getCertificateNowButton = (By) driver.findElement(By.xpath(prop.getProperty("getCertificateNowButton")));
        thanksCardText = driver.findElement(By.xpath(prop.getProperty("thanksCardText")));
    }
    
    public void clickViewMore() {
        By viewMoreLocator = By.xpath("//*[@id='__next']/div/div[3]/div/div[1]/div/div/div/div[2]/div[2]/span");
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement viewMoreBtn = driver.findElement(viewMoreLocator);
                viewMoreBtn.click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
            } catch (InvalidSelectorException e) {
                System.out.println("Invalid XPath selector: " + e.getMessage());
                break;
            }
        }
    }
    

   
    
    public void scrollToSection() {////*[@id="__next"]/div/div[3]/div/div[1]/div/div/div/div[2]
     
      WebElement section1 = wait.until(ExpectedConditions.visibilityOf(viewMoreButton));
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section1);
      driver.findElement(By.xpath("//div[@class=\\\"coursecards_firstdisplay__29Zw3\\\"]"));
      scrollToElement(viewMoreButton);
    }
    private void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    

    public boolean clickSampleCertificate() {
        sampleCertificateButton.click();
       return true;
    }
    
    
    public void clickSampleCertificate1() {
       
    	 WebElement section = wait.until(ExpectedConditions.visibilityOf(sampleCertificateButton));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sampleCertificateButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sampleCertificateButton);
        sampleCertificateButton.click();
    }


    public void fillScholarshipForm(String name, String email, String phone) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     
        wait.until(ExpectedConditions.elementToBeClickable(EnterName));
        EnterName.clear();
        EnterName.sendKeys(name);
     
        wait.until(ExpectedConditions.elementToBeClickable(EnterEmail));
        EnterEmail.clear();
        EnterEmail.sendKeys(email);
     
        wait.until(ExpectedConditions.elementToBeClickable(EnterPhone));
        EnterPhone.clear();
        EnterPhone.sendKeys(phone);
    }
    
    public void scrollToCertificate() {
   	 WebElement section = wait.until(ExpectedConditions.visibilityOf(sampleCertificateButton));
   	 try {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div/div/div/div[2]"));
        
        scrollToCertificateElement(sampleCertificateButton);
        Reports.generateReport(driver, test, Status.PASS, "Enrollment Form is Submitted ");
   	 }catch (Exception e) {
	        Reports.generateReport(driver, test, Status.FAIL, "Enrollement Form is not Submitted");
	}
        ///html/body/section[5]/div/div/div[2]/button
   }
   private void scrollToCertificateElement(WebElement element) {
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView(true);", element);
   }
    
    

	private void scrollIntoView(WebElement element) {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	
	
	public void clickGetCertificateNow() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    try {
	        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(getCertificateNowButton));
	        scrollIntoView(button);

	        if (button.isDisplayed() && button.isEnabled()) {
	            try {
	                wait.until(ExpectedConditions.elementToBeClickable(button));
	                button.click();
	            } catch (ElementNotInteractableException e) {
	                System.out.println("Standard click failed, using JS click");
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	            }
	        } else {
	            System.out.println("Button is not interactable: either hidden or disabled.");
	        }
	    } catch (TimeoutException e) {
	        System.out.println("Button not clickable after 20 seconds: " + e.getMessage());
	        throw e;
	    }
	}


    public String getThanksCardText() {
        return thanksCardText.getText();
    }
       

}