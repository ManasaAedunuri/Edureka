package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class KnowMorePage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/div[1]/div/div/a")
    private WebElement clickKnowMore;

    public KnowMorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnKnowMore() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickKnowMore));
        clickKnowMore.click();
        Thread.sleep(3000);
    }
}