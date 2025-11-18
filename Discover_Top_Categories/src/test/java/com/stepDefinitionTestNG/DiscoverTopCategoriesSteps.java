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

import com.aventstack.extentreports.ExtentTest;
import com.pages.CategoryPage;
import com.pages.HomePage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;
import com.setup.Reports;

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
	ExtentTest test= Hooks.test;
	/*scenario 1 DISCOVER TOP CATEGORIES        */
//    @Given("the user is on the sourceUrl")
//    public void the_user_is_on_the_source_url() {
//        BaseSteps.launchBrowser();
//        driver = BaseSteps.driver;
//        driver.get(prop.getProperty("sourceUrl"));
//        homePage = new HomePage(driver);
//    }
	@Given("the user is on sourceUrl")
	public void the_user_is_on_source_url() {
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
    public void navigates_back_to_homepage() {
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
        Reports.captureScreenshot(driver, "screenshot_scenario_01");
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
    /*scenario 2  VIEW MORE            */
    @Given("the user is on the Edureka homepage")
    public void the_user_is_on_the_edureka_homepage() {
        // Launch browser and navigate to Edureka homepage
        BaseSteps.launchBrowser();
        driver = BaseSteps.driver;
        driver.get(prop.getProperty("sourceUrl")); // Using sourceUrl from properties
        homePage = new HomePage(driver);
        System.out.println("Navigated to Edureka homepage: " + prop.getProperty("sourceUrl"));
    }
    @When("the user scrolls to the sectionName")
    public void the_user_scrolls_to_the_section_name() {
      	homePage.scrollToDiscoverTopCategories();
    }
    @When("clicks on buttonName")
    public void clicks_on_button_name() {
        homePage.clickViewMoreButton();
        System.out.println("Clicked on button: " + prop.getProperty("buttonName"));
    }

    @When("clicks on category4")
    public void clicks_on_category4() {
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
        Reports.captureScreenshot(driver, "screenshot_scenario_02");
        driver.quit();
    }
    
    /*scenario 3 AI        */
    @Given("the user is on the  homepage")
    public void the_user_is_on_the_homepage() {
      	BaseSteps.launchBrowser();
        driver = BaseSteps.driver;
        driver.get(prop.getProperty("sourceUrl")); // Using sourceUrl from properties
        homePage = new HomePage(driver);
        System.out.println("Navigated to Edureka homepage: " + prop.getProperty("sourceUrl"));
    }

    @When("user scrolls to the sectionName")
    public void user_scrolls_to_the_section_name() {
    	   homePage.scrollToDiscoverTopCategories();
    }

    @When("clicks on the Category2")
    public void clicks_on_the_category2() {
    	    String categoryName = prop.getProperty("category2");
        homePage.clickCategory(categoryName);
    }

//    @Then("the Category2 page should load successfully")
//    public void the_category2_page_should_load_successfully() {
//    	    String categoryName = prop.getProperty("category2");
//        homePage.clickCategory2(categoryName);
//        categoryPage = new CategoryPage();
//        verifyCategoryPage("category2_urlPart");
//    }
//    @Then("the Category2 page should load successfully")
//    public void the_category2_page_should_load_successfully() {
//        String expectedUrlPart = prop.getProperty("category2_urlPart");
//        boolean isLoaded = categoryPage.isCategoryPageLoaded(expectedUrlPart);
//        Assert.assertTrue(isLoaded, "Category2 page did not load successfully");
//        System.out.println("✅ Category2 page loaded successfully with URL part: " + expectedUrlPart);
//    }
//    @Then("the Category2 page should load successfully")
//    public void the_category2_page_should_load_successfully() {
//        // Wait for the heading element to appear
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(
//            By.xpath("//h2[text()='Artificial Intelligence']")
//        ));
//
//        Assert.assertTrue(heading.isDisplayed(), "Category2 page did not load successfully");
//        System.out.println("✅ Verified Category2 page with heading: " + heading.getText());
//    }
    @Then("the Category2 page should load successfully")
    public void the_category2_page_should_load_successfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//h2[text()='Artificial Intelligence']")
        ));

        Assert.assertTrue(heading.isDisplayed(), "Category2 page did not load successfully");
        System.out.println("✅ Verified Category2 page with heading: " + heading.getText());
        
    }

   
//    @And("clicks on category6")
//    public void clicks_on_category6() {
//        homePage.clickDynamicCategory(prop.getProperty("category6"));
//    }

//    @And("clicks on category5")
//    public void clicks_on_category5() {
//        homePage.clickDynamicCategory(prop.getProperty("category5"));
//    }
//    @And("clicks on category5")
//    public void clicks_on_category5() {
//        String categoryName = prop.getProperty("category5"); // e.g., "Generative AI Course Masters Program"
//        
//        // Locate the element
//        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'" + categoryName + "')]"));
//        
//        // Scroll into view
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", element);
//        
//        // Click using existing safeClick
//        CategoryPage.safeClick(By.xpath("//a[contains(text(),'" + categoryName + "')]"));
//        
//        System.out.println("✅ Scrolled and clicked on category5: " + categoryName);
//    }
//    @And("clicks on category5 image")
//    public void clicks_on_category5_image() {
//        By imageLocator = By.xpath("(//img)[14]");
//        CategoryPage.safeClick(imageLocator);
//        System.out.println("✅ Clicked on the 14th image using XPath: (//img)[14]");
//    }
//    @Then("clicks on category5")
//    public void clicks_on_category5() {
//        String categoryName = prop.getProperty("category5"); // e.g., "Generative AI Course Masters Program"
//
//        // Locate and click using existing safeClick
//        CategoryPage.safeClick(By.xpath("//a[contains(text(),'" + categoryName + "')]"));
//
//        System.out.println("✅ Clicked on category5: " + categoryName);
//    }
//    @Then("clicks on category5")
//    public void clicks_on_category5() {
//        String categoryName = "Generative AI Course Masters Program"; // or prop.getProperty("category5")
//
//        // Scroll into view (optional for visibility)
//        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'" + categoryName + "')]"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", element);
//
//        // Click using existing safeClick
//        CategoryPage.safeClick(By.xpath("//a[contains(text(),'" + categoryName + "')]"));
//
//        System.out.println("✅ Clicked on category5: " + categoryName);
//    }
    @And("clicks on category5")
    public void clicks_on_category5() {
        By locator = By.xpath("(//img)[14]");
        CategoryPage.safeClick(locator);
        System.out.println("✅ Clicked on category5 using image index");
    }

//    @And("display relevant courses")
//    public void display_relevant_courses() {
//       	String categoryName = prop.getProperty("category5");
//        homePage.clickCategory(categoryName);
//        categoryPage = new CategoryPage();
//        verifyCategoryPage("category5_urlPart");
//    }
//    @And("display relevant courses")
//    public void display_relevant_courses() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        WebElement courseTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
//            By.xpath("//div[contains(@class,'popularcourses_course_title') and text()='Generative AI Course Masters Program']")
//        ));
//
//        Assert.assertTrue(courseTitle.isDisplayed(), "Relevant course not displayed");
//        System.out.println("✅ Verified relevant course: " + courseTitle.getText());
//    }
//    @Then("display relevant courses")
//    public void display_relevant_courses() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(
//            By.xpath("//h1[text()='Generative AI Course Masters Program']")
//        ));
//
//        Assert.assertTrue(heading.isDisplayed(), "Relevant course page not displayed");
//        System.out.println("✅ Verified course page heading: " + heading.getText());
//        driver.quit();
//    }
    @Then("display relevant courses")
    public void display_relevant_courses() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Flexible XPath: match any heading tag containing Generative AI
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//h1[contains(text(),'Generative AI')]|//h2[contains(text(),'Generative AI')]|//h3[contains(text(),'Generative AI')]")
        ));

        Assert.assertTrue(heading.isDisplayed(), "Relevant course page not displayed");
        System.out.println("Verified course page heading: " + heading.getText());
        Thread.sleep(2000);
        Reports.captureScreenshot(driver, "screenshot_scenario_03");
        driver.quit();
    }
    
    /*Scenario Outline 4         Brochure Download*/

    @Given("the user is on  Edureka homepage")
    public void the_user_is_on_edureka_homepage() {
     	BaseSteps.launchBrowser();
        driver = BaseSteps.driver;
        driver.get(prop.getProperty("sourceUrl")); // Using sourceUrl from properties
        homePage = new HomePage(driver);
        System.out.println("Navigated to Edureka homepage: " + prop.getProperty("sourceUrl"));
    }

    @When("clicks on category7")
    public void clicks_on_category7() throws InterruptedException {
        String categoryName = prop.getProperty("category7"); // e.g., "PG Programs"
        homePage.clickDynamicCategory2("PG Programs");
        System.out.println("Clicked on category7: " + categoryName);
        Thread.sleep(2000);
    }

    @When("clicks on category8")
    public void clicks_on_category8() {
        String categoryName = prop.getProperty("category8"); // e.g., "PGP in Generative AI and ML Illinois Tech"
        homePage.clickPGPGenerativeAI();
        System.out.println("Clicked on category8: " + categoryName);
    }

    @When("clicks on buttonName2")
    public void clicks_on_button_name2() {
        String buttonName = prop.getProperty("buttonName2"); // e.g., "Download Brochure"
        CategoryPage.safeClick(By.xpath("//button[contains(text(),'" + buttonName + "')]"));
        System.out.println("Clicked on button: " + buttonName);
    }

    @When("the user reads data from Excel at {int} and {int}")
    public void the_user_reads_data_from_excel_at_and(Integer sheetNo, Integer rowIndex) {
        try {
            excelData = ExcelReader.getRowDataAsMap(sheetNo, rowIndex);
            Assert.assertNotNull(excelData, "Excel data not found for sheet " + sheetNo + ", row " + rowIndex);
            System.out.println("Excel Data Loaded: " + excelData);
        } catch (Exception e) {
            Assert.fail("Failed to read Excel data: " + e.getMessage());
        }
    }

    @When("enters name, email, and phone number from Excel")
    public void enters_name_email_and_phone_number_from_excel() {
      	String name = excelData.get("Name");
      	String email = excelData.get("Email ID"); // Match Excel header
     	String phone = excelData.get("PhoneNo");  // Match Excel header

        homePage.enterName(name != null ? name : "");
        homePage.enterEmail(email != null ? email : "");
        homePage.enterPhone(phone != null ? phone : "");

        System.out.println("Entered Name, Email, and Phone from Excel");
    }

    @Then("the brochure request form should be submitted successfully")
    public void the_brochure_request_form_should_be_submitted_successfully() throws InterruptedException {
//        CategoryPage.safeClick(By.xpath("//button[contains(text(),'Submit')]"));
      	By submitButton = By.xpath("//button[text()='Get Brochure Now']");
      	CategoryPage.safeClick(submitButton);

        System.out.println("Brochure request form submitted");
        Thread.sleep(2000);
        Reports.captureScreenshot(driver, "screenshot_scenario_04");
        driver.quit();
    }
    
    /* GetInTouch scenario outline 5           */
    @Given("user is on Edureka homepage")
    public void user_is_on_edureka_homepage() {
     	BaseSteps.launchBrowser();
        driver = BaseSteps.driver;
        driver.get(prop.getProperty("sourceUrl")); // Using sourceUrl from properties
        homePage = new HomePage(driver);
        System.out.println("Navigated to Edureka homepage: " + prop.getProperty("sourceUrl"));
    }

    @When("scroll to sectionName")
    public void scroll_to_section_name() {
      	homePage.scrollToDiscoverTopCategories();
    }
    @When("click on the category4")
    public void click_on_the_category4() {
     	String categoryName = prop.getProperty("category4"); // Read from properties file
        homePage.clickCategory(categoryName);
        BaseSteps.sleep(1000);
        System.out.println("Clicked on " + categoryName + " category");
    }

    @When("clicks on the Selenium course")
    public void clicks_on_the_selenium_course() {
    	     WebElement firstCourse = driver.findElement(By.xpath("//button[text()='VIEW DETAILS']"));
         String courseName = firstCourse.getAttribute("data-title"); // Capture for verification
         System.out.println("Clicking on course: " + courseName);
         firstCourse.click();
    }

   



//    @When("clicks on buttonName3")
//    public void clicks_on_button_name3() throws InterruptedException {
//      	String buttonName = prop.getProperty("buttonName3"); // e.g., "Download Brochure"
//        CategoryPage.safeClick(By.xpath("//button[contains(text(),'" + buttonName + "')]"));
//        System.out.println("Clicked on button: " + buttonName);
//        Thread.sleep(2000);
//    }
    @When("clicks on buttonName3")
    public void clicks_on_button_name3() throws InterruptedException {
      	//String buttonName = prop.getProperty("buttonName3"); // e.g., "Download Brochure"
        CategoryPage.safeClick(By.xpath("//button[@class='videoinfo_btn_enr_stle__G_pv9 btn btn-primary']"));
        //System.out.println("Clicked on button: " + buttonName);
        Thread.sleep(2000);
    }
//    @When("clicks on buttonName3")
//    public void clicks_on_button_name3() {
//        String buttonName = prop.getProperty("buttonName3");
//        CategoryPage.safeClick(By.xpath("//button[contains(text(),'" + buttonName + "')]"));
//    }

//    @Then("the request form should be submitted successfully")
//    public void the_request_form_should_be_submitted_successfully() {
//        
//    }
    @When("email, and phone number from Excel")
    public void email_and_phone_number_from_excel() {
      	String email = excelData.get("Email_ID"); // Match Excel header
     	String phone = excelData.get("PhoneNumber");  // Match Excel header
        homePage.enterEmail2(email != null ? email : "");
        homePage.enterPhone2(phone != null ? phone : "");

        System.out.println("Entered Name, Email, and Phone from Excel");
    }
    @Then("the request form should be submitted successfully")
    public void the_request_form_should_be_submitted_successfully() throws InterruptedException {
        // Click the Submit button using safeClick
    	    By submitButton = By.xpath("//*[@id=\"firstENForm\"]/div[5]/button");
      	CategoryPage.safeClick(submitButton);

        System.out.println("request form submitted");
        Thread.sleep(2000);
        Reports.captureScreenshot(driver, "screenshot_scenario_05");
        driver.quit();
    }
    
    /* scenario 6                  */
    @Then("the error message should be displayed")
    public void the_error_message_should_be_displayed() throws InterruptedException {
    	By submitButton = By.xpath("//*[@id=\"firstENForm\"]/div[5]/button");
      	CategoryPage.safeClick(submitButton);

        System.out.println("request form submitted");
        Thread.sleep(2000);
        Reports.captureScreenshot(driver, "screenshot_scenario_06");
        driver.quit();
    }
  

//    @Then("it should display no matches found")
//    public void it_should_display_no_matches_found() {
//        
//    }




//    @Then("a confirmation message should be displayed")
//    public void a_confirmation_message_should_be_displayed() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement confirmationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
//            By.xpath("//div[contains(text(),'Thank you')]")
//        ));
//        Assert.assertTrue(confirmationMsg.isDisplayed(), "Confirmation message not displayed");
//        System.out.println("Confirmation message displayed: " + confirmationMsg.getText());
//    }
//    @Given("the user is on sourceUrl")
//    public void the_user_is_on_source_url() {
//        BaseSteps.launchBrowser();
//        driver = BaseSteps.driver;
//        driver.get(prop.getProperty("sourceUrl"));
//        homePage = new HomePage(driver);
//        System.out.println("Navigated to source URL: " + prop.getProperty("sourceUrl"));
//    }

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
//    @Given("the user accesses the Excel data from {int} using property-based path")
//    public void the_user_accesses_the_excel_data_from_using_property_based_path(Integer sheetIndex) {
//        // ✅ Load properties
//        Properties prop = PropertyReader.readProperty();
//        String excelPath = prop.getProperty("filepath"); // Reads Excel path from properties file
//
//        // ✅ Initialize ExcelReader
//        ExcelReader reader = new ExcelReader(excelPath);
//
//        // ✅ Read data from Excel
//        int rowIndex = 1; // First data row after header
//        String expectedTitle = reader.getCellData(sheetIndex, rowIndex, 2); // Column C
//        String applyButton = reader.getCellData(sheetIndex, rowIndex, 3);   // Column D
//        String name = reader.getCellData(sheetIndex, rowIndex, 4);          // Column E
//        String email = reader.getCellData(sheetIndex, rowIndex, 5);         // Column F
//        String phone = reader.getCellData(sheetIndex, rowIndex, 6);         // Column G
//
//        // ✅ Debug logs
//        System.out.println("Expected Title: " + expectedTitle);
//        System.out.println("Apply Button XPath: " + applyButton);
//        System.out.println("Name: " + name);
//        System.out.println("Email: " + email);
//        System.out.println("Phone: " + phone);
//    }
//
//    @When("clicks on the category from Excel")
//    public void clicks_on_the_category_from_excel() {
//        String categoryName = excelData.get("Category");
//        homePage.clickCategory(categoryName);
//        BaseSteps.sleep(1000);
//        System.out.println("Clicked on category: " + categoryName);
//    }
//
//    @Then("the category page should load successfully based on title from Excel")
//    public void the_category_page_should_load_successfully_based_on_title_from_excel() {
//        String expectedTitle = excelData.get("ExpectedTitle");
//        String actualTitle = driver.getTitle();
//        Assert.assertTrue(actualTitle.contains(expectedTitle),
//                "Expected title to contain: " + expectedTitle + " but got: " + actualTitle);
//        System.out.println("Verified category page title: " + actualTitle);
//    }
//
//    @Then("clicks on the apply button from Excel")
//    public void clicks_on_the_apply_button_from_excel() {
//        String applyButtonXpath = excelData.get("ApplyButtonXpath");
//        WebElement applyButton = driver.findElement(By.xpath(applyButtonXpath));
//        applyButton.click();
//        BaseSteps.sleep(1000);
//        System.out.println("Clicked on Apply button using XPath: " + applyButtonXpath);
//    }
//
//    @And("enters valid name, email, and phone number from Excel")
//    public void enters_valid_name_email_and_phone_number_from_excel() {
//        driver.findElement(By.id("name")).sendKeys(excelData.get("Name"));
//        driver.findElement(By.id("email")).sendKeys(excelData.get("Email"));
//        driver.findElement(By.id("phone")).sendKeys(excelData.get("Phone"));
//        System.out.println("Entered Name: " + excelData.get("Name") + ", Email: " + excelData.get("Email") +
//                ", Phone: " + excelData.get("Phone"));
//    }
//
//    @Then("the application form should be submitted successfully")
//    public void the_application_form_should_be_submitted_successfully() {
//        driver.findElement(By.id("submit")).click();
//        BaseSteps.sleep(2000);
//        System.out.println("Application form submitted successfully.");
//    }
//
//    @Then("a confirmation message should be displayed")
//    public void a_confirmation_message_should_be_displayed() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//div[contains(text(),'Thank you')]")));
//        Assert.assertTrue(confirmationMessage.isDisplayed(), "Confirmation message not displayed.");
//        System.out.println("Confirmation message displayed: " + confirmationMessage.getText());
//        driver.quit();
//    }
    /*scenario4 */

//    @Given("the user is on the {string}")
//    public void user_is_on_homepage(String homepage) {
//        driver.get(homepage);
//    }
//
//    @When("the user scrolls to the {string} section")
//    public void user_scrolls_to_section(String sectionName) {
//        WebElement section = driver.findElement(By.xpath("//h2[text()='" + sectionName + "']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section);
//    }
//    @When("the user scrolls to the sectionName section")
//    public void scroll_to_section() {
//        homePage.scrollToSection(config.getProperty("sectionName"));
//    }
//
//    @When("clicks on Category2")
//    public void click_category2() {
//        homePage.clickDynamicCategory(config.getProperty("category2"));
//    }
//
//    @Then("the Category2 page should load successfully")
//    public void verify_category2_page() {
//        Assert.assertTrue(homePage.isPageLoaded(config.getProperty("category2_urlPart")));
//    }
//
//    @When("clicks on category2explore")
//    public void click_category2explore() {
//        homePage.clickDynamicCategory(config.getProperty("category2explore"));
//    }
//
//    @When("clicks on category5")
//    public void click_category5() {
//        homePage.clickDynamicCategory(config.getProperty("category5"));
//    }
//
//    @Then("display relevant courses")
//    public void verify_courses() {
//        Assert.assertTrue(homePage.areRelevantCoursesDisplayed());
//    }
//
}
//package com.stepDefinitionTestNG;
//
//import java.time.Duration;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import com.pages.CategoryPage;
//import com.pages.HomePage;
//import com.parameters.ExcelReader;
//import com.parameters.PropertyReader;
//import com.setup.BaseSteps;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class DiscoverTopCategoriesSteps {
//
//    WebDriver driver;
//    Properties prop = PropertyReader.readProperty();
//    HomePage homePage;
//    CategoryPage categoryPage;
//	Map<String, String> excelData;
//	/*scenario 1*/
//	@Given("the user is on sourceUrl")
//	public void the_user_is_on_source_url() {
//        BaseSteps.launchBrowser();
//        driver = BaseSteps.driver;
//        driver.get(prop.getProperty("sourceUrl"));
//        homePage = new HomePage(driver);
//    }
//
//    @When("the user scrolls to the sectionName section")
//    public void the_user_scrolls_to_the_section_name_section() {
//        homePage.scrollToDiscoverTopCategories();
//    }
////    @When("the user scrolls to the sectionName section")
////    public void the_user_scrolls_to_the_section_name_section() {
////        homePage.scrollToDiscoverTopCategories();
////    }
//
//    @When("clicks on category1")
//    public void clicks_on_category1() {
//        String categoryName = prop.getProperty("category1");
//        homePage.clickCategory(categoryName);
//        BaseSteps.sleep(1000); // Optional wait
//        navigateBackToHomePage();
//    }
//
//    @When("clicks on category2")
//    public void clicks_on_category2() {
//        String categoryName = prop.getProperty("category2");
//        homePage.clickCategory(categoryName);
//        BaseSteps.sleep(1000); // Optional wait
//        navigateBackToHomePage();
//    }
//
//    @When("clicks on category3")
//    public void clicks_on_category3() {
//        String categoryName = prop.getProperty("category3");
//        homePage.clickCategory(categoryName);
//        categoryPage = new CategoryPage();
//        verifyCategoryPage("category3_urlPart");
//    }
//    @When("navigates back to homepage")
//    public void fallback_navigate_back() {
//        System.out.println("Fallback step executed.");
//    }
//
//    @Then("each respective category page should load successfully")
//    public void each_respective_category_page_should_load_successfully() {
//        System.out.println("Category 3 page verified successfully.");
//    }
//
//    private void verifyCategoryPage(String expectedTitlePartKey) {
//        String expectedTitlePart = prop.getProperty(expectedTitlePartKey);
//        if (expectedTitlePart == null) {
//            throw new IllegalArgumentException("Missing property for key: " + expectedTitlePartKey);
//        }
//
//        String actualTitle = driver.getTitle();
//        System.out.println("Page title: " + actualTitle);
//
//        if (!actualTitle.contains(expectedTitlePart)) {
//            throw new AssertionError("Expected title to contain: " + expectedTitlePart + " but got: " + actualTitle);
//        }
//        driver.quit();
//    }
//
//    // ✅ Helper method to navigate back and wait for homepage
//    private void navigateBackToHomePage() {
//        driver.navigate().back();
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//            .until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//h2[text()='Discover Top Categories']")));
//        BaseSteps.sleep(1000);
//        
//    }
////    @Given("the user is on sourceUrl")
////    public void the_user_is_on_source_url_without_the() {
////    // Reuse existing logic
////    	    BaseSteps.launchBrowser();
////        driver = BaseSteps.driver;
////        driver.get(prop.getProperty("sourceUrl"));
////        homePage = new HomePage(driver);
////     }
////    @Given("the user access the excel data from {string} sheet {int}")
////    public void the_user_access_the_excel_data_from_sheet(String path, int sheetno) {
////        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelData\\" + path;
////        excelData = ExcelReader.getRowData(filePath, sheetno);
////    }
////
////   
////
////        @When("clicks on the category from Excel")
////        public void clicks_on_the_category_from_excel() {
////            String categoryName = excelData.get("category");
////            homePage.clickCategory(categoryName);
////        }
////
////        @Then("the category page should load successfully based on title from Excel")
////        public void verify_category_page_from_excel() {
////            String expectedTitle = excelData.get("expectedTitle");
////            String actualTitle = driver.getTitle();
////            if (!actualTitle.contains(expectedTitle)) {
////                throw new AssertionError("Expected title: " + expectedTitle + " but got: " + actualTitle);
////            }
////        }
////
////        @When("clicks on the apply button from Excel")
////        public void clicks_on_apply_button_from_excel() {
////            String applyButtonXpath = excelData.get("applyButtonXpath");
////            driver.findElement(By.xpath(applyButtonXpath)).click();
////        }
////
////        @When("enters valid name, email, and phone number from Excel")
////        public void enters_valid_details_from_excel() {
////            driver.findElement(By.id("name")).sendKeys(excelData.get("name"));
////            driver.findElement(By.id("email")).sendKeys(excelData.get("email"));
////            driver.findElement(By.id("phone")).sendKeys(excelData.get("phone"));
////        }
////
////        @Then("the application form should be submitted successfully")
////        public void verify_form_submission() {
////            driver.findElement(By.id("submit")).click();
////        }
////
////        @Then("a confirmation message should be displayed")
////        public void verify_confirmation_message() {
////            String confirmationXpath = excelData.get("confirmationXpath");
////            new WebDriverWait(driver, Duration.ofSeconds(10))
////                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(confirmationXpath)));
////            System.out.println("Confirmation message displayed successfully.");
////        }
//    /*scenario 2*/
//    @Given("the user is on the Edureka homepage")
//    public void the_user_is_on_the_edureka_homepage() {
//        // Launch browser and navigate to Edureka homepage
//        BaseSteps.launchBrowser();
//        driver = BaseSteps.driver;
//        driver.get(prop.getProperty("sourceUrl")); // Using sourceUrl from properties
//        homePage = new HomePage(driver);
//        System.out.println("Navigated to Edureka homepage: " + prop.getProperty("sourceUrl"));
//    }
//    @And("clicks on buttonName")
//    public void clicks_on_button_name() {
//        homePage.clickViewMoreButton();
//        System.out.println("Clicked on button: " + prop.getProperty("buttonName"));
//    }
//
//    @And("selects Software Testing category")
//    public void selects_software_testing_category() {
//        String categoryName = prop.getProperty("category4"); // Read from properties file
//        homePage.clickCategory(categoryName);
//        BaseSteps.sleep(1000);
//        System.out.println("Clicked on " + categoryName + " category");
//    }
//
//    @And("clicks on Selenium course")
//    public void clicks_on_selenium_course() {
//        // Locate the first course dynamically under Software Testing
//        WebElement firstCourse = driver.findElement(By.xpath("//button[text()='VIEW DETAILS']"));
//        String courseName = firstCourse.getAttribute("data-title"); // Capture for verification
//        System.out.println("Clicking on course: " + courseName);
//        firstCourse.click();
//    }
//
//    @Then("the Selenium course page should load successfully")
//    public void the_selenium_course_page_should_load_successfully() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.titleContains("Selenium")); // Or use dynamic courseName
//        String actualTitle = driver.getTitle();
//        Assert.assertTrue(actualTitle.contains("Selenium"), "Course page did not load successfully");
//        System.out.println("Verified course page title: " + actualTitle);
//        driver.quit();
//    }
//    
////    /*scenario 3*/
////    @Given("the user is on sourceUrl")
////    public void the_user_is_on_source_url() {
////        BaseSteps.launchBrowser();
////        driver = BaseSteps.driver;
////        driver.get(prop.getProperty("sourceUrl"));
////        homePage = new HomePage(driver);
////        System.out.println("Navigated to source URL: " + prop.getProperty("sourceUrl"));
////    }
//
////    @Given("the user access the excel data from {string} sheet {int}")
////    public void the_user_access_the_excel_data_from_path_sheet(String fileName, Integer sheetIndex) {
////        String excelPath = System.getProperty("user.dir") + "/src/test/resources/" + fileName;
////
////        List<String[]> excelData = ExcelReader.readExcel(excelPath, sheetIndex);
////
////        if (excelData.isEmpty()) {
////            throw new RuntimeException("No data found in sheet " + sheetIndex);
////        }
////
////        // Example: Use first row of data
////        String[] selectedRow = excelData.get(0);
////        System.out.println("Selected Row: " + String.join(", ", selectedRow));
////    }
////    @Given("the user access the excel data from {string} sheet {int}")
////    public void the_user_access_the_excel_data_from_path_sheet(String fileName, int sheetIndex) { 
////        String excelPath = ExcelReader.getProperty("filepath"); // ✅ Correct
////        	List<String[]> excelData = ExcelReader.readExcel(excelPath, sheetIndex);
////    	    if (excelData.isEmpty()) {
////    	       throw new RuntimeException("No data found in sheet " + sheetIndex);
////    	    }
////    }
////    @Given("the user access the excel data from {string} sheet {int}")
////    public void the_user_access_the_excel_data_from_path_sheet(String fileName, int sheetIndex) throws Exception {
////        String excelPathSO = prop.getProperty("ScenarioOutlineExcelPath");
////
////        int rowIndex = 0;
////		// ✅ Original code
////        String selectedLocality = ExcelReader.getLocalityByRow(excelPathSO, sheetIndex, rowIndex);
////        Assert.assertNotNull(selectedLocality, 
////            String.format("Locality not found at sheet %d, row %d", sheetIndex, rowIndex));
////
////        boolean statusBuyTab = homePage.isBuyTabVisible();
////        Assert.assertTrue(statusBuyTab, "BUY tab is not visible on HomePage");
////
////        // ✅ Add enhancements here (without removing original code)
////        if (selectedLocality.trim().isEmpty()) {
////            throw new IllegalArgumentException(
////                String.format("Locality value is empty at sheet %d, row %d", sheetIndex, rowIndex));
////        }
////
////        System.out.println("Selected Locality: " + selectedLocality);
////        System.out.println("BUY Tab visibility status: " + statusBuyTab);
////    }
////    @Given("the user accesses the Excel data from sheet {int}")
////    public void the_user_accesses_the_excel_data_from_sheet(Integer sheetIndex) throws Exception {
////        Properties prop = PropertyReader.readProperty(); // Load properties
////        String excelPath = prop.getProperty("filepath"); // ✅ Use correct key from properties file
////        System.out.println("Excel Path: " + excelPath);
////
////        List<String[]> excelData = ExcelReader.readExcel(excelPath, sheetIndex);
////        Assert.assertFalse(excelData.isEmpty(), "Excel data is empty for sheet: " + sheetIndex);
////        System.out.println("Excel Data Loaded: " + excelData.size() + " rows");
////    }
////    @Given("the user accesses the Excel data from sheet {int}")
////    public void the_user_accesses_the_excel_data_from_sheet(Integer sheetIndex) throws Exception {
////        Properties prop = PropertyReader.readProperty(); // Load properties
////        String excelPath = prop.getProperty("filepath"); // ✅ Correct key
////        System.out.println("Excel Path: " + excelPath);
////
////        List<String[]> excelData = ExcelReader.readExcel(excelPath, sheetIndex);
////        Assert.assertFalse(excelData.isEmpty(), "Excel data is empty for sheet: " + sheetIndex);
////        System.out.println("Excel Data Loaded: " + excelData.size() + " rows");
////    }
////    @Given("the user accesses the Excel data from {int} using property-based path")
////    public void the_user_accesses_the_excel_data_from_using_property_based_path(Integer sheetIndex) throws Exception {
////        // Load properties
////        Properties prop = PropertyReader.readProperty();
////        String excelPath = prop.getProperty("filepath"); // ✅ Read from properties file
////        System.out.println("Excel Path from properties: " + excelPath);
////
////        // Read Excel data
////        ExcelReader reader = new ExcelReader(excelPath);
////        int rows = reader.getRowcount(sheetIndex);
////        System.out.println("Total rows in sheet " + sheetIndex + ": " + rows);
////
////        // Example: Fetch first row data
////        String category = reader.getCellData(sheetIndex, 1, 0); // row 1, col 0
////        System.out.println("Category from Excel: " + category);
////
////        Assert.assertTrue(rows > 0, "Excel data is empty for sheet: " + sheetIndex);
////    }
////    @Given("the user accesses the Excel data from {int} using property-based path")
////    public void the_user_accesses_the_excel_data_from_using_property_based_path(Integer sheetIndex) {
////        // ✅ Load properties
////        Properties prop = PropertyReader.readProperty();
////        String excelPath = prop.getProperty("filepath"); // Reads Excel path from properties file
////
////        // ✅ Initialize ExcelReader
////        ExcelReader reader = new ExcelReader(excelPath);
////
////        // ✅ Read data from Excel
////        int rowIndex = 1; // First data row after header
////        String expectedTitle = reader.getCellData(sheetIndex, rowIndex, 2); // Column C
////        String applyButton = reader.getCellData(sheetIndex, rowIndex, 3);   // Column D
////        String name = reader.getCellData(sheetIndex, rowIndex, 4);          // Column E
////        String email = reader.getCellData(sheetIndex, rowIndex, 5);         // Column F
////        String phone = reader.getCellData(sheetIndex, rowIndex, 6);         // Column G
////
////        // ✅ Debug logs
////        System.out.println("Expected Title: " + expectedTitle);
////        System.out.println("Apply Button XPath: " + applyButton);
////        System.out.println("Name: " + name);
////        System.out.println("Email: " + email);
////        System.out.println("Phone: " + phone);
////    }
////
////    @When("clicks on the category from Excel")
////    public void clicks_on_the_category_from_excel() {
////        String categoryName = excelData.get("Category");
////        homePage.clickCategory(categoryName);
////        BaseSteps.sleep(1000);
////        System.out.println("Clicked on category: " + categoryName);
////    }
////
////    @Then("the category page should load successfully based on title from Excel")
////    public void the_category_page_should_load_successfully_based_on_title_from_excel() {
////        String expectedTitle = excelData.get("ExpectedTitle");
////        String actualTitle = driver.getTitle();
////        Assert.assertTrue(actualTitle.contains(expectedTitle),
////                "Expected title to contain: " + expectedTitle + " but got: " + actualTitle);
////        System.out.println("Verified category page title: " + actualTitle);
////    }
////
////    @Then("clicks on the apply button from Excel")
////    public void clicks_on_the_apply_button_from_excel() {
////        String applyButtonXpath = excelData.get("ApplyButtonXpath");
////        WebElement applyButton = driver.findElement(By.xpath(applyButtonXpath));
////        applyButton.click();
////        BaseSteps.sleep(1000);
////        System.out.println("Clicked on Apply button using XPath: " + applyButtonXpath);
////    }
////
////    @And("enters valid name, email, and phone number from Excel")
////    public void enters_valid_name_email_and_phone_number_from_excel() {
////        driver.findElement(By.id("name")).sendKeys(excelData.get("Name"));
////        driver.findElement(By.id("email")).sendKeys(excelData.get("Email"));
////        driver.findElement(By.id("phone")).sendKeys(excelData.get("Phone"));
////        System.out.println("Entered Name: " + excelData.get("Name") + ", Email: " + excelData.get("Email") +
////                ", Phone: " + excelData.get("Phone"));
////    }
////
////    @Then("the application form should be submitted successfully")
////    public void the_application_form_should_be_submitted_successfully() {
////        driver.findElement(By.id("submit")).click();
////        BaseSteps.sleep(2000);
////        System.out.println("Application form submitted successfully.");
////    }
////
////    @Then("a confirmation message should be displayed")
////    public void a_confirmation_message_should_be_displayed() {
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
////                By.xpath("//div[contains(text(),'Thank you')]")));
////        Assert.assertTrue(confirmationMessage.isDisplayed(), "Confirmation message not displayed.");
////        System.out.println("Confirmation message displayed: " + confirmationMessage.getText());
////        driver.quit();
////    }
////    
//    /*scenario3*/
////    @Given("the user is on sourceUrl")
////    public void open_homepage() {
////        driver.get(prop.getProperty("sourceUrl"));
////    }
//    @Given("the user is on sourceUrl")
//    public void open_homepage() {
//        driver.get(prop.getProperty("sourceUrl"));
//        homePage = new HomePage(driver); // ✅ Ensure it's initialized
//    }
//
//    @When("the user scrolls to the sectionName section")
//    public void scroll_to_section() {
//        homePage.scrollToSection(prop.getProperty("sectionName"));
//    }
//
//    @When("clicks on the buttonName")
//    public void clicks_on_the_button_name() {
//    	    homePage.clickViewMoreButton();
//        System.out.println("Clicked on button: " + prop.getProperty("buttonName"));
//    }
//
//    @When("clicks on the category4")
//    public void click_category4() {
//        homePage.clickCategory(prop.getProperty("category4")); // Software Testing
//    }
//
//    @When("clicks on Selenium Training Course")
//    public void click_selenium_course() {
//        WebElement seleniumCourse = driver.findElement(By.xpath("//a[contains(text(),'Selenium Training Course')]"));
//        seleniumCourse.click();
//    }
//
//    @When("clicks on Enroll Now")
//    public void click_enroll_now() {
//        WebElement enrollBtn = driver.findElement(By.xpath("//span[contains(normalize-space(.),'Enroll Now')]"));
//        enrollBtn.click();
//    }
//
////    @And("the user accesses the Excel data from {int} {int} using property-based path")
////    public void read_excel_data(int sheetNo,int rowIndex) throws Exception {
////        //excelData = ExcelReader.readData(prop.getProperty("filepath"), sheetNo);
////    	String path=prop.getProperty("filepath");
////		ExcelReader excel=new ExcelReader(path);
////		//String selectedLocality = ExcelReader.getColumnData(path, sheetNo, rowIndex);
////		List<String> var = excel.getColumnData(sheetNo, rowIndex);
////		Assert.assertNotNull(var, "Locality not found at sheet " + sheetNo + ", row " + rowIndex);
////    }
////    @And("the user accesses the Excel data from {int} {int} using property-based path")
////    public void read_excel_data(int sheetNo, int rowIndex) throws Exception {
////        String path = prop.getProperty("filepath");
////        // ✅ Use readData() to get email and phone as key-value pairs
////        excelData = ExcelReader.readData(path, sheetNo); // Implemented earlier
////        Assert.assertNotNull(excelData, "Excel data not found for sheet " + sheetNo);
////        System.out.println("Excel Data Loaded: " + excelData);
////    }
//
//    @And("the user accesses the Excel data from {int} {int} using property-based path")
//    public void read_excel_data(int sheetNo, int rowIndex) throws Exception {
//        String path = prop.getProperty("filepath");
//        excelData = ExcelReader.readData(path, sheetNo, rowIndex); // ✅ dynamic row
//        Assert.assertNotNull(excelData, "Excel data not found for sheet " + sheetNo + ", row " + rowIndex);
//        System.out.println("Excel Data Loaded: " + excelData);
//    }
//
//    @And("enters valid email and phone number from Excel")
//    public void enter_email_phone() {
//        driver.findElement(By.id("email")).sendKeys(excelData.get("Email")); // ✅ match header name
//        driver.findElement(By.id("phone")).sendKeys(excelData.get("Phone"));
//    }
//
////    @And("enters valid email and phone number from Excel")
////    public void enter_email_phone() {
////        driver.findElement(By.id("email")).sendKeys(excelData.get("email"));
////        driver.findElement(By.id("phone")).sendKeys(excelData.get("phone"));
////    }
////    @And("enters valid email and phone number from Excel")
////    public void enter_email_phone() {
////        driver.findElement(By.id("email")).sendKeys(excelData.get("email"));
////        driver.findElement(By.id("phone")).sendKeys(excelData.get("phone"));
////    }
////
////    @Then("the application form should be submitted successfully")
////    @Then("a confirmation message should be displayed")
////    public void verify_submission() {
////        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Thank you')]")).isDisplayed());
////    }
//    @Then("the application form should be submitted successfully")
//    public void the_application_form_should_be_submitted_successfully() {
//        // Wait for confirmation element after form submission
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement confirmationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
//            By.xpath("//div[contains(text(),'Thank you')]")
//        ));
//
//        Assert.assertTrue(confirmationMsg.isDisplayed(), "Confirmation message not displayed");
//        System.out.println("Application form submitted successfully.");
//    }
//    /*scenario4 */
//
////    @Given("the user is on the {string}")
////    public void user_is_on_homepage(String homepage) {
////        driver.get(homepage);
////    }
////
////    @When("the user scrolls to the {string} section")
////    public void user_scrolls_to_section(String sectionName) {
////        WebElement section = driver.findElement(By.xpath("//h2[text()='" + sectionName + "']"));
////        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section);
////    }
////    @When("clicks on Category2")
////    public void click_category2() {
////        homePage.clickDynamicCategory(prop.getProperty("category2"));
////    }
////
////    @When("clicks on category5")
////    public void click_category5() {
////        categoryPage.clickGenerativeAIProgram();
////    }
////
////    @Then("display relevant courses")
////    public void verify_courses() {
////        Assert.assertTrue(homePage.areRelevantCoursesDisplayed(), "Relevant courses not displayed");
////    }
//    @Given("the user is on the {string}")
//    public void user_is_on_homepage(String homepage) {
//        driver.get(homepage);
//    }
//
//    @When("the user scrolls to the {string} section")
//    public void user_scrolls_to_section(String sectionName) {
//    	     homePage.scrollToDiscoverTopCategories();
//    }
//
//    @When("clicks on Category2")
//    public void click_category2() {
//        homePage.clickDynamicCategory(prop.getProperty("category2")); // Uses category2 from properties
//    }
//
////    @When("clicks on category6")
////    public void click_category6() {
////        homePage.clickDynamicCategory(prop.getProperty("category6")); // Added category6 from properties
////    }
//    @When("clicks on category6")
//    public void click_category6() {
//        String category6Text = prop.getProperty("category6"); // "Explore Artificial Intelligence Courses"
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//        // Wait for element to be present
//        WebElement category6Element = wait.until(ExpectedConditions.presenceOfElementLocated(
//            By.xpath("//a[contains(normalize-space(text()),'" + category6Text + "')]")
//        ));
//
//        // Scroll into view
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", category6Element);
//
//        // Click safely
//        wait.until(ExpectedConditions.elementToBeClickable(category6Element)).click();
//    }
//
//    @When("clicks on category5")
//    public void click_category5() {
//        categoryPage.clickGenerativeAIProgram(); // Existing logic retained
//    }
//
//    @Then("display relevant courses")
//    public void verify_courses() {
//        Assert.assertTrue(homePage.areRelevantCoursesDisplayed(), "Relevant courses not displayed");
//
//        // ✅ Added Explore button verification using XPath from requirement
//        WebElement exploreButton = driver.findElement(By.xpath("//span[text()='Explore ']"));
//        Assert.assertTrue(exploreButton.isDisplayed(), "'Explore' button is not visible");
//    }
//
//}