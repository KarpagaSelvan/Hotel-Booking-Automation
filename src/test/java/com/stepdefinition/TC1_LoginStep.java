package com.stepdefinition;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.base.BaseClassCucumber;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author Karpaga Selvan M
 * @Date 03-10-2022
 * @see Class contains Step Definitions for Login Page
 *
 */
public class TC1_LoginStep extends BaseClassCucumber {

	PageObjectManager manager = new PageObjectManager();

	WebDriver driver;

	/**
	 * @throws IOException
	 * @see Launching the Browser and Adactin Hotel Url
	 */
	@Given("User is on the Adactin page")
	public void userIsOnTheAdactinPage() throws IOException {

	}

	/**
	 * @param userName
	 * @param password
	 * @see Login function using login button
	 */
	@When("User should perform Login {string}, {string}")
	public void userShouldPerformLogin(String userName, String password) {

		manager.getLoginPage().login(userName, password);

	}

	/**
	 * @param userName
	 * @param password
	 * @throws AWTException
	 * @see Login function using Enter Key
	 */
	@When("User should perform Login {string}, {string} with Enter key")
	public void userShouldPerformLoginWithEnterKey(String userName, String password) throws AWTException {

		manager.getLoginPage().loginWithEnterKey(userName, password);

	}

	/**
	 * @param expLoginErrorMsg
	 * @see Verification of the error after login with invalid credentials
	 */
	@Then("User should verify after Login with invalid credentials error message {string}")
	public void userShouldVerifyAfterLoginWithInvalidCredentialsErrorMessage(String expLoginErrorMsg) {

		Assert.assertTrue("Verify the Error Msg after login with Invalid Credentials",
				getText(manager.getLoginPage().getTextLoginErrorMsg()).contains(expLoginErrorMsg));

	}

}
