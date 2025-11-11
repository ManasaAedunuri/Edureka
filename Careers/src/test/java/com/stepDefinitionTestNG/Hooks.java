package com.stepDefinitionTestNG;

import org.openqa.selenium.WebDriver;

import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseSteps {

	 //public static WebDriver driver;

	 @Before
	    public void beforeScenario() {
	        BaseSteps.launchBrowser();
	    }

	    @After
	    public void afterScenario() throws InterruptedException {
	        BaseSteps.closeBrowser();
	    }

}
