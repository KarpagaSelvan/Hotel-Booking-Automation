package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClassCucumber;

/**
 * @author Karpaga Selvan M
 * @Date 03-10-2022
 * @see Verifying Adactin hotel Login Page
 */
public class LoginPage extends BaseClassCucumber {

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtUserName;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(id = "login")
	private WebElement btnLogin;

	@FindBy(className = "auth_error")
	private WebElement textLoginErrorMsg;

	public WebElement getTextLoginErrorMsg() {
		return textLoginErrorMsg;
	}

	public WebElement getTxtUserName() {
		return txtUserName; // <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
							// -->
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	/**
	 * @param userName
	 * @param password
	 * @see Reusable actions for login function
	 */
	public void loginCommonSteps(String userName, String password) {

		sendKeys(getTxtUserName(), userName);
		sendKeys(getTxtPassword(), password);

	}

	/**
	 * @see Reusable action for Click the login button function
	 */
	public void clickCommonStep() {
		click(getBtnLogin());
	}

	/**
	 * @param userName
	 * @param password
	 * @see To perform login by Click the login button on Adactin hotel login page
	 */
	// 1.with valid credentials
	// 3.with Invalid credentials
	public void login(String userName, String password) {

		loginCommonSteps(userName, password);
		clickCommonStep();

	}

	/**
	 * @param userName
	 * @param password
	 * @throws AWTException
	 * @see To perform login by using Enter key on Adactin hotel page
	 */
	public void loginWithEnterKey(String userName, String password) throws AWTException {

		loginCommonSteps(userName, password);

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
