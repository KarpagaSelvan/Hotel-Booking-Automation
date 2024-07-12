package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClassCucumber;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * @author Karpaga Selvan M
 * @Date 03-10-2022
 * @see Class contains Step Definitions for Cancel Booking Page
 *
 */
public class TC5_CancelBookingStep extends BaseClassCucumber {

	PageObjectManager manager = new PageObjectManager();

	/**
	 * @see Cancellation of the generated Order id
	 */
	@Then("User should Cancel the generated Order id")
	public void userShouldCancelTheGeneratedOrderId() {
		String generatedOrderId = manager.getBookingConfirmationPage().returnTheOrderId();
		manager.getCancelBookingPage().cancelTheGenerated(generatedOrderId);

	}

	/**
	 * @param string
	 * @see Verification of the success message after the Cancellation of Order Id
	 */
	@Then("User should verify the success message after the cancellation of Order id {string}")
	public void userShouldVerifyTheSuccessMessageAfterTheCancellationOfOrderId(String expCancelBookingMSg) {
		Assert.assertEquals("Verify the Success Message", expCancelBookingMSg,
				getText(manager.getCancelBookingPage().getTxtSuccessMsgCancel()));

	}

	/**
	 * @param string
	 * @see Cancellation of the existing Order id
	 */
	@Then("User should cancel the existing Order id {string}")
	public void userShouldCancelTheExistingOrderId(String orderID) {

		manager.getCancelBookingPage().cancelTheGenerated(orderID);

	}

}
