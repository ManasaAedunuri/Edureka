package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.setup.BaseSteps;

public class CategoryPage extends BaseSteps {
	 // Scroll to element with smooth animation and highlight
    public static void scrollToElement(WebElement element) {
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    wait.until(ExpectedConditions.visibilityOf(element));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Smooth scroll using JavaScript
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        // Highlight element for visibility
        js.executeScript("arguments[0].style.border='3px solid red'", element);

        System.out.println("Scrolled to element and highlighted it: " + element.getText());

        // Highlight element for visibility
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }
    public static void safeClick(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                element.click();
                return;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException caught. Retrying...");
            }
            attempts++;
            sleep(1000); // small wait before retry
        }
        throw new RuntimeException("Failed to click on element after retries: " + locator.toString());
    }
    public boolean isCategoryPageLoaded(String expectedUrlPart) {
        String current_title = driver.getTitle();
        return current_title.contains(expectedUrlPart);
    }

}
