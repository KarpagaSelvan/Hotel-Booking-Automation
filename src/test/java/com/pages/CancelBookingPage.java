package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClassCucumber;

/**
 * @author Karpaga Selvan M
 * @Date 03-10-2022
 * @see Verifying Adactin Hotel Cancel Booking Page
 *
 */
public class CancelBookingPage extends BaseClassCucumber {

	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "order_id_text")
	private WebElement txtOrderId;

	@FindBy(id = "search_hotel_id")
	private WebElement btnGo;

	@FindBy(id = "btn_id_654766")
	private WebElement btnOrderId;

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement txtBookingItinerary;

	@FindBy(xpath = "//label[@id=\"search_result_error\"]")
	private WebElement txtSuccessMsgCancel;

	@FindBy(xpath = "//input[contains(@id,'btn_id_')]")
	private WebElement btnCancel;

	public WebElement getTxtSuccessMsgCancel() {
		return txtSuccessMsgCancel;
	}

	public WebElement getTxtBookingItinerary() {
		return txtBookingItinerary;
	}

	public WebElement getBtnOrderId() {
		return btnOrderId;
	}

	public WebElement getTxtOrderId() {
		return txtOrderId;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	/**
	 * @param orderID
	 * @see To Cancel the Order Id on Adactin Hotel Cancel Booking Page
	 */
	// Verifying Adactin Hotel Cancel Booking functionality with generated Order id
	// Verifying Adactin Hotel Cancel Booking functionality with existing Order id
	public void cancelTheGenerated(String orderID) {

		click(getTxtBookingItinerary());

		sendKeys(getTxtOrderId(), orderID);

		click(getBtnGo());

		click(getBtnCancel());

		alertAcceptance();

	}

}
