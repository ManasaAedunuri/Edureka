package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.BaseSteps;
import com.setup.Reports;

public class AskAQuestionPage extends BaseSteps 
{
	 static ExtentTest test;
	
	 public AskAQuestionPage(WebDriver driver, ExtentTest test) {
	        this.driver = driver;
	        this.test = test;
	        PageFactory.initElements(driver, this);
	 }
	
@FindBy(xpath="//*[@id=\"nav\"]/div[1]/div[4]/ul/li[2]/a")
WebElement askButton;


@FindBy(xpath="//*[@id=\"nav\"]/div[1]/div[4]/ul/li[2]/a")
WebElement askText;




public void clickonAsk() {
	try {
	askButton.click();
	 Reports.generateReport(driver, test, Status.PASS, "clicked on ask.");
	}catch (Exception e) {
		Reports.generateReport(driver, test, Status.FAIL, "Failed to select suggestion: " + e.getMessage());
	}
}

public boolean isTextVisible(String TextValue) {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
  wait.until(ExpectedConditions.visibilityOf(askText));
  try {
  Reports.generateReport(driver, test, Status.PASS, "text is visible.");
}catch (Exception e) {
	Reports.generateReport(driver, test, Status.FAIL, "Failed to select suggestion: " + e.getMessage());
}
 return wait.until(ExpectedConditions.visibilityOf(askText)).isDisplayed();
}
}
