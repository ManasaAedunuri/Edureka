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

public class ViewMorePage {
    WebDriver driver;
    Properties prop;
    WebDriverWait wait;
    
    @FindBy(xpath="//*[@id=\"applyScholarshipForm\"]/div/div/div/div[2]/form/div[1]/input")
    private WebElement EnterName;
    @FindBy(xpath="//*[@id=\"applyScholarshipForm\"]/div/div/div/div[2]/form/div[2]/input")
    private WebElement EnterEmail;
    @FindBy(xpath="//*[@id=\"applyScholarshipForm\"]/div/div/div/div[2]/form/div[3]/input[2]")
    private WebElement EnterPhone;
    
    
    
    
//    private By nameLocator = By.xpath("//*[@id='applyScholarshipForm']/div/div/div/div[2]/form/div[1]/input");
//    private By emailLocator = By.xpath("//*[@id='applyScholarshipForm']/div/div/div/div[2]/form/div[2]/input");
//    private By phoneLocator = By.xpath("//*[@id='applyScholarshipForm']/div/div/div/div[2]/form/div[3]/input[2]");

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/div/div[1]/div/div/div/div[2]")
    WebElement viewMoreButton;

    @FindBy(xpath = "/html/body/section[5]/div/div/div[2]/button")
    WebElement sampleCertificateButton;

//    @FindBy(xpath = "//*[@id=\"applyScholarshipForm\"]/div/div/div/div[2]/form/div[1]/input")
//	private WebElement nameField;
//
//    @FindBy(xpath = "//*[@id=\"applyScholarshipForm\"]/div/div/div/div[2]/form/div[2]/input")
//	static WebElement emailField;
//
//    @FindBy(xpath = "//*[@id=\"applyScholarshipForm\"]/div/div/div/div[2]/form/div[3]/input[2]")
//	static WebElement phoneField;

    /*@FindBy(xpath = "//*[@id=\"applyScholarshipForm\"]/div/div/div/div[2]/form/button")
    WebElement getCertificateNowButton;*/
    
    private By getCertificateNowButton = By.xpath("//*[@id='applyScholarshipForm']/div/div/div/div[2]/form/button");

    @FindBy(xpath = "//*[@id=\"applyScholarshipForm\"]/div/div/div/div[3]/div/div/h4")
    WebElement thanksCardText;

//    public ViewMorePage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//        loadProperties();
//        initLocators();
//    }
    
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
//        nameLocator = driver.findElement(By.xpath(prop.getProperty("nameField")));
//        emailLocator = driver.findElement(By.xpath(prop.getProperty("emailField")));
//        phoneLocator = driver.findElement(By.xpath(prop.getProperty("phoneField")));
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
    
   
//    public void clickViewMore() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement viewMoreButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"__next\\\"]/div/div[3]/div/div[1]/div/div/div/div[2]/div[2]/span")));
//        viewMoreButton.click();
//    }
    
//    public void clickViewMore() {
//        By viewMoreLocator = By.xpath("//*[@id='__next']/div/div[3]/div/div[1]/div/div/div/div[2]/div[2]/span");
//        int attempts = 0;
//        while (attempts < 3) {
//            try {
//                WebElement viewMoreBtn = driver.findElement(viewMoreLocator);
//                viewMoreBtn.click();
//                break;
//            } catch (StaleElementReferenceException e) {
//                attempts++;
//            }
//        }
//    }
//    
//    

   
    
    public void scrollToSection() {////*[@id="__next"]/div/div[3]/div/div[1]/div/div/div/div[2]
     // WebElement section = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
     // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section);
  	//wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body"))); // ensure page is loaded
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
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // wait.until(ExpectedConditions.visibilityOf(sampleCertificateButton));
       //wait.until(ExpectedConditions.elementToBeClickable(sampleCertificateButton));
    	 WebElement section = wait.until(ExpectedConditions.visibilityOf(sampleCertificateButton));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sampleCertificateButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sampleCertificateButton);
        sampleCertificateButton.click();
    }

//    public boolean isEnrollmentFormVisible() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//       return wait.until(ExpectedConditions.elementToBeClickable(emailLocator)).isDisplayed();
//       
//   }

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
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div/div/div/div[2]"));
        scrollToCertificateElement(sampleCertificateButton);
        ///html/body/section[5]/div/div/div[2]/button
   }
   private void scrollToCertificateElement(WebElement element) {
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView(true);", element);
   }
    
    
   /*public void enterUserDetails(String name, String email, String phone) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//
//	    By nameLocator = By.xpath("//*[@id=\\\"applyScholarshipForm\\\"]/div/div/div/div[2]/form/div[1]/input");
//	    By emailLocator = By.xpath("//*[@id=\\\"applyScholarshipForm\\\"]/div/div/div/div[2]/form/div[2]/input");
//	    By phoneLocator = By.xpath("///*[@id=\\\"applyScholarshipForm\\\"]/div/div/div/div[2]/form/div[3]/input[2]");

	  wait.until(ExpectedConditions.elementToBeClickable(nameField));
	    scrollIntoView(nameField);
	   // nameField.clear();
	    nameField.sendKeys(name);
	    
	    
	     wait.until(ExpectedConditions.elementToBeClickable(emailField));
	    scrollIntoView(emailField);
	   // emailField.clear();
	    emailField.sendKeys(email);
	    
	   wait.until(ExpectedConditions.elementToBeClickable(phoneField));
	    scrollIntoView(phoneField);
	   // phoneField.clear();
	    phoneField.sendKeys(phone);

	    

	    

	    
	}*/
   
   
//   public void enterUserDetails(String name, String email, String phone) {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(nameLocator));
//	    scrollIntoView(nameField);
//	    nameField.sendKeys(name);
//
//	    WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(emailLocator));
//	    scrollIntoView(emailField);
//	    emailField.sendKeys(email);
//
//	    WebElement phoneField = wait.until(ExpectedConditions.elementToBeClickable(phoneLocator));
//	    scrollIntoView(phoneField);
//	    phoneField.sendKeys(phone);
//	}

	private void scrollIntoView(WebElement element) {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

//    public static String enterName(String name) {
//        nameField.sendKeys(name);
//        nameField.sendKeys(Keys.ENTER);
//        return name;
//    }
//
//    public static String enterEmail(String email) { 
//        emailField.sendKeys(email);
//        emailField.sendKeys(Keys.ENTER);
//		return email;
//    }
//
//    public static String enterPhone(String phone) {
//        phoneField.sendKeys(phone);
//        phoneField.sendKeys(Keys.ENTER);
//		return phone;
//    }
	
	/*public void clickGetCertificateNow() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(getCertificateNowButton));
	    scrollIntoView(button);
	    try {
	        button.click();
	    } catch (ElementNotInteractableException e) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	    }
	}*/
	
	
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
//
//    public boolean clickGetCertificateNow() {
//        getCertificateNowButton.click();
//        return true;
//    }

    public String getThanksCardText() {
        return thanksCardText.getText();
    }


/*public class ViewMorePage {
    WebDriver driver;
    WebDriverWait wait;
    Properties prop;
    
    
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/div/div[1]/div/div/div/div[2]")
    WebElement viewMoreButton;

    @FindBy(xpath = "/html/body/section[5]/div/div/div[2]/button")
    WebElement sampleCertificateButton;

    @FindBy(xpath = "//*[@id=\"applyScholarshipForm\"]/div/div/div/div[2]/form/div[1]/input")
	static WebElement nameField;

    @FindBy(xpath = "//*[@id=\"applyScholarshipForm\"]/div/div/div/div[2]/form/div[2]/input")
	static WebElement emailField;

    @FindBy(xpath = "//*[@id=\"applyScholarshipForm\"]/div/div/div/div[2]/form/div[3]/input[2]")
	static WebElement phoneField;

    @FindBy(xpath = "//*[@id=\"applyScholarshipForm\"]/div/div/div/div[2]/form/button")
    WebElement getCertificateNowButton;

    @FindBy(xpath = "//*[@id=\"applyScholarshipForm\"]/div/div/div/div[3]/div/div/h4")
    WebElement thanksCardText;

    public ViewMorePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public void clickViewMore() {
        By viewMoreLocator = By.xpath("//*[@id='__next']/div/div[3]/div/div[1]/div/div/div/div[2]/div[2]/span");
        WebElement viewMoreBtn = wait.until(ExpectedConditions.elementToBeClickable(viewMoreLocator));
        scrollIntoView(viewMoreBtn);
        viewMoreBtn.click();
    }

    public void clickSampleCertificate1() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(sampleCertificateButton));
        scrollIntoView(button);
        button.click();
    }

    public void enterUserDetails(String name, String email, String phone) {
        By nameLocator = By.xpath("//*[@id='applyScholarshipForm']/div/div/div/div[2]/form/div[1]/input");
        By emailLocator = By.xpath("//*[@id='applyScholarshipForm']/div/div/div/div[2]/form/div[2]/input");
        By phoneLocator = By.xpath("//*[@id='applyScholarshipForm']/div/div/div/div[2]/form/div[3]/input[2]");

        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(nameLocator));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(emailLocator));
        WebElement phoneField = wait.until(ExpectedConditions.elementToBeClickable(phoneLocator));

        scrollAndType(nameField, name);
        scrollAndType(emailField, email);
        scrollAndType(phoneField, phone);
    }

    private void scrollAndType(WebElement element, String value) {
        scrollIntoView(element);
        element.clear();
        element.sendKeys(value);
    }

    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public boolean clickGetCertificateNow() {
        getCertificateNowButton.click();
        return true;
    }

    public String getThanksCardText() {
        return thanksCardText.getText();
    }
    
    public void scrollToSection() {  ////*[@id="__next"]/div/div[3]/div/div[1]/div/div/div/div[2]
        // WebElement section = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section);
     	//wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body"))); // ensure page is loaded
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
       }*/
       

}