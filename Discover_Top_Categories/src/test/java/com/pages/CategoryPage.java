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
//    public static void safeClick(By locator) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        int attempts = 0;
//        while (attempts < 3) {
//            try {
//                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
//                element.click();
//                return;
//            } catch (org.openqa.selenium.StaleElementReferenceException e) {
//                System.out.println("StaleElementReferenceException caught. Retrying...");
//            }
//            attempts++;
//            sleep(1000); // small wait before retry
//        }
//        throw new RuntimeException("Failed to click on element after retries: " + locator.toString());
//    }
    public static void safeClick(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Increased timeout
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

                // Scroll into view before clicking
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);

                wait.until(ExpectedConditions.elementToBeClickable(locator));
                element.click();
                return;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException caught. Retrying...");
            } catch (Exception e) {
                System.out.println("Retrying click due to: " + e.getMessage());
            }
            attempts++;
            sleep(1000);
        }

        // Fallback: JavaScript click if normal click fails
        try {
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            System.out.println("Clicked using JavaScript as fallback.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to click on element after retries: " + locator.toString());
        }
    }
   
    public boolean isCategoryPageLoaded(String expectedUrlPart) {
        String current_title = driver.getTitle();
        return current_title.contains(expectedUrlPart);
    }
//    public boolean isCategoryPageLoaded2(String expectedText) {
//        return driver.getTitle().contains(expectedText);
//    }

}
//package com.pages;
//
//import java.time.Duration;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import com.setup.BaseSteps;
//
//public class CategoryPage extends BaseSteps {
//
//    // Existing scrollToElement method remains unchanged
//    public static void scrollToElement(WebElement element) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(element));
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
//        js.executeScript("arguments[0].style.border='3px solid red'", element);
//
//        System.out.println("Scrolled to element and highlighted it: " + element.getText());
//    }
//
//    // Existing safeClick method remains unchanged
//    public static void safeClick(By locator) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        int attempts = 0;
//        while (attempts < 3) {
//            try {
//                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
//                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//                element.click();
//                return;
//            } catch (org.openqa.selenium.ElementClickInterceptedException e) {
//                System.out.println("Click intercepted. Using JavaScript click as fallback...");
//                WebElement element = driver.findElement(locator);
//                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//                return;
//            } catch (org.openqa.selenium.StaleElementReferenceException e) {
//                System.out.println("StaleElementReferenceException caught. Retrying...");
//            }
//            attempts++;
//            BaseSteps.sleep(1000);
//        }
//        throw new RuntimeException("Failed to click on element after retries: " + locator.toString());
//    }
//
//    // ✅ New method: Safe click with text-based locator
//    public static void safeClickByText(String linkText) {
//        By locator = By.xpath("//a[contains(text(),'" + linkText + "')]");
//        safeClick(locator);
//    }
//
//    // ✅ New method: Wait for page title to contain expected text
//    public static boolean waitForPageTitle(String expectedTitlePart, int timeoutSeconds) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
//        return wait.until(ExpectedConditions.titleContains(expectedTitlePart));
//    }
//
//    // ✅ New method: Validate element presence
//    public static boolean isElementPresent(By locator) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    // Existing method remains unchanged
//    public boolean isCategoryPageLoaded(String expectedUrlPart) {
//        String current_title = driver.getTitle();
//        return current_title.contains(expectedUrlPart);
//    }
//
//    // Existing Generative AI click method remains unchanged
//    public void clickGenerativeAIProgram() {
//        By generativeAILink = By.xpath("//a[@href='https://www.edureka.co/masters-program/generative-ai-prompt-engineering-training']");
//        safeClick(generativeAILink);
//        System.out.println("Clicked on Generative AI Program link successfully.");
//    }
//}
////package com.pages;
////
////import java.time.Duration;
////
////import org.openqa.selenium.By;
////import org.openqa.selenium.JavascriptExecutor;
////import org.openqa.selenium.WebElement;
////import org.openqa.selenium.support.ui.ExpectedConditions;
////import org.openqa.selenium.support.ui.WebDriverWait;
////
////import com.setup.BaseSteps;
////
////public class CategoryPage extends BaseSteps {
////	 // Scroll to element with smooth animation and highlight
//////    public static void scrollToElement(WebElement element) {
//////    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//////    	    wait.until(ExpectedConditions.visibilityOf(element));
////
//////        JavascriptExecutor js = (JavascriptExecutor) driver;
//////
//////        // Smooth scroll using JavaScript
//////        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
//////        // Highlight element for visibility
//////        js.executeScript("arguments[0].style.border='3px solid red'", element);
//////
//////        System.out.println("Scrolled to element and highlighted it: " + element.getText());
//////
//////        // Highlight element for visibility
//////        js.executeScript("arguments[0].style.border='3px solid red'", element);
////    	    JavascriptExecutor js = (JavascriptExecutor) driver;
////
////    	 // Smooth scroll and center alignment
//////    	 js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
//////
//////    	 // Highlight element for visibility
//////    	 js.executeScript("arguments[0].style.border='3px solid red'", element);
//////
//////    	 System.out.println("Scrolled to element and highlighted it: " + element.getText());
//////        
//////    }
////    	    public static void scrollToElement(WebElement element) {
////        	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////        	    wait.until(ExpectedConditions.visibilityOf(element));
////     
////            JavascriptExecutor js = (JavascriptExecutor) driver;
////     
////            // Smooth scroll using JavaScript
////            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
////            // Highlight element for visibility
////            js.executeScript("arguments[0].style.border='3px solid red'", element);
////     
////            System.out.println("Scrolled to element and highlighted it: " + element.getText());
////     
////            // Highlight element for visibility
////            js.executeScript("arguments[0].style.border='3px solid red'", element);
////        }
//////    public static void safeClick(By locator) {
//////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//////        int attempts = 0;
//////        while (attempts < 3) {
//////            try {
//////                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
//////                element.click();
//////                return;
//////            } catch (org.openqa.selenium.StaleElementReferenceException e) {
//////                System.out.println("StaleElementReferenceException caught. Retrying...");
//////            }
//////            attempts++;
//////            sleep(1000); // small wait before retry
//////        }
//////        throw new RuntimeException("Failed to click on element after retries: " + locator.toString());
//////    }
////    public static void safeClick(By locator) {
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////        int attempts = 0;
////        while (attempts < 3) {
////            try {
////                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
////                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
////                element.click();
////                return;
////            } catch (org.openqa.selenium.ElementClickInterceptedException e) {
////                System.out.println("Click intercepted. Using JavaScript click as fallback...");
////                WebElement element = driver.findElement(locator);
////                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
////                return;
////            } catch (org.openqa.selenium.StaleElementReferenceException e) {
////                System.out.println("StaleElementReferenceException caught. Retrying...");
////            }
////            attempts++;
////            BaseSteps.sleep(1000);
////        }
////        throw new RuntimeException("Failed to click on element after retries: " + locator.toString());
////    }
////    public boolean isCategoryPageLoaded(String expectedUrlPart) {
////        String current_title = driver.getTitle();
////        return current_title.contains(expectedUrlPart);
////    }
//// // Click on Generative AI Program link using given XPath
////    public void clickGenerativeAIProgram() {
////        By generativeAILink = By.xpath("//a[@href='https://www.edureka.co/masters-program/generative-ai-prompt-engineering-training']");
////        safeClick(generativeAILink);
////        System.out.println("Clicked on Generative AI Program link successfully.");
////    }
////
////}
