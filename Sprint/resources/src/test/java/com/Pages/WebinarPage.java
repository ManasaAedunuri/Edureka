package com.Pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setUp.BaseSteps;
import com.setUp.Reports;

public class WebinarPage extends BaseSteps {
//	 static ExtentTest test;
//    public WebinarPage(WebDriver driver) {
//        WebinarPage.driver = driver;
//        this.test=test;
//        PageFactory.initElements(driver, this);
//    }
	 WebDriver driver;
	    ExtentTest test;

	    public WebinarPage(WebDriver driver, ExtentTest test) {
	        this.driver = driver;
	        this.test = test;
	        PageFactory.initElements(driver, this);
	    }
	

   

    
    @FindBy(xpath = "//*[@id=\"__next\"]/div/nav/div[4]/div[2]/button")
    WebElement resourcesMenu;

    @FindBy(xpath="//*[@id=\"__next\"]/div/nav/div[4]/div[2]/div/a[2]")//(linkText = "Webinars")
    WebElement webinarsSubMenu;

    // Search bar
    @FindBy(xpath="//*[@id=\"webinar_search_input\"]") 
    WebElement searchBar;
    
    @FindBy(xpath="//span[text()='RESERVE YOUR SPOT NOW']")
    WebElement confirm;

    // Webinar title (dynamic locator used in method)
    // Register button (dynamic locator used in method)
    // Confirmation section (dynamic locator used in method)

    // Actions
    public void clickMenu() {
        resourcesMenu.click();
    }

    public void clickSubMenu() {
        webinarsSubMenu.click();
    }

    public boolean searchKeyword(String keyword) {
    	boolean actresult=true;
    	try {
        searchBar.clear();
        searchBar.sendKeys(keyword);
        searchBar.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      String suggestionXPath = "//*[@id=\"webinar_search_form\"]/div/div[2]/ul/li[3]/a/a";
       WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(suggestionXPath)));
        suggestion.click();
        Reports.generateReport(driver, test, Status.PASS, "Selected suggestion from dropdown.");
    	}catch(Exception e) {
    		actresult=false;
    		Reports.generateReport(driver, test, Status.FAIL, "Failed to select suggestion: " + e.getMessage());
    	}
    	return actresult;
//        //String suggestionXPath = "//*[@id='webinar_search_form']//ul//li//a[contains(text(),'" + keyword + "')]";
//        try {
//            WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(suggestionXPath)));
//
//            // Optional: verify text match
//            if (suggestion.getText().equalsIgnoreCase(keyword)) {
//                suggestion.click();
//            } else {
//                System.out.println("Suggestion text mismatch: " + suggestion.getText());
//            }
//
//        } catch (TimeoutException e) {
//            System.out.println("Suggestion not found for keyword: " + keyword);
//        }


        
    }

  

  public void clickRegister(String  buttonText) {
//        WebElement buttonText = driver.findElement(
//            org.openqa.selenium.By.xpath("//*[@id=\"webinar_main_5\"]/div[1]/a/div/div[2]/span/button"));
//        scrollToElement(buttonText);
//        buttonText.click();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Wait for loader to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("wl_loader")));

        // Locate the register button
        WebElement registerButton = driver.findElement(
            By.xpath("//button[contains(text(),'" + buttonText + "')]"));

        scrollToElement(registerButton);

        // Wait until it's clickable
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));

        try {
            registerButton.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click intercepted, using JavaScript fallback");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", registerButton);
        }

    }

    public boolean isConfirmationVisible(String confirmationText) {
//        WebElement confirmationSection = driver.findElement(
//            org.openqa.selenium.By.xpath("//*[contains(text(),'" + confirmationText + "')]"));
//        scrollToElement(confirmationSection);
//        return confirmationSection.isDisplayed();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(confirm));
       return wait.until(ExpectedConditions.visibilityOf(confirm)).isDisplayed();
    }
   

    private void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}