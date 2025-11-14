package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.util.Properties;

public class ViewMorePage {
    WebDriver driver;
    Properties prop;
    WebDriverWait wait;

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
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initLocators() {
        viewMoreButton = driver.findElement(By.xpath(prop.getProperty("viewMoreButton")));
        sampleCertificateButton = driver.findElement(By.xpath(prop.getProperty("sampleCertificateButton")));
        nameField = driver.findElement(By.xpath(prop.getProperty("nameField")));
        emailField = driver.findElement(By.xpath(prop.getProperty("emailField")));
        phoneField = driver.findElement(By.xpath(prop.getProperty("phoneField")));
        getCertificateNowButton = driver.findElement(By.xpath(prop.getProperty("getCertificateNowButton")));
        thanksCardText = driver.findElement(By.xpath(prop.getProperty("thanksCardText")));
    }
    
    
    
    
    public void enterName1(String name) {
        WebElement nameField = driver.findElement(By.xpath(prop.getProperty("//*[@id=\"applyScholarshipForm\"]/div/div/div/div[2]/form/div[1]/input")));
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void enterEmail1(String email) {
        WebElement emailField = driver.findElement(By.xpath(prop.getProperty("//*[@id=\"applyScholarshipForm\"]/div/div/div/div[2]/form/div[2]/input")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPhone1(String phone) {
        WebElement phoneField = driver.findElement(By.xpath(prop.getProperty("//*[@id=\"applyScholarshipForm\"]/div/div/div/div[2]/form/div[3]/input[2]")));
        phoneField.clear();
        phoneField.sendKeys(phone);
    }
    
    
    
    

    public boolean clickViewMore() {
        viewMoreButton.click();
        return true;
    }

    public boolean clickSampleCertificate() {
        sampleCertificateButton.click();
        return true;
    }

    public static void enterName(String name) {
        nameField.sendKeys(name);
    }

    public static void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public static void enterPhone(String phone) {
        phoneField.sendKeys(phone);
    }

    public boolean clickGetCertificateNow() {
        getCertificateNowButton.click();
        return true;
    }

    public String getThanksCardText() {
        return thanksCardText.getText();
    }
    public void scrollToSection() {////*[@id="__next"]/div/div[3]/div/div[1]/div/div/div/div[2]
//      WebElement section = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
//      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section);
//  	wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body"))); // ensure page is loaded
      WebElement section = wait.until(ExpectedConditions.visibilityOf(viewMoreButton));
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section);
      WebElement viewCourse=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div/div/div/div[2]"));
      scrollToElement(viewMoreButton);
    }
    private void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}