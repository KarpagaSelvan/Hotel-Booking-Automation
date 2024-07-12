package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClassCucumber;
import com.pagemanager.PageObjectManager;
import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.Then;

/**
 * @author Karpaga Selvan M
 * @Date 03-10-2022
 * @see Class contains Step Definitions for Book Hotel Page
 * 
 */
public class TC4_BookHotelStep extends BaseClassCucumber {

	PageObjectManager manager = new PageObjectManager();

	/**
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param emp
	 * @see Book Hotel function after Selecting all the Options
	 * 
	 */
	@Then("User should select all the fields {string},{string} and {string}")
	public void userShouldSelectAllTheFieldsAnd(String firstName, String lastName, String address, DataTable emp) {

		manager.getBookHotelPage().bookWithAllSelected(firstName, lastName, address, emp);

	}

	/**
	 * @param expSuccessMSg
	 * @see Verification of the success message of the Book Hotel function after Selecting all the Options
	 */
	@Then("User should verify the success message after select all the fields {string}")
	public void userShouldVerifyTheSuccessMessageAfterSelectAllTheFields(String expSuccessMSg) {

		Assert.assertEquals("Verify the Success Msg", expSuccessMSg,
				getText(manager.getBookingConfirmationPage().getTxtBookConfSuccMsg()));

	}

	/**
	 * @see Book Hotel function without Selecting any of the Options
	 */
	@Then("User should perform Book Now without selecting any of the fields")
	public void userShouldPerformBookNowWithoutSelectingAnyOfTheFields() {

		manager.getBookHotelPage().bookingWithoutSelect();

	}

	/**
	 * @param expFstNameErrorMsg
	 * @param expLastNameErrorMsg
	 * @param expAddressNameErrorMsg
	 * @param expCardNumErrorMsg
	 * @param expCardTypeErrorMsg
	 * @param expCardYearErrorMsg
	 * @param expCardCvvErrorMsg
	 * @see Verification of the error message of the Book Hotel function without Selecting any of the Options
	 */
	@Then("User should verify the error message after perform Book Now without selecting any of the fields {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyTheErrorMessageAfterPerformBookNowWithoutSelectingAnyOfTheFieldsAnd(
			String expFstNameErrorMsg, String expLastNameErrorMsg, String expAddressNameErrorMsg,
			String expCardNumErrorMsg, String expCardTypeErrorMsg, String expCardYearErrorMsg,
			String expCardCvvErrorMsg) {

		Assert.assertTrue("Verify the Error Msg",
				getText(manager.getBookHotelPage().getTxtErrorMsgFirstName()).contains(expFstNameErrorMsg));
		Assert.assertTrue("Verify the Error Msg",
				getText(manager.getBookHotelPage().getTxtErrorMsgLastName()).contains(expLastNameErrorMsg));
		Assert.assertTrue("Verify the Error Msg",
				getText(manager.getBookHotelPage().getTxtErrorMsgAddress()).contains(expAddressNameErrorMsg));
		Assert.assertTrue("Verify the Error Msg",
				getText(manager.getBookHotelPage().getTxtErrorMsgCardNo()).contains(expCardNumErrorMsg));
		Assert.assertTrue("Verify the Error Msg",
				getText(manager.getBookHotelPage().getTxtErrorMsgCardType()).contains(expCardTypeErrorMsg));
		Assert.assertTrue("Verify the Error Msg",
				getText(manager.getBookHotelPage().getTxtErrorMsgCardExp()).contains(expCardYearErrorMsg));
		Assert.assertTrue("Verify the Error Msg",
				getText(manager.getBookHotelPage().getTxtErrorMsgCvvNum()).contains(expCardCvvErrorMsg));

	}

}
