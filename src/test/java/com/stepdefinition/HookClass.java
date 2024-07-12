package com.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClassCucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * @author Karpaga Selvan M
 * @Date 03-10-2022
 * @see To handle the Before and After Scenarios
 *
 */
public class HookClass extends BaseClassCucumber {

	/**
	 * @throws IOException
	 * @see To handle browser launch before every Scenarios
	 */
	@Before
	public void beforeScenario() throws IOException {

		browserLaunch(getPropertyFileValue("browser"));
		getUrl(getPropertyFileValue("url"));
		maximize();

	}

	/**
	 * @throws IOException
	 * @see To Take Screenshot and Close the browser after every Scenarios
	 */
	@After
	public void afterScenario(Scenario scenario) throws IOException {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);

		scenario.attach(screenshotAs, "image/png", "Every after Scenario");

		driver.quit();

	}

}
