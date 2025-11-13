package com.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;

public class CommunityPage 
{
	WebDriver driver;


	@FindBy(xpath="//*[@id=\"__next\"]/div/nav/div[4]/div[2]/button")
	WebElement resource;
	
	@FindBy(xpath = "//*[@id=\"__next\"]/div/nav/div[4]/div[2]/div/a[3]")
	WebElement communitySubMenu;

	// ====== Community Page Elements ======
	@FindBy(id = "search-input")
	WebElement searchBox;

	@FindBy(xpath = "//button[text()='Join']")
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
        searchBox.clear();
        searchBox.sendKeys(name);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void joinCommunity() {
        joinButton.click();
    }

}


