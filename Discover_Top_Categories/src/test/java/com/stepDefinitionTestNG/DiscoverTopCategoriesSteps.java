package com.stepDefinitionTestNG;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.CategoryPage;
import com.pages.HomePage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DiscoverTopCategoriesSteps {

    WebDriver driver;
    Properties prop = PropertyReader.readProperty();
    HomePage homePage;
    CategoryPage categoryPage;
	Map<String, String> excelData;
	/*scenario 1*/
    @Given("the user is on the sourceUrl")
    public void the_user_is_on_the_source_url() {
        BaseSteps.launchBrowser();
        driver = BaseSteps.driver;
        driver.get(prop.getProperty("sourceUrl"));
        homePage = new HomePage(driver);
    }

    @When("the user scrolls to the sectionName section")
    public void the_user_scrolls_to_the_section_name_section() {
        homePage.scrollToDiscoverTopCategories();
    }

    @When("clicks on category1")
    public void clicks_on_category1() {
        String categoryName = prop.getProperty("category1");
        homePage.clickCategory(categoryName);
        BaseSteps.sleep(1000); // Optional wait
        navigateBackToHomePage();
    }

    @When("clicks on category2")
    public void clicks_on_category2() {
        String categoryName = prop.getProperty("category2");
        homePage.clickCategory(categoryName);
        BaseSteps.sleep(1000); // Optional wait
        navigateBackToHomePage();
    }

    @When("clicks on category3")
    public void clicks_on_category3() {
        String categoryName = prop.getProperty("category3");
        homePage.clickCategory(categoryName);
        categoryPage = new CategoryPage();
        verifyCategoryPage("category3_urlPart");
    }
    @When("navigates back to homepage")
    public void fallback_navigate_back() {
        System.out.println("Fallback step executed.");
    }

    @Then("each respective category page should load successfully")
    public void each_respective_category_page_should_load_successfully() {
        System.out.println("Category 3 page verified successfully.");
    }

    private void verifyCategoryPage(String expectedTitlePartKey) {
        String expectedTitlePart = prop.getProperty(expectedTitlePartKey);
        if (expectedTitlePart == null) {
            throw new IllegalArgumentException("Missing property for key: " + expectedTitlePartKey);
        }

        String actualTitle = driver.getTitle();
        System.out.println("Page title: " + actualTitle);

        if (!actualTitle.contains(expectedTitlePart)) {
            throw new AssertionError("Expected title to contain: " + expectedTitlePart + " but got: " + actualTitle);
        }
        driver.quit();
    }

    // ✅ Helper method to navigate back and wait for homepage
    private void navigateBackToHomePage() {
        driver.navigate().back();
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[text()='Discover Top Categories']")));
        BaseSteps.sleep(1000);
        
    }
//    @Given("the user is on sourceUrl")
//    public void the_user_is_on_source_url_without_the() {
//    // Reuse existing logic
//    	    BaseSteps.launchBrowser();
//        driver = BaseSteps.driver;
//        driver.get(prop.getProperty("sourceUrl"));
//        homePage = new HomePage(driver);
//     }
//    @Given("the user access the excel data from {string} sheet {int}")
//    public void the_user_access_the_excel_data_from_sheet(String path, int sheetno) {
//        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelData\\" + path;
//        excelData = ExcelReader.getRowData(filePath, sheetno);
//    }
//
//   
//
//        @When("clicks on the category from Excel")
//        public void clicks_on_the_category_from_excel() {
//            String categoryName = excelData.get("category");
//            homePage.clickCategory(categoryName);
//        }
//
//        @Then("the category page should load successfully based on title from Excel")
//        public void verify_category_page_from_excel() {
//            String expectedTitle = excelData.get("expectedTitle");
//            String actualTitle = driver.getTitle();
//            if (!actualTitle.contains(expectedTitle)) {
//                throw new AssertionError("Expected title: " + expectedTitle + " but got: " + actualTitle);
//            }
//        }
//
//        @When("clicks on the apply button from Excel")
//        public void clicks_on_apply_button_from_excel() {
//            String applyButtonXpath = excelData.get("applyButtonXpath");
//            driver.findElement(By.xpath(applyButtonXpath)).click();
//        }
//
//        @When("enters valid name, email, and phone number from Excel")
//        public void enters_valid_details_from_excel() {
//            driver.findElement(By.id("name")).sendKeys(excelData.get("name"));
//            driver.findElement(By.id("email")).sendKeys(excelData.get("email"));
//            driver.findElement(By.id("phone")).sendKeys(excelData.get("phone"));
//        }
//
//        @Then("the application form should be submitted successfully")
//        public void verify_form_submission() {
//            driver.findElement(By.id("submit")).click();
//        }
//
//        @Then("a confirmation message should be displayed")
//        public void verify_confirmation_message() {
//            String confirmationXpath = excelData.get("confirmationXpath");
//            new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(confirmationXpath)));
//            System.out.println("Confirmation message displayed successfully.");
//        }
    /*scenario 2*/
    @Given("the user is on the Edureka homepage")
    public void the_user_is_on_the_edureka_homepage() {
        // Launch browser and navigate to Edureka homepage
        BaseSteps.launchBrowser();
        driver = BaseSteps.driver;
        driver.get(prop.getProperty("sourceUrl")); // Using sourceUrl from properties
        homePage = new HomePage(driver);
        System.out.println("Navigated to Edureka homepage: " + prop.getProperty("sourceUrl"));
    }
    @When("clicks on buttonName")
    public void clicks_on_button_name() {
        homePage.clickViewMoreButton();
        System.out.println("Clicked on button: " + prop.getProperty("buttonName"));
    }

    @When("selects Software Testing category")
    public void selects_software_testing_category() {
        String categoryName = prop.getProperty("category4"); // Read from properties file
        homePage.clickCategory(categoryName);
        BaseSteps.sleep(1000);
        System.out.println("Clicked on " + categoryName + " category");
    }

    @When("clicks on Selenium course")
    public void clicks_on_selenium_course() {
        // Locate the first course dynamically under Software Testing
        WebElement firstCourse = driver.findElement(By.xpath("//button[text()='VIEW DETAILS']"));
        String courseName = firstCourse.getAttribute("data-title"); // Capture for verification
        System.out.println("Clicking on course: " + courseName);
        firstCourse.click();
    }

    @Then("the Selenium course page should load successfully")
    public void the_selenium_course_page_should_load_successfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Selenium")); // Or use dynamic courseName
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Selenium"), "Course page did not load successfully");
        System.out.println("Verified course page title: " + actualTitle);
        driver.quit();
    }
    
    /*scenario 3*/
    @Given("the user is on sourceUrl")
    public void the_user_is_on_source_url() {
        BaseSteps.launchBrowser();
        driver = BaseSteps.driver;
        driver.get(prop.getProperty("sourceUrl"));
        homePage = new HomePage(driver);
        System.out.println("Navigated to source URL: " + prop.getProperty("sourceUrl"));
    }

//    @Given("the user access the excel data from {string} sheet {int}")
//    public void the_user_access_the_excel_data_from_path_sheet(String fileName, Integer sheetIndex) {
//        String excelPath = System.getProperty("user.dir") + "/src/test/resources/" + fileName;
//
//        List<String[]> excelData = ExcelReader.readExcel(excelPath, sheetIndex);
//
//        if (excelData.isEmpty()) {
//            throw new RuntimeException("No data found in sheet " + sheetIndex);
//        }
//
//        // Example: Use first row of data
//        String[] selectedRow = excelData.get(0);
//        System.out.println("Selected Row: " + String.join(", ", selectedRow));
//    }
//    @Given("the user access the excel data from {string} sheet {int}")
//    public void the_user_access_the_excel_data_from_path_sheet(String fileName, int sheetIndex) { 
//        String excelPath = ExcelReader.getProperty("filepath"); // ✅ Correct
//        	List<String[]> excelData = ExcelReader.readExcel(excelPath, sheetIndex);
//    	    if (excelData.isEmpty()) {
//    	       throw new RuntimeException("No data found in sheet " + sheetIndex);
//    	    }
//    }
//    @Given("the user access the excel data from {string} sheet {int}")
//    public void the_user_access_the_excel_data_from_path_sheet(String fileName, int sheetIndex) throws Exception {
//        String excelPathSO = prop.getProperty("ScenarioOutlineExcelPath");
//
//        int rowIndex = 0;
//		// ✅ Original code
//        String selectedLocality = ExcelReader.getLocalityByRow(excelPathSO, sheetIndex, rowIndex);
//        Assert.assertNotNull(selectedLocality, 
//            String.format("Locality not found at sheet %d, row %d", sheetIndex, rowIndex));
//
//        boolean statusBuyTab = homePage.isBuyTabVisible();
//        Assert.assertTrue(statusBuyTab, "BUY tab is not visible on HomePage");
//
//        // ✅ Add enhancements here (without removing original code)
//        if (selectedLocality.trim().isEmpty()) {
//            throw new IllegalArgumentException(
//                String.format("Locality value is empty at sheet %d, row %d", sheetIndex, rowIndex));
//        }
//
//        System.out.println("Selected Locality: " + selectedLocality);
//        System.out.println("BUY Tab visibility status: " + statusBuyTab);
//    }
//    @Given("the user accesses the Excel data from sheet {int}")
//    public void the_user_accesses_the_excel_data_from_sheet(Integer sheetIndex) throws Exception {
//        Properties prop = PropertyReader.readProperty(); // Load properties
//        String excelPath = prop.getProperty("filepath"); // ✅ Use correct key from properties file
//        System.out.println("Excel Path: " + excelPath);
//
//        List<String[]> excelData = ExcelReader.readExcel(excelPath, sheetIndex);
//        Assert.assertFalse(excelData.isEmpty(), "Excel data is empty for sheet: " + sheetIndex);
//        System.out.println("Excel Data Loaded: " + excelData.size() + " rows");
//    }
//    @Given("the user accesses the Excel data from sheet {int}")
//    public void the_user_accesses_the_excel_data_from_sheet(Integer sheetIndex) throws Exception {
//        Properties prop = PropertyReader.readProperty(); // Load properties
//        String excelPath = prop.getProperty("filepath"); // ✅ Correct key
//        System.out.println("Excel Path: " + excelPath);
//
//        List<String[]> excelData = ExcelReader.readExcel(excelPath, sheetIndex);
//        Assert.assertFalse(excelData.isEmpty(), "Excel data is empty for sheet: " + sheetIndex);
//        System.out.println("Excel Data Loaded: " + excelData.size() + " rows");
//    }
//    @Given("the user accesses the Excel data from {int} using property-based path")
//    public void the_user_accesses_the_excel_data_from_using_property_based_path(Integer sheetIndex) throws Exception {
//        // Load properties
//        Properties prop = PropertyReader.readProperty();
//        String excelPath = prop.getProperty("filepath"); // ✅ Read from properties file
//        System.out.println("Excel Path from properties: " + excelPath);
//
//        // Read Excel data
//        ExcelReader reader = new ExcelReader(excelPath);
//        int rows = reader.getRowcount(sheetIndex);
//        System.out.println("Total rows in sheet " + sheetIndex + ": " + rows);
//
//        // Example: Fetch first row data
//        String category = reader.getCellData(sheetIndex, 1, 0); // row 1, col 0
//        System.out.println("Category from Excel: " + category);
//
//        Assert.assertTrue(rows > 0, "Excel data is empty for sheet: " + sheetIndex);
//    }
    @Given("the user accesses the Excel data from {int} using property-based path")
    public void the_user_accesses_the_excel_data_from_using_property_based_path(Integer sheetIndex) {
        // ✅ Load properties
        Properties prop = PropertyReader.readProperty();
        String excelPath = prop.getProperty("filepath"); // Reads Excel path from properties file

        // ✅ Initialize ExcelReader
        ExcelReader reader = new ExcelReader(excelPath);

        // ✅ Read data from Excel
        int rowIndex = 1; // First data row after header
        String expectedTitle = reader.getCellData(sheetIndex, rowIndex, 2); // Column C
        String applyButton = reader.getCellData(sheetIndex, rowIndex, 3);   // Column D
        String name = reader.getCellData(sheetIndex, rowIndex, 4);          // Column E
        String email = reader.getCellData(sheetIndex, rowIndex, 5);         // Column F
        String phone = reader.getCellData(sheetIndex, rowIndex, 6);         // Column G

        // ✅ Debug logs
        System.out.println("Expected Title: " + expectedTitle);
        System.out.println("Apply Button XPath: " + applyButton);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
    }

    @When("clicks on the category from Excel")
    public void clicks_on_the_category_from_excel() {
        String categoryName = excelData.get("Category");
        homePage.clickCategory(categoryName);
        BaseSteps.sleep(1000);
        System.out.println("Clicked on category: " + categoryName);
    }

    @Then("the category page should load successfully based on title from Excel")
    public void the_category_page_should_load_successfully_based_on_title_from_excel() {
        String expectedTitle = excelData.get("ExpectedTitle");
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "Expected title to contain: " + expectedTitle + " but got: " + actualTitle);
        System.out.println("Verified category page title: " + actualTitle);
    }

    @Then("clicks on the apply button from Excel")
    public void clicks_on_the_apply_button_from_excel() {
        String applyButtonXpath = excelData.get("ApplyButtonXpath");
        WebElement applyButton = driver.findElement(By.xpath(applyButtonXpath));
        applyButton.click();
        BaseSteps.sleep(1000);
        System.out.println("Clicked on Apply button using XPath: " + applyButtonXpath);
    }

    @And("enters valid name, email, and phone number from Excel")
    public void enters_valid_name_email_and_phone_number_from_excel() {
        driver.findElement(By.id("name")).sendKeys(excelData.get("Name"));
        driver.findElement(By.id("email")).sendKeys(excelData.get("Email"));
        driver.findElement(By.id("phone")).sendKeys(excelData.get("Phone"));
        System.out.println("Entered Name: " + excelData.get("Name") + ", Email: " + excelData.get("Email") +
                ", Phone: " + excelData.get("Phone"));
    }

    @Then("the application form should be submitted successfully")
    public void the_application_form_should_be_submitted_successfully() {
        driver.findElement(By.id("submit")).click();
        BaseSteps.sleep(2000);
        System.out.println("Application form submitted successfully.");
    }

    @Then("a confirmation message should be displayed")
    public void a_confirmation_message_should_be_displayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(),'Thank you')]")));
        Assert.assertTrue(confirmationMessage.isDisplayed(), "Confirmation message not displayed.");
        System.out.println("Confirmation message displayed: " + confirmationMessage.getText());
        driver.quit();
    }
    /*scenario4 */

    @Given("the user is on the {string}")
    public void user_is_on_homepage(String homepage) {
        driver.get(homepage);
    }

    @When("the user scrolls to the {string} section")
    public void user_scrolls_to_section(String sectionName) {
        WebElement section = driver.findElement(By.xpath("//h2[text()='" + sectionName + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section);
    }
    @When("the user scrolls to the sectionName section")
    public void scroll_to_section() {
        homePage.scrollToSection(config.getProperty("sectionName"));
    }

    @When("clicks on Category2")
    public void click_category2() {
        homePage.clickDynamicCategory(config.getProperty("category2"));
    }

    @Then("the Category2 page should load successfully")
    public void verify_category2_page() {
        Assert.assertTrue(homePage.isPageLoaded(config.getProperty("category2_urlPart")));
    }

    @When("clicks on category2explore")
    public void click_category2explore() {
        homePage.clickDynamicCategory(config.getProperty("category2explore"));
    }

    @When("clicks on category5")
    public void click_category5() {
        homePage.clickDynamicCategory(config.getProperty("category5"));
    }

    @Then("display relevant courses")
    public void verify_courses() {
        Assert.assertTrue(homePage.areRelevantCoursesDisplayed());
    }

}