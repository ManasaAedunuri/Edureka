package com.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.setup.BaseSteps;
import com.setup.Reports;
import com.stepDefinitionTestNG.Hooks;

public class BasePage {

	
	protected WebDriver driver = BaseSteps.driver;
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void scrollToElement(WebElement element) throws InterruptedException {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//        Thread.sleep(1000);
    	

try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(1000);
            Reports.generateReport(driver, Hooks.test, Status.PASS, "Scrolled to element: " + element.toString());
        } catch (Exception e) {
            Reports.generateReport(driver, Hooks.test, Status.FAIL, "Failed to scroll to element: " + element.toString());
            throw new RuntimeException(e);
        }

    }

//    public void waitForTitleContains(String titleFragment) {
//        wait.until(ExpectedConditions.titleContains(titleFragment));
//    }

	
	public void switchToNewTab() {
//        for (String handle : driver.getWindowHandles()) {
//            driver.switchTo().window(handle);
//        }

try {
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            Reports.generateReport(driver, Hooks.test, Status.PASS, "Switched to new tab");
        } catch (Exception e) {
            Reports.generateReport(driver, Hooks.test, Status.FAIL, "Failed to switch to new tab");
            throw new RuntimeException(e);
        }

    }

    public void clickElement(WebElement element) throws InterruptedException {
    	   
//    	Thread.sleep(2000);
//    	element.click();

try {
            Thread.sleep(2000);
            element.click();
            Reports.generateReport(driver, Hooks.test, Status.PASS, "Clicked element: " + element.toString());
        } catch (Exception e) {
            Reports.generateReport(driver, Hooks.test, Status.FAIL, "Failed to click element: " + element.toString());
            throw new RuntimeException(e);
        }

    	
    }
   

//    public void sendKeys(WebElement element, String value) {
//        element.clear();
//        element.sendKeys(value);
//    }
//
//    public void selectDropdownByVisibleText(WebElement dropdown, String text) {
//        new Select(dropdown).selectByVisibleText(text);
//    }
//
//    public void waitForElementVisible(WebElement element) {
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }

}