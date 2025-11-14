package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.setup.BaseSteps;

public class HomePage extends BaseSteps {

   

    // ✅ Page for static locators
    @FindBy(xpath = "//h2[text()='Discover Top Categories']")
    private WebElement discoverTopCategoriesSection;

    @FindBy(xpath = "//span[contains(@class,'topcategories_view_more_button')]")
    private WebElement viewMoreButton;

    @FindBy(xpath = "//a[text()='Software Testing']")
    private WebElement softwareTestingCategory;

    @FindBy(css = "div.course-list a.clp-course-tile-link")
    private WebElement seleniumCourseByHref;

    @FindBy(id = "searchLocality")
    private WebElement localityInput;

    @FindBy(xpath = "//a[text()='BUY']")
    private WebElement buyTab;

    @FindBy(xpath = "(//input[@name='name'])[2]")
    private WebElement nameInput;

    @FindBy(xpath = "(//input[@name='email'])[2]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id='applyScholarshipForm']/div/div/div/div[2]/form/div[3]/input[2]")
    private WebElement phoneInput;

    @FindBy(xpath = "//*[@id='firstENForm']/div[1]/input")
    private WebElement emailInput2;

    @FindBy(xpath = "//*[@id='firstENForm']/div[2]/input")
    private WebElement phoneInput2;

    @FindBy(xpath = "//h3[text()='Generative AI Course Masters Program']")
    private WebElement aiMastersLink;

    // ✅ Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ✅ Existing methods remain unchanged except where PageFactory elements are used
    public static void scrollToSection(String sectionName) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement sectionElement = driver.findElement(By.xpath("//h2[contains(text(),'" + sectionName + "')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", sectionElement);
    }

    public void scrollToDiscoverTopCategories() {
        CategoryPage.scrollToElement(discoverTopCategoriesSection);
    }

    public void clickCategory(String categoryName) {
        CategoryPage.safeClick(By.xpath("//a[label[text()='" + categoryName + "']]")); // dynamic locator stays
    }

    public void clickViewMoreButton() {
        CategoryPage.safeClick(viewMoreButton); // ✅ uses overloaded safeClick(WebElement)
    }

    public void clickSoftwareTestingCategory() {
        CategoryPage.safeClick(softwareTestingCategory);
    }

    public void clickSeleniumCourseByHref() {
        CategoryPage.safeClick(seleniumCourseByHref);
    }

    public boolean getLocalityName(String locality) {
        try {
            localityInput.clear();
            localityInput.sendKeys(locality);
            return true;
        } catch (Exception e) {
            System.out.println("Error entering locality: " + e.getMessage());
            return false;
        }
    }

    public boolean isBuyTabVisible() {
        try {
            return buyTab.isDisplayed();
        } catch (Exception e) {
            System.out.println("BUY tab not found: " + e.getMessage());
            return false;
        }
    }

    public void clickDynamicCategory(String categoryName) {
        CategoryPage.safeClick(By.xpath("//a[contains(text(),'" + categoryName + "')]"));
    }

    public void clickDynamicCategory2(String categoryName) {
        By categoryLocator = By.xpath("//a[@data-category='" + categoryName + "']");
        CategoryPage.safeClick(categoryLocator);
    }

    public boolean isPageLoaded(String expectedText) {
        return driver.getTitle().contains(expectedText);
    }

    public void clickPGPGenerativeAI() {
        By pgpGenerativeAILink = By.xpath("(//a[contains(@href,'pgp-generative-ai-machine-learning-certification')])[3]");
        CategoryPage.safeClick(pgpGenerativeAILink);
    }

    public void enterName(String name) {
        if (name != null && !name.isEmpty()) {
            nameInput.sendKeys(name);
        } else {
            System.out.println("Name is empty or null, skipping input.");
        }
    }

    public void enterEmail(String email) {
        if (email != null && !email.isEmpty()) {
            emailInput.sendKeys(email);
        } else {
            System.out.println("Email is empty or null, skipping input.");
        }
    }

    public void enterPhone(String phone) {
        if (phone != null && !phone.isEmpty()) {
            phoneInput.sendKeys(phone);
        } else {
            System.out.println("Phone is empty or null, skipping input.");
        }
    }

    public void enterEmail2(String email) {
        if (email != null && !email.isEmpty()) {
            emailInput2.sendKeys(email);
        } else {
            System.out.println("Email is empty or null, skipping input.");
        }
    }

    public void enterPhone2(String phone) {
        if (phone != null && !phone.isEmpty()) {
            phoneInput2.sendKeys(phone);
        } else {
            System.out.println("Phone is empty or null, skipping input.");
        }
    }

    public void clickAIMasters() {
        CategoryPage.safeClick(aiMastersLink); // ✅ uses overloaded safeClick(WebElement)
    }
}