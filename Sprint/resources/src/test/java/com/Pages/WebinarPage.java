package com.Pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.setUp.BaseSteps;

public class WebinarPage extends BaseSteps {
    public WebinarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    @FindBy(xpath = "//*[@id=\"__next\"]/div/nav/div[4]/div[2]/button")
    WebElement resourcesMenu;

    @FindBy(linkText = "Webinars")
    WebElement webinarsSubMenu;

    // Search bar
    @FindBy(xpath="//*[@id=\"webinar_search_input\"]") // Update ID based on actual site
    WebElement searchBar;

    // Webinar title (dynamic locator used in method)
    // Register button (dynamic locator used in method)
    // Confirmation section (dynamic locator used in method)

    // Actions
    public void clickMenu() {
        resourcesMenu.click();
    }

    public void clickSubMenu() {
        webinarsSubMenu.click();
    }

    public void searchKeyword(String keyword) {
        searchBar.clear();
        searchBar.sendKeys(keyword);
        searchBar.sendKeys(Keys.ENTER);
        //searchBar.submit(); // or click a search button if present
    }

    public void selectWebinar(String webinarTitle) {
        WebElement webinarLink = driver.findElement(
            org.openqa.selenium.By.linkText(webinarTitle));
        webinarLink.click();
    }

    public void clickRegister(String buttonText) {
        WebElement registerButton = driver.findElement(
            org.openqa.selenium.By.xpath("//button[contains(text(),'" + buttonText + "')]"));
        scrollToElement(registerButton);
        registerButton.click();
    }

    public boolean isConfirmationVisible(String confirmationText) {
        WebElement confirmationSection = driver.findElement(
            org.openqa.selenium.By.xpath("//*[contains(text(),'" + confirmationText + "')]"));
        scrollToElement(confirmationSection);
        return confirmationSection.isDisplayed();
    }

    private void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}