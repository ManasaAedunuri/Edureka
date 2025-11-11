package com.stepDefinitionJUnit;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import com.setup.BaseSteps;
import com.parameters.ExcelReader; // Create a utility for reading Excel
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class PostGraduateProgramSteps {

    WebDriver driver;
    Map<String, String> testData;

    @Given("the user launches the application using data from {string} sheet {int}")
    public void the_user_launches_the_application_using_data_from_excel(String path, int sheetNo) {
        BaseSteps.launchBrowser();
        driver = BaseSteps.driver;
        testData = ExcelReader.getRowData(path, sheetNo); // Reads data from Excel
        driver.get(testData.get("sourceUrl"));
    }

    @When("the user scrolls to the sectionName section")
    public void the_user_scrolls_to_the_section_name_section() {
        String sectionName = testData.get("sectionName");
        BaseSteps.scrollToSection(sectionName); // Implement scroll logic in BaseSteps
    }

    @When("clicks on the category from Excel")
    public void clicks_on_the_category_from_excel() {
        String categoryName = testData.get("category");
        driver.findElement(By.linkText(categoryName)).click();
    }

    @Then("the category page should load successfully based on title from Excel")
    public void the_category_page_should_load_successfully_based_on_title_from_excel() {
        String expectedTitle = testData.get("expectedTitle");
        new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.titleContains(expectedTitle));
    }

    @When("clicks on the apply button from Excel")
    public void clicks_on_the_apply_button_from_excel() {
        String applyButtonXpath = testData.get("applyButtonXpath");
        driver.findElement(By.xpath(applyButtonXpath)).click();
    }

    @When("enters valid name, email, and phone number from Excel")
    public void enters_valid_name_email_and_phone_number_from_excel() {
        driver.findElement(By.id("name")).sendKeys(testData.get("name"));
        driver.findElement(By.id("email")).sendKeys(testData.get("email"));
        driver.findElement(By.id("phone")).sendKeys(testData.get("phone"));
    }

    @Then("the application form should be submitted successfully")
    public void the_application_form_should_be_submitted_successfully() {
        driver.findElement(By.id("submit")).click();
    }

    @Then("a confirmation message should be displayed")
    public void a_confirmation_message_should_be_displayed() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Thank you')]")));
    }
}