package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClassCucumber;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * @author Karpaga Selvan M
 * @Date 03-10-2022
 * @see Class contains Common Step for verifying the login success message
 *
 */
public class CommonStep extends BaseClassCucumber {

	PageObjectManager manager = new PageObjectManager();

	/**
	 * @param expLoginWelcomeMsg
	 * @see Verification of the success message after performing the login
	 */
	@Then("User should verify after Login success message {string}")
	public void userShouldVerifyAfterLoginSuccessMessage(String expLoginWelcomeMsg) {

		Assert.assertEquals("Verify the Success Message", expLoginWelcomeMsg,
				getAttributeValue(manager.getSearchHotelPage().getTxtWelcomeMsg()));

	}

}
