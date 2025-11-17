package com.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@SelectClasspathResource("Features/resources.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.stepDefinitionTestNG")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:Reports/cucumber-reports.html, json:Reports/json-report.json")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@resources or @ask")
public class TestRunnerJUnit {}