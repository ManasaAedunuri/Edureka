package com.runner;
 
import static io.cucumber.junit.platform.engine.Constants.*;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
 
@Suite
@SelectClasspathResource("Features/trending_course.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.stepDefinitionTestNG")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:Reports/cucumber-reports.html, json:Reports/json-report.json")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@second")
public class TestRunnerJUnit {}