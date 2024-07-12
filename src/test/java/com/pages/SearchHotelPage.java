package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClassCucumber;

/**
 * @author Karpaga Selvan M
 * @Date 03-10-2022
 * @see Verifying Adactin Hotel Search Hotel Page
 */
public class SearchHotelPage extends BaseClassCucumber {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement dDnLocation;

	@FindBy(id = "hotels")
	private WebElement dDnHotels;

	@FindBy(id = "room_type")
	private WebElement dDnRoomType;

	@FindBy(name = "room_nos")
	private WebElement dDnRoomNo;

	@FindBy(id = "datepick_in")
	private WebElement dateCheckIn;

	@FindBy(id = "datepick_out")
	private WebElement dateCheckOut;

	@FindBy(id = "adult_room")
	private WebElement adultsPerRoom;

	@FindBy(id = "child_room")
	private WebElement childrenPerRoom;

	@FindBy(id = "Submit")
	private WebElement btnSearch;

	@FindBy(id = "username_show")
	private WebElement txtWelcomeMsg;

	@FindBy(id = "checkin_span")
	private WebElement txtCheckinErrorMsg;

	@FindBy(id = "checkout_span")
	private WebElement txtCheckOutErrorMsg;

	@FindBy(id = "location_span")
	private WebElement txtLocationErrorMsg;

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement btnBookingItinerary;

	public WebElement getBtnBookingItinerary() {
		return btnBookingItinerary;
	}

	public WebElement getTxtLocationErrorMsg() {
		return txtLocationErrorMsg;
	}

	public WebElement getTxtCheckinErrorMsg() {
		return txtCheckinErrorMsg;
	}

	public WebElement getTxtCheckOutErrorMsg() {
		return txtCheckOutErrorMsg;
	}

	public WebElement getTxtWelcomeMsg() {
		return txtWelcomeMsg;
	}

	public WebElement getdDnLocation() {
		return dDnLocation;
	}

	public WebElement getdDnHotels() {
		return dDnHotels;
	}

	public WebElement getdDnRoomType() {
		return dDnRoomType;
	}

	public WebElement getdDnRoomNo() {
		return dDnRoomNo;
	}

	public WebElement getDateCheckIn() {
		return dateCheckIn;
	}

	public WebElement getDateCheckOut() {
		return dateCheckOut;
	}

	public WebElement getAdultsPerRoom() {
		return adultsPerRoom;
	}

	public WebElement getChildrenPerRoom() {
		return childrenPerRoom;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	/**
	 * @see Reusable action for click the Search button on Adactin Hotel Search Hotel Page
	 */
	public void clickSearchCommonStep() {

		click(getBtnSearch());
	}

	// Verifying Adactin Hotel Search function after selecting all Options
	// Verifying Adactin Hotel Search function after enter higher Checkin date and
	// lower Checkout date

	/**
	 * @param location
	 * @param hotels
	 * @param roomType
	 * @param noOfRooms
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsPerRoom
	 * @param childrenPerRoom
	 * @see To perform Search on Search Hotel page after selecting all the fields
	 */
	public void searchWithAll(String location, String hotels, String roomType, String noOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom, String childrenPerRoom) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		selectText(getdDnLocation(), location);
		selectText(getdDnHotels(), hotels);
		selectText(getdDnRoomType(), roomType);
		selectText(getdDnRoomNo(), noOfRooms);
		clearTextOnTextBox(getDateCheckIn());
		sendKeys(getDateCheckIn(), checkInDate);
		clearTextOnTextBox(getDateCheckOut());
		sendKeys(getDateCheckOut(), checkOutDate);
		selectText(getAdultsPerRoom(), adultsPerRoom);
		selectText(getChildrenPerRoom(), childrenPerRoom);
		clickSearchCommonStep();
	}

	/**
	 * @param location
	 * @param noOfRooms
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsPerRoom
	 * @see To perform Search on Search Hotel page after selecting only mandatory fields
	 */
	// Verifying Adactin Hotel Search function after selecting only mandatory
	// Options

	public void selectWithMandatory(String location, String noOfRooms, String checkInDate, String checkOutDate,
			String adultsPerRoom) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		selectText(getdDnLocation(), location);
		selectText(getdDnRoomNo(), noOfRooms);
		clearTextOnTextBox(getDateCheckIn());
		sendKeys(getDateCheckIn(), checkInDate);
		clearTextOnTextBox(getDateCheckOut());
		sendKeys(getDateCheckOut(), checkOutDate);
		selectText(getAdultsPerRoom(), adultsPerRoom);
		clickSearchCommonStep();

	}

	/**
	 * @see To perform Search on Search Hotel page without selecting any of the Options
	 */
	public void searchWithoutSelectOptions() {

		click(getBtnSearch());
	}

}