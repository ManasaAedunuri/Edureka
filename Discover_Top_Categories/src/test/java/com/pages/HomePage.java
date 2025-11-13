package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.setup.BaseSteps;

public class HomePage extends BaseSteps {

    @FindBy(xpath = "//h2[text()='Discover Top Categories']")
    private WebElement discoverTopCategoriesSection;

    public HomePage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }
    public static void scrollToSection(String sectionName) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement sectionElement = driver.findElement(By.xpath("//h2[contains(text(),'" + sectionName + "')]"));
	    js.executeScript("arguments[0].scrollIntoView(true);", sectionElement);
	}
    public void scrollToDiscoverTopCategories() {
        CategoryPage.scrollToElement(discoverTopCategoriesSection); // from BasePage
    }

    public void clickCategory(String categoryName) {
        CategoryPage.safeClick(By.xpath("//a[label[text()='" + categoryName + "']]"));
    }
//    public void clickCategory2(String categoryName) {
//    	    CategoryPage.safeClick(By.xpath("//a[label[text()='" + categoryName + "']]"));
//    }
    public void clickViewMoreButton() {
        CategoryPage.safeClick(By.xpath("//span[contains(@class,'topcategories_view_more_button')]"));
    }
    public void clickSoftwareTestingCategory() {
        CategoryPage.safeClick(By.xpath("//a[text()='Software Testing']"));
    }

    public void clickSeleniumCourseByText() {
        CategoryPage.safeClick(By.xpath("//a[contains(text(),'Selenium Certification Training')]"));
    }

    public void clickSeleniumCourseByHref() {
        CategoryPage.safeClick(By.cssSelector("div.course-list a.clp-course-tile-link"));
    }
 // Add this inside HomePage class
    public boolean getLocalityName(String locality) {
        try {
            WebElement localityInput = driver.findElement(By.id("searchLocality")); // Adjust locator if needed
            localityInput.clear();
            localityInput.sendKeys(locality);
            return true; // Successfully entered locality
        } catch (Exception e) {
            System.out.println("Error entering locality: " + e.getMessage());
            return false; // Failed to enter locality
        }
    }
    public boolean isBuyTabVisible() {
        try {
            WebElement buyTab = driver.findElement(By.xpath("//a[text()='BUY']")); // Adjust locator if needed
            return buyTab.isDisplayed();
        } catch (Exception e) {
            System.out.println("BUY tab not found: " + e.getMessage());
            return false;
        }
    }
 // ✅ Add this inside HomePage class (below existing methods)

 // Click category dynamically using text
    public void clickDynamicCategory(String categoryName) {
    	CategoryPage.safeClick(By.xpath("//a[contains(text(),'" + categoryName + "')]"));
    }
    public void clickDynamicCategory2(String categoryName) {
        By categoryLocator = By.xpath("//a[@data-category='" + categoryName + "']");
        CategoryPage.safeClick(categoryLocator);
    }

    // Validate if page title contains expected text
    public boolean isPageLoaded(String expectedText) {
    	return driver.getTitle().contains(expectedText);
    }
    public void clickPGPGenerativeAI() {
        By pgpGenerativeAILink = By.xpath("(//a[contains(@href,'pgp-generative-ai-machine-learning-certification')])[3]");
        CategoryPage.safeClick(pgpGenerativeAILink);
    }
    public void enterName(String name) {
        if (name != null && !name.isEmpty()) {
            driver.findElement(By.xpath("(//input[@name='name'])[2]")).sendKeys(name); // Replace with actual locator
        } else {
            System.out.println("Name is empty or null, skipping input.");
        }
    }

    public void enterEmail(String email) {
        if (email != null && !email.isEmpty()) {
            driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(email); // Replace with actual locator
        } else {
            System.out.println("Email is empty or null, skipping input.");
        }
    }

    public void enterPhone(String phone) {
        if (phone != null && !phone.isEmpty()) {
            driver.findElement(By.xpath("(//input[@name='phone_no'])[2]")).sendKeys(phone); // Replace with actual locator
        } else {
            System.out.println("Phone is empty or null, skipping input.");
        }
    }

    // Check if relevant courses are displayed
//    @Override
//    public boolean areRelevantCoursesDisplayed() {
//    	try {
//    		return driver.findElements(By.xpath("//div[contains(@class,'course-card')]")).size() > 0;
//    	} catch (Exception e) {
//    		System.out.println("Error checking courses: " + e.getMessage());
//    		return false;
//    	}
//    }

    
}

//package com.pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import com.setup.BaseSteps;
//
//public class HomePage extends BaseSteps {
//
//    // ✅ Page Factory element for Discover Top Categories section
//    @FindBy(xpath = "//h2[text()='Discover Top Categories']")
//    private WebElement discoverTopCategoriesSection;
//
//    // ✅ Constructor initializes Page Factory
//    public HomePage(WebDriver driver) {
//        super();
//        PageFactory.initElements(driver, this);
//    }
//
//    // ✅ Scroll to Discover Top Categories section using BaseSteps
//    public void scrollToDiscoverTopCategories() {
//        scrollToSection("Discover Top Categories"); // Using BaseSteps method
//    }
//
//    // ✅ Click category dynamically using XPath
//    public void clickCategory(String categoryName) {
//        WebElement categoryElement = driver.findElement(By.xpath("//a[label[text()='" + categoryName + "']]"));
//        categoryElement.click();
//    }
//
//    // ✅ Click View More button using Page Factory or dynamic locator
//    public void clickViewMoreButton() {
//        WebElement viewMoreButton = driver.findElement(By.xpath("//span[contains(@class,'topcategories_view_more_button')]"));
//        viewMoreButton.click();
//    }
//
//    public void clickSoftwareTestingCategory() {
//        WebElement softwareTestingCategory = driver.findElement(By.xpath("//a[text()='Software Testing']"));
//        softwareTestingCategory.click();
//    }
//
//    public void clickSeleniumCourseByText() {
//        WebElement seleniumCourse = driver.findElement(By.xpath("//a[contains(text(),'Selenium Certification Training')]"));
//        seleniumCourse.click();
//    }
//
//    public void clickSeleniumCourseByHref() {
//        WebElement seleniumCourseHref = driver.findElement(By.cssSelector("div.course-list a.clp-course-tile-link"));
//        seleniumCourseHref.click();
//    }
//}
//package com.pages;
//
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import com.setup.BaseSteps;
//
//public class HomePage extends BaseSteps {
//
//    @FindBy(xpath = "//h2[text()='Discover Top Categories']")
//    private WebElement discoverTopCategoriesSection;
//
//    public HomePage(WebDriver driver) {
//        super();
//        PageFactory.initElements(driver, this);
//    }
////    public static void scrollToSection(String sectionName) {
////	    JavascriptExecutor js = (JavascriptExecutor) driver;
////	    WebElement sectionElement = driver.findElement(By.xpath("//h2[contains(text(),'" + sectionName + "')]"));
////	    js.executeScript("arguments[0].scrollIntoView(true);", sectionElement);
////	}
////    public static void scrollToSection(String sectionName) {
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////        WebElement sectionElement = driver.findElement(By.xpath("//h2[contains(text(),'" + sectionName + "')]"));
////
////        // Smooth scroll and center alignment
////        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", sectionElement);
////
////        // Optional: Highlight for debugging
////        js.executeScript("arguments[0].style.border='3px solid red'", sectionElement);
////        System.out.println("Scrolled to section: " + sectionName);
////    }
//    
//    public void scrollToDiscoverTopCategories() {
//        CategoryPage.scrollToElement(discoverTopCategoriesSection); // from BasePage
//    }
////    public void scrollToDiscoverTopCategories() {
////        js.executeScript("arguments[0].scrollIntoView(true);", discoverTopCategoriesSection);
////    }
//    public void clickCategory(String categoryName) {
//        CategoryPage.safeClick(By.xpath("//a[label[text()='" + categoryName + "']]"));
//    }
//    public void clickViewMoreButton() {
//        CategoryPage.safeClick(By.xpath("//span[contains(@class,'topcategories_view_more_button')]"));
//    }
//    public void clickSoftwareTestingCategory() {
//        CategoryPage.safeClick(By.xpath("//a[text()='Software Testing']"));
//    }
//
//    public void clickSeleniumCourseByText() {
//        CategoryPage.safeClick(By.xpath("//a[contains(text(),'Selenium Certification Training')]"));
//    }
//
//    public void clickSeleniumCourseByHref() {
//        CategoryPage.safeClick(By.cssSelector("div.course-list a.clp-course-tile-link"));
//    }
// // Add this inside HomePage class
//    public boolean getLocalityName(String locality) {
//        try {
//            WebElement localityInput = driver.findElement(By.id("searchLocality")); // Adjust locator if needed
//            localityInput.clear();
//            localityInput.sendKeys(locality);
//            return true; // Successfully entered locality
//        } catch (Exception e) {
//            System.out.println("Error entering locality: " + e.getMessage());
//            return false; // Failed to enter locality
//        }
//    }
//    public boolean isBuyTabVisible() {
//        try {
//            WebElement buyTab = driver.findElement(By.xpath("//a[text()='BUY']")); // Adjust locator if needed
//            return buyTab.isDisplayed();
//        } catch (Exception e) {
//            System.out.println("BUY tab not found: " + e.getMessage());
//            return false;
//        }
//    }
// // ✅ Add this inside HomePage class (below existing methods)
//
// // Click category dynamically using text
//    public void clickDynamicCategory(String categoryName) {
//    	CategoryPage.safeClick(By.xpath("//a[contains(text(),'" + categoryName + "')]"));
//    }
//    public boolean areRelevantCoursesDisplayed() {
//        try {
//            // Read expected title part from properties file
//            String expectedTitlePart = com.parameters.PropertyReader.readProperty().getProperty("category5");
//
//            // Get current page title
//            String actualTitle = driver.getTitle();
//            System.out.println("Expected title part: " + expectedTitlePart);
//            System.out.println("Actual page title: " + actualTitle);
//
//            // Validate if actual title contains expected text
//            return actualTitle != null && actualTitle.contains(expectedTitlePart);
//        } catch (Exception e) {
//            System.out.println("Error validating relevant courses: " + e.getMessage());
//            return false;
//        }
//    }
//
////	public void scrollToSection(String sectionName) {
////	    try {
////	        WebElement sectionElement = driver.findElement(By.xpath("//h2[contains(text(),'" + sectionName + "')]"));
////	        JavascriptExecutor js = (JavascriptExecutor) driver;
////
////	        // Smooth scroll and center alignment
////	        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", sectionElement);
////
////	        // Optional: Highlight for debugging
////	        js.executeScript("arguments[0].style.border='3px solid red'", sectionElement);
////	        System.out.println("Scrolled to section: " + sectionName);
////	    } catch (Exception e) {
////	        System.out.println("Error scrolling to section: " + sectionName + " - " + e.getMessage());
////	    }
////	}
//
//    public void scrollToSection(String sectionName) {
//        WebElement sectionElement = driver.findElement(By.xpath("//h2[contains(text(),'" + sectionName + "')]"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", sectionElement);
//        System.out.println("Scrolled to section: " + sectionName);
//    }
//    // Validate if page title contains expected text
////    public boolean isPageLoaded(String expectedText) {
////    	return driver.getTitle().contains(expectedText);
////    }
////
////    // Check if relevant courses are displayed
////    @Override
////    public boolean areRelevantCoursesDisplayed() {
////    	try {
////    		return driver.findElements(By.xpath("//div[contains(@class,'course-card')]")).size() > 0;
////    	} catch (Exception e) {
////    		System.out.println("Error checking courses: " + e.getMessage());
////    		return false;
////    	}
////    }
//
//    
//}
//
////package com.pages;
////
////import org.openqa.selenium.By;
////import org.openqa.selenium.WebDriver;
////import org.openqa.selenium.WebElement;
////import org.openqa.selenium.support.FindBy;
////import org.openqa.selenium.support.PageFactory;
////
////import com.setup.BaseSteps;
////
////public class HomePage extends BaseSteps {
////
////    // ✅ Page Factory element for Discover Top Categories section
////    @FindBy(xpath = "//h2[text()='Discover Top Categories']")
////    private WebElement discoverTopCategoriesSection;
////
////    // ✅ Constructor initializes Page Factory
////    public HomePage(WebDriver driver) {
////        super();
////        PageFactory.initElements(driver, this);
////    }
////
////    // ✅ Scroll to Discover Top Categories section using BaseSteps
////    public void scrollToDiscoverTopCategories() {
////        scrollToSection("Discover Top Categories"); // Using BaseSteps method
////    }
////
////    // ✅ Click category dynamically using XPath
////    public void clickCategory(String categoryName) {
////        WebElement categoryElement = driver.findElement(By.xpath("//a[label[text()='" + categoryName + "']]"));
////        categoryElement.click();
////    }
////
////    // ✅ Click View More button using Page Factory or dynamic locator
////    public void clickViewMoreButton() {
////        WebElement viewMoreButton = driver.findElement(By.xpath("//span[contains(@class,'topcategories_view_more_button')]"));
////        viewMoreButton.click();
////    }
////
////    public void clickSoftwareTestingCategory() {
////        WebElement softwareTestingCategory = driver.findElement(By.xpath("//a[text()='Software Testing']"));
////        softwareTestingCategory.click();
////    }
////
////    public void clickSeleniumCourseByText() {
////        WebElement seleniumCourse = driver.findElement(By.xpath("//a[contains(text(),'Selenium Certification Training')]"));
////        seleniumCourse.click();
////    }
////
////    public void clickSeleniumCourseByHref() {
////        WebElement seleniumCourseHref = driver.findElement(By.cssSelector("div.course-list a.clp-course-tile-link"));
////        seleniumCourseHref.click();
////    }
////}
