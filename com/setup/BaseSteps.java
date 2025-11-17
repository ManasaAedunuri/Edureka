



package com.setup;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
import com.parameters.PropertyReader;
public class BaseSteps {
    public static WebDriver driver;
    public static Properties prop; //  Global properties variable
    public static void initializeProperties(String filePath) {
    prop = PropertyReader.readProperty();
    }

    // Launch browser based on config
    public static void launchBrowser() {
        //prop = PropertyReader.readProperty(); // Initialize properties
        String browser = prop.getProperty("browserName");
        String url = prop.getProperty("sourceUrl");
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriverPath"));
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", prop.getProperty("edgedriverPath"));
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid browser specified in config.properties");
            return;
        }
        driver.get(url);
        driver.manage().window().maximize();
    }
public static void closeBrowser() throws InterruptedException {
	Thread.sleep(2000);
	driver.close();
}
    // Sleep utility
    public static void sleep(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}