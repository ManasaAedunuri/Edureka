//package com.stepDefinitionTestNG;
//
//import com.setup.BaseSteps;
//import io.cucumber.java.Before;
//import io.cucumber.java.After;
//
//public class Hooks {
//
//    @Before
//    public void setUp() {
//        if (BaseSteps.driver == null) { // Initialize only once
//            BaseSteps.launchBrowser();
//        }
//    }
//
//    @After
//    public void tearDown() {
//        if (BaseSteps.driver != null) {
//            BaseSteps.driver.quit();
//            BaseSteps.driver = null; // Reset for next run
//        }
//    }
//}
