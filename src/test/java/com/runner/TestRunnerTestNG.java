package com.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
    features = "src/test/resources/Features/resources.feature",
    glue = {"com.stepDefinitionTestNG"},
    plugin = {"pretty", "html:Reports/cucumber-reports.html",
 		   "json:reports/json-report.json",
 		   "junit:reports/junit_report.xml",
    }//tags="@searchCourses"
    //tags="@resources or @ask" 
    //tags="@ask"
    //tags="@community"
    //tags="@webinar or @ask"
    //tags="@webinar or @community or @resources or @searchCourses or @ask"
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {}
