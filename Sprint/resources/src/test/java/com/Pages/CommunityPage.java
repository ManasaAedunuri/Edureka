package com.Pages;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunityPage 
{
	WebDriver driver;


	@FindBy(xpath="//*[@id=\"__next\"]/div/nav/div[4]/div[2]/button")
	WebElement resource;
	
	@FindBy(xpath = "//*[@id=\"__next\"]/div/nav/div[4]/div[2]/div/a[3]")
	WebElement communitySubMenu;

	// ====== Community Page Elements ======
	@FindBy(xpath="//*[@id=\"nav\"]/div[1]/div[3]/div/form/div/input")
	WebElement searchBox;
	
	@FindBy(xpath = "/html/body/main/div[2]/div[2]/h1")
	WebElement joinButton;

	public CommunityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 
	public void clickResource() {
		resource.click();
	}

    public void clickSubMenu() {
    
        communitySubMenu.click();
    }

    public void searchCommunity(String name) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchBox.clear();
        searchBox.sendKeys(name);
        searchBox.sendKeys(Keys.ENTER);
    }

    
    	public boolean isCommunityVisible(String communityText) {
//          WebElement confirmationSection = driver.findElement(
//              org.openqa.selenium.By.xpath("//*[contains(text(),'" + confirmationText + "')]"));
//          scrollToElement(confirmationSection);
//          return confirmationSection.isDisplayed();
      	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
          wait.until(ExpectedConditions.visibilityOf(joinButton));
         return wait.until(ExpectedConditions.visibilityOf(joinButton)).isDisplayed();
      }
    }




