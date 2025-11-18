package com.runner;
 
import org.testng.annotations.DataProvider;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
 
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
 
		dryRun=false,
 
				features = {"src/test/resources/Features/trending_course.feature"},	 glue = {"com.stepDefinitionTestNG"},
 
				plugin = {"pretty:reports/prettyReport.html","html:reports/HTMLReports.html",
						"json:reports/json-report.json",
						"junit:reports/junit_report.xml","pretty", "html:target/cucumber-reports.html"},
				  tags = "@first or @second or @outline1 or @outline2 or @third"
 
			)
 
 
 
public class TestRunnerParallel extends AbstractTestNGCucumberTests{
 
	@DataProvider(parallel=true)  // parallel run
 
	public Object[][] scenarios()
 
	{
 
		return super.scenarios();
 
	}
 
}