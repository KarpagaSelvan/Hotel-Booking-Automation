package com.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import com.base.BaseClassCucumber;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author Karpaga Selvan M
 * @Date 03-10-2022
 * @see Class contains Step Definitions for Search Hotel Page
 *
 */
public class TC2_SearchHotelStep extends BaseClassCucumber {

	PageObjectManager manager = new PageObjectManager();

	/**
	 * @param location
	 * @param hotels
	 * @param roomType
	 * @param noOfRooms
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsPerRoom
	 * @param childrenPerRoom
	 * @see Search hotel function after selecting all the Options
	 */

	@Then("User should perform Search after selecting all the Options {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldPerformSearchAfterSelectingAllTheOptionsAnd(String location, String hotels, String roomType,
			String noOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom, String childrenPerRoom) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		manager.getSearchHotelPage().searchWithAll(location, hotels, roomType, noOfRooms, checkInDate, checkOutDate,
				adultsPerRoom, childrenPerRoom);

	}

	/**
	 * 
	 * @param expWelcomeMsg
	 * @see Verification of the success message after perform Search with all Selected Options
	 * 
	 */

	@Then("User should verify the success message after perform Search {string}")
	public void userShouldVerifyTheSuccessMessageAfterPerformSearch(String expWelcomeMsg) {

		Assert.assertEquals("Verify the Success Msg", expWelcomeMsg,
				getText(manager.getSelectHotelPage().getTxtSelectSuccessMSg()));

	}

	/**
	 * @param location
	 * @param noOfRooms
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsPerRoom
	 * @see Search Hotel function after Selecting only the mandatory options
	 * 
	 */

	@Then("User should perform Search after selecting only mandatory Options {string}, {string},{string},{string} and {string}")
	public void userShouldPerformSearchAfterSelectingOnlyMandatoryOptionsAnd(String location, String noOfRooms,
			String checkInDate, String checkOutDate, String adultsPerRoom) {
		manager.getSearchHotelPage().selectWithMandatory(location, noOfRooms, checkInDate, checkOutDate, adultsPerRoom);

	}

	/**
	 * @param expCheckInMsg
	 * @param expChecOutkMsg
	 * @see Verifying the error msg on Search Hotel Page after enter higher check-In date and lower check-Out date
	 * 
	 */

	@Then("User should verify the error message after enter higher check-In date and lower check-Out date {string},{string}")
	public void userShouldVerifyTheErrorMessageAfterEnterHigherCheckInDateAndLowerCheckOutDate(String expCheckInMsg,
			String expChecOutkMsg) {

		Assert.assertTrue("Verify the Check In Error Msg",
				getText(manager.getSearchHotelPage().getTxtCheckinErrorMsg()).contains(expCheckInMsg));
		Assert.assertTrue("Verify the Check Out Error Msg",
				getText(manager.getSearchHotelPage().getTxtCheckOutErrorMsg()).contains(expChecOutkMsg));

	}

	/**
	 * @see Verifying the Search function on Search Hotel Page after pefrom the search without selecting any of the Options
	 */

	@Then("User should perform Search without selecting any of the Options")
	public void userShouldPerformSearchWithoutSelectingAnyOfTheOptions() {

		manager.getSearchHotelPage().searchWithoutSelectOptions();
	}

	/**
	 * @param locationErrorMsg
	 * @see Verifying the error msg on Search Hotel Page after perform Search without selecting any of the Options
	 */

	@Then("User should verify the error message after perform Search without selecting any of the Options {string}")
	public void userShouldVerifyTheErrorMessageAfterPerformSearchWithoutSelectingAnyOfTheOptions(
			String locationErrorMsg) {

		Assert.assertTrue("Verify the Error Msg",
				getText(manager.getSearchHotelPage().getTxtLocationErrorMsg()).contains(locationErrorMsg));

	}

}
