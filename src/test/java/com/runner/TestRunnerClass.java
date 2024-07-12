package com.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClassCucumber;
import com.reporting.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

/**
 * @author Karpaga Selvan M
 * @Date 03-10-2022
 * @see To execute the Project
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags = "", stepNotifications = true, publish = true, plugin = { "pretty",
		"json:\\target\\Output.json" }, monochrome = true, snippets = SnippetType.CAMELCASE, dryRun = false, glue = "com.stepdefinition", features = "src\\test\\resources\\Feature")
public class TestRunnerClass extends BaseClassCucumber {

	/**
	 * @throws IOException
	 * @see To call the method from Reporting Class to generate JVM Report
	 */
	@AfterClass
	public static void afterClass() throws IOException {

		Reporting.generatesJvmReports(getPropertyFileValue("jsonpath"));

	}

}
