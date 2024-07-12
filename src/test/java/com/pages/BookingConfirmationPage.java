package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClassCucumber;
import com.pagemanager.PageObjectManager;

/**
 * @author Karpaga Selvan M
 * @Date 03-10-2022
 * @see Verifying Adactin Hotel Booking Confirmations Page
 *
 */
public class BookingConfirmationPage extends BaseClassCucumber {

	PageObjectManager manager = new PageObjectManager();

	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "order_no")
	private WebElement orderId;

	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	private WebElement txtBookConfSuccMsg;

	public PageObjectManager getManager() {
		return manager;
	}

	public WebElement getTxtBookConfSuccMsg() {
		return txtBookConfSuccMsg;
	}

	public WebElement getOrderId() {
		return orderId;
	}

	/**
	 * @return String
	 * @see To return the generated Order Id from Adactin Hotel Booking Confirmation Page
	 */
	public String returnTheOrderId() {

		String value = getAttributeValue(getOrderId());
		return value;

	}

}
