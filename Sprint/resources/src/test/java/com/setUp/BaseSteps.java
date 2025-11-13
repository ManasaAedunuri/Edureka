package com.setUp;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Parameters.PropertyReader;
 
public class BaseSteps {
 
	public static WebDriver driver;
	
    public static void launchBrowser()
    {
        Properties prop = PropertyReader.readProperty();
        String browser = prop.getProperty("browserName");
 
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Sprint\\resources\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("edge")) {
        	//System.setProperty("webdriver.edge.driver", "C:\\Training\\Java\\selenium_grid\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        else {
            System.out.println("Invalid browser specified in config.properties");
            
        }
        
        String url = prop.getProperty("homepage");
        
        driver.get(url);
        driver.manage().window().maximize();
    }
    
    public static void sleep(int msec)
    {
    	try {
    		Thread.sleep(msec);
    	}
    	catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    }
    
    public static void closeBrowser() throws InterruptedException {
    	Thread.sleep(3000);
    	driver.close();
    }
    
}