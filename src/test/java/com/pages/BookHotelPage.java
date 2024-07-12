package com.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClassCucumber;

import io.cucumber.datatable.DataTable;

/**
 * @author Karpaga Selvan M
 * @Date 03-10-2022
 * @see Verifying Adactin Book Hotel Page
 *
 */
public class BookHotelPage extends BaseClassCucumber {

	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	private WebElement firstName;

	@FindBy(id = "last_name")
	private WebElement lastName;

	@FindBy(id = "address")
	private WebElement addressData;

	@FindBy(id = "cc_num")
	private WebElement cardNo;

	@FindBy(id = "cc_type")
	private WebElement cardType;

	@FindBy(id = "cc_exp_month")
	private WebElement expMonth;

	@FindBy(id = "cc_exp_year")
	private WebElement expYear;

	@FindBy(id = "cc_cvv")
	private WebElement cvvNum;

	@FindBy(id = "book_now")
	private WebElement btnBookNow;

	@FindBy(xpath = "(//td[@class=\"login_title\"])[2]")
	private WebElement txtbookSuccessMsg;

	@FindBy(id = "first_name_span")
	private WebElement txtErrorMsgFirstName;

	@FindBy(id = "last_name_span")
	private WebElement txtErrorMsgLastName;

	@FindBy(id = "address_span")
	private WebElement txtErrorMsgAddress;

	@FindBy(id = "cc_num_span")
	private WebElement txtErrorMsgCardNo;

	@FindBy(id = "cc_type_span")
	private WebElement txtErrorMsgCardType;

	@FindBy(id = "cc_expiry_span")
	private WebElement txtErrorMsgCardExp;

	@FindBy(id = "cc_cvv_span")
	private WebElement txtErrorMsgCvvNum;

	public WebElement getTxtErrorMsgFirstName() {
		return txtErrorMsgFirstName;
	}

	public WebElement getTxtErrorMsgLastName() {
		return txtErrorMsgLastName;
	}

	public WebElement getTxtErrorMsgAddress() {
		return txtErrorMsgAddress;
	}

	public WebElement getTxtErrorMsgCardNo() {
		return txtErrorMsgCardNo;
	}

	public WebElement getTxtErrorMsgCardType() {
		return txtErrorMsgCardType;
	}

	public WebElement getTxtErrorMsgCardExp() {
		return txtErrorMsgCardExp;
	}

	public WebElement getTxtErrorMsgCvvNum() {
		return txtErrorMsgCvvNum;
	}

	public WebElement getTxtbookSuccessMsg() {
		return txtbookSuccessMsg;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddressData() {
		return addressData;
	}

	public WebElement getCardNo() {
		return cardNo;
	}

	public WebElement getCardType() {
		return cardType;
	}

	public WebElement getExpMonth() {
		return expMonth;
	}

	public WebElement getExpYear() {
		return expYear;
	}

	public WebElement getCvvNum() {
		return cvvNum;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param dataTable
	 * @see To perform Book now after Selecting all the options on Book Hotel Page
	 */
	// Verifying Adactin Hotel Book function after select all the fields
	public void bookWithAllSelected(String firstName, String lastName, String address, DataTable dataTable) {

		sendKeys(getFirstName(), firstName);
		sendKeys(getLastName(), lastName);
		sendKeys(getAddressData(), address);

		List<Map<String, String>> emp = dataTable.asMaps();
		Map<String, String> row = emp.get(0);
		sendKeys(getCardNo(), row.get("creditCardNum"));
		selectText(getCardType(), row.get("cardType"));
		selectText(getExpMonth(), row.get("expMonth"));
		selectText(getExpYear(), row.get("expYear"));
		sendKeys(getCvvNum(), row.get("cvvNum"));

		click(getBtnBookNow());

	}

	/**
	 * @see To perform Book now without Selecting any of the options on Book Hotel Page
	 */
	// Verifying Adactin Hotel Book function without selecting any of the fields
	public void bookingWithoutSelect() {

		click(getBtnBookNow());

	}

}
