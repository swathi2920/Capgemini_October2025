package com.pandemic.cucumber.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/pandemic/cucumber/Features",
		glue = "com.pandemic.cucumber.StepDefination",
		plugin = {"pretty","junit:reports/junit_report.xml","html:reports/HTMLReports.html",
				"json:reports/json-report.json"}
	
)


public class PandemicRunner {

}