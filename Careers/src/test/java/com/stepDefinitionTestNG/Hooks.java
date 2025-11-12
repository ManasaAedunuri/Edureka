package com.stepDefinitionTestNG;

import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseSteps {

    @Before
    public void beforeScenario() {
        BaseSteps.launchBrowser();
    }

    @After
    public void afterScenario() throws InterruptedException {
        BaseSteps.closeBrowser();
    }
}
