package com.setup;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.parameters.PropertyReader;

public class BaseSteps {

    public static WebDriver driver;
    public static Properties prop;

    public static void launchBrowser() {
        try {
            prop = PropertyReader.readProperty();
            String browser = prop.getProperty("browserName");
            String url = prop.getProperty("sourceUrl");

            if (browser == null || url == null) {
                throw new RuntimeException("Missing browserName or sourceUrl in config.properties");
            }

            switch (browser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\murvyshn\\OneDrive - Capgemini\\Desktop\\SeleniumGrid\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    break;

                case "edge":
                    System.setProperty("webdriver.edge.driver", "C:\\Users\\murvyshn\\OneDrive - Capgemini\\Desktop\\SeleniumGrid\\msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;

                default:
                    throw new RuntimeException("Invalid browser specified in config.properties: " + browser);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get(url);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to launch browser: " + e.getMessage());
        }
    }

    public static void sleep(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}