package com.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.setUp.BaseSteps;

public class AskAQuestionPage extends BaseSteps {
	
	 public AskAQuestionPage(WebDriver driver) {
	        this.driver = driver;
	        // Missing this line is the root cause of the NullPointerException
	        PageFactory.initElements(driver, this);
	 }
	
@FindBy(xpath="//*[@id=\"nav\"]/div[1]/div[4]/ul/li[2]/a")
WebElement askButton;


@FindBy(xpath="//*[@id=\"nav\"]/div[1]/div[4]/ul/li[2]/a")
WebElement askText;




public void clickonAsk() {
	askButton.click();
}

public boolean isTextVisible(String TextValue) {
//  WebElement confirmationSection = driver.findElement(
//      org.openqa.selenium.By.xpath("//*[contains(text(),'" + confirmationText + "')]"));
//  scrollToElement(confirmationSection);
//  return confirmationSection.isDisplayed();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
  wait.until(ExpectedConditions.visibilityOf(askText));
 return wait.until(ExpectedConditions.visibilityOf(askText)).isDisplayed();
}
}
