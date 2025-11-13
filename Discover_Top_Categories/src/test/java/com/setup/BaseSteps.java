package com.setup;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.parameters.PropertyReader;

import io.cucumber.java.After;

public class BaseSteps {
	//initialize WebDriver
	public  static WebDriver driver;
	//launch browser
	public static void launchBrowser(){
		Properties prop = PropertyReader.readProperty();
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("driverPath"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		else if (browser.equalsIgnoreCase("firefox"))    // firefox will launch
		{  
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("edge"))       //edge will launch
		{  
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid browser specified in config.properties");
			return;
		}
		String url = prop.getProperty("sourceUrl");
		driver.get(url);
		driver.manage().window().maximize();
	}

//    // Scroll to element with smooth animation and highlight
//    public static void scrollToElement(WebElement element) {
//    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    	    wait.until(ExpectedConditions.visibilityOf(element));
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        // Smooth scroll using JavaScript
//        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
//        // Highlight element for visibility
//        js.executeScript("arguments[0].style.border='3px solid red'", element);
//
//        System.out.println("Scrolled to element and highlighted it: " + element.getText());
//
//        // Highlight element for visibility
//        js.executeScript("arguments[0].style.border='3px solid red'", element);
//    }
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

	public static void sleep(int msec)                      //handling waits
	{    
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.");
        }
    }

//	public static void scrollToSection(String sectionName) {
//	    JavascriptExecutor js = (JavascriptExecutor) driver;
//	    WebElement sectionElement = driver.findElement(By.xpath("//h2[contains(text(),'" + sectionName + "')]"));
//	    js.executeScript("arguments[0].scrollIntoView(true);", sectionElement);
//	}
	
}
