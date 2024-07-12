package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClassCucumber;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * @author Karpaga Selvan M
 * @Date 03-10-2022
 * @see Class contains Step Definitions for Select Hotel Page
 *
 */

public class TC3_SelectHotelStep extends BaseClassCucumber {

	PageObjectManager manager = new PageObjectManager();

	/**
	 * @see Select Hotel function after Select the Hotel
	 */

	@Then("User should Select Hotel")
	public void userShouldSelectHotel() {

		manager.getSelectHotelPage().selectAndClick();

	}

	/**
	 * @param expSelectSuccessMsg
	 * @see Verification of the success message after Select the Hotel
	 * 
	 */

	@Then("User should verify the success message after select the Hotel {string}")
	public void userShouldVerifyTheSuccessMessageAfterSelectTheHotel(String expSelectSuccessMsg) {

		Assert.assertEquals("Verify the Success Msg", expSelectSuccessMsg,
				getText(manager.getBookHotelPage().getTxtbookSuccessMsg()));

	}

	/**
	 * 
	 * @see Select Hotel function after perfoming Continue without Select the Hotel
	 * 
	 */

	@Then("User should perform Continue without selecting any of the Hotels")
	public void userShouldPerformContinueWithoutSelectingAnyOfTheHotels() {

		manager.getSelectHotelPage().selectWithoutClick();
	}

	/**
	 * @param expSelectErrorMsg
	 * @see Verification of the error message after performing Continue without Selecting any of the Hotels
	 * 
	 */

	@Then("User should verify the error message after perform Continue without selecting any of the Hotels {string}")
	public void userShouldVerifyTheErrorMessageAfterPerformContinueWithoutSelectingAnyOfTheHotels(
			String expSelectErrorMsg) {

		Assert.assertTrue("Verify the Error Msg",
				getText(manager.getSelectHotelPage().getTxtSelectErrorMsg()).contains(expSelectErrorMsg));

	}

}
