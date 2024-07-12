package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClassCucumber;

/**
 * @author Karpaga Selvan M
 * @Date 03-10-2022
 * @see Verifying Adactin Hotel Select Hotel Page
 *
 */
public class SelectHotelPage extends BaseClassCucumber {

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "radiobutton_0")
	private WebElement selctHotel;

	@FindBy(id = "continue")
	private WebElement searchBtn;

	@FindBy(className = "login_title")
	private WebElement txtSelectSuccessMSg;

	@FindBy(id = "radiobutton_span")
	private WebElement txtSelectErrorMsg;

	public WebElement getTxtSelectErrorMsg() {
		return txtSelectErrorMsg;
	}

	public WebElement getTxtSelectSuccessMSg() {
		return txtSelectSuccessMSg;
	}

	public WebElement getSelctHotel() {
		return selctHotel;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	/**
	 * @see Click common logic step for Select hotel Page
	 */
	public void clickSelectCommonStep() {

		click(getSearchBtn());

	}

	/**
	 * @see To perform Search on Search Hotel page After selecting all the Options
	 */
	// Verifying Adactin Hotel Select function after select the Hotel
	public void selectAndClick() {

		click(getSelctHotel());
		clickSelectCommonStep();

	}

	/**
	 * @see To perform Search on Search Hotel page without selecting any of the Options
	 */
	// Verifying Adactin Hotel Select function without selecting any of the Hotels
	public void selectWithoutClick() {

		clickSelectCommonStep();
	}

}
