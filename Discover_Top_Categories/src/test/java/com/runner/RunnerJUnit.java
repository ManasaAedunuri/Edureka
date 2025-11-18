package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions; // Use JUnit version here

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features/discover_top_categories.feature", // ✅ Correct path
    glue = {"com.stepDefinitionTestNG"}, //  Your step definitions package
    plugin = {
        "pretty",
        "html:reports/cucumber-reports.html",
        "json:reports/json-report.json",
        "junit:reports/junit_report.xml"
    }
)
public class RunnerJUnit {
}
