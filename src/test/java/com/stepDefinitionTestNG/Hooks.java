package com.stepDefinitionTestNG;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
public class Hooks extends BaseSteps{
	public static ExtentSparkReporter spark;
    public static ExtentReports extReports; //what to track on report (tester name,data etc...,)
    public static ExtentTest test;
    @BeforeAll                                  //before feature starts it should run
    public static void beforeAll() {
        spark = new ExtentSparkReporter(".\\target\\ExtentReport6.html");
        extReports = new ExtentReports();
        extReports.attachReporter(spark); 
    }
    @AfterAll       // after all scenarios done thne this method will run
    public static void afterAll() {
        extReports.flush();//generate report, flush acts as commit, if we dont write flush u cant get reports
    }
    @Before             //this code will run before every scenarios
    public void beforeScenario(Scenario scenario) {
       System.out.println("hi...");   
        test = extReports.createTest(scenario.getName()); //on the extent report create the scenario
        //BaseSteps.initializeProperties(".\\src\\test\\resources\\PropertiesFile\\login.properties");

 
     // Dynamically get the config path
         String configPath = System.getProperty("configPath", "src/test/resources/PropertiesFile/edureka_resources.properties");
         BaseSteps.initializeProperties(configPath);
 
       launchBrowser();    //fresh browser will launch,for every scenario we need a browser
    }
 
    @After          
    public void afterScenario() {
//        sleep(4000);
        driver.quit();
    }
 

}


