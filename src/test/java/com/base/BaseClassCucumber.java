package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Karpaga Selvan M
 * @Date 03-10-2022
 * @see Used to maintain the reusable methods
 */
public class BaseClassCucumber {

	public static WebDriver driver;
	String attribute = " ";

	/**
	 * @param key
	 * @return String
	 * @throws IOException
	 * @throws IOException
	 * @see Used to get the values form Property file
	 * 
	 */

	public static String getPropertyFileValue(String key) throws IOException, IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir") + "\\Config\\Config.properties"));

		String value = (String) properties.get(key);
		return value;

	}

	/**
	 * @param element
	 * @see Explicity Waits for an element used to handle No Such Element Exception
	 */
	public void elementVisibility(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * @param browserType
	 * @see Used to launch the browser based on the browser type
	 */

	public static void browserLaunch(String browserType) {

		switch (browserType) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;

		case "firefox":

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			break;

		case "ie":

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

			break;

		case "edge":

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			break;
		default:
			break;
		}

	}

	/**
	 * @param element
	 * @param text
	 * @see Used to enter the values on Textbox of Webpage
	 */

	public void sendKeys(WebElement element, String text) {
		elementVisibility(element);
		element.sendKeys(text);

	}

	/**
	 * @see Used for ChromeDriver Setup for a Browser
	 */
	public static void managerSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	/**
	 * @param url
	 * @see Used to get Url to launch the Webpage
	 */
	public static void getUrl(String url) {
		driver.get(url);

	}

	/**
	 * @see Used to maximize the browser Window
	 */
	public static void maximize() {
		driver.manage().window().maximize();
	}

	// public void sendKeys(WebElement element, String text) {
	// elementVisibility(element);
	// element.sendKeys(text);}

	/**
	 * @param element
	 * @param data
	 * @see Used to enter the values on Textbox by using Java Script
	 */
	public void sendKeysJs(WebElement element, String data) {

		JavascriptExecutor script = (JavascriptExecutor) driver;
		script.executeScript("arguments[0].setAttribute('value','" + data + "')", element);

	}

	/**
	 * @return String
	 * @see Used to get the title from Webpage
	 */
	public String getTitle() {

		String title = driver.getTitle();
		return title;

	}

	/**
	 * @param element
	 * @see Used to click an element on Webpage
	 */
	public void click(WebElement element) {
		elementVisibility(element);
		element.click();

	}

	/**
	 * @param data
	 * @return WebElement
	 * @see Used to locate a Webelement by using id attribute
	 */

	public WebElement getLocatorById(String data) {
		WebElement element = driver.findElement(By.id(data));
		return element;
	}

	/**
	 * @param element
	 * @param data
	 * @return WebElement
	 * @see Used to locate a Webelement by using name attribute
	 */

	private WebElement getLocatorByName(WebElement element, String data) {
		elementVisibility(element);
		driver.findElement(By.name(data));
		return element;
	}

	/**
	 * @param element
	 * @param data
	 * @return WebElement
	 * @see Used to locate a Webelement by using class attribute
	 */
	private WebElement getLocatorByClassName(WebElement element, String data) {
		elementVisibility(element);
		WebElement webElement = driver.findElement(By.xpath(data));
		return webElement;

	}

	/**
	 * @see Used to close the current browser Window
	 */

	public void closeWindow() {
		driver.close();
	}

	/**
	 * @see Used to close all the browser Windows
	 */

	public void quitWindow() {
		driver.quit();
	}

	/**
	 * @param element
	 * @return String
	 * @see used to fetch a text of an element from Webpage
	 */

	public String getText(WebElement element) {
		elementVisibility(element);
		String text = element.getText();

		return text;

	}

	/**
	 * @see Used to get a current Url from browser
	 */

	public String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	/**
	 * @param element
	 * @param data
	 * @return String
	 * @see Used to get an attribute value from Webpage
	 */
	public String getAttributeValue(WebElement element, String data) {
		elementVisibility(element);
		String string = element.getAttribute(data);
		return string;
	}

	/**
	 * @param element
	 * @param text
	 * @see Used to select the values on dropdown by visible text
	 */
	public void selectText(WebElement element, String text) {
		Select se = new Select(element);
		se.selectByVisibleText(text);
	}

	/**
	 * @param element
	 * @return String
	 * @see Used to get attribute value of an element from Webpage
	 */
	public String getAttributeValue(WebElement element) {
		elementVisibility(element);
		String attribute = element.getAttribute("value");//// input[@value="LB3K232Z37"]
		return attribute;

	}// in this case attribute name is constant "value". Hence no need to give input

	/**
	 * @param value
	 * @see Used to Print the value on console
	 */
	public void print(String value) {

		System.out.println(value);
	}

	/**
	 * @param xpath
	 * @param index
	 * @see Used to select the values on dropdown by index
	 */
	public void slectByIndex(String xpath, int index) {
		WebElement element = driver.findElement(By.xpath(xpath));
		elementVisibility(element);
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	/**
	 * @param element
	 * @see Used to click an element on Webpage using Java Script
	 */

	public void clickJs(WebElement element) {
		elementVisibility(element);
		JavascriptExecutor script = (JavascriptExecutor) driver;
		script.executeScript("arguments[0].click()", element);
	}

	/**
	 * @see Used to handle the Simple Alert
	 */
	public void alertAcceptance() {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	/**
	 * @see Used to handle the Confirm Alert
	 */
	public void alertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}

	/**
	 * @param data
	 * @see Used to enter the text on Prompt Alert textbox
	 */
	public void alertSendKeys(String data) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(data);

	}

	/**
	 * 
	 * @return String
	 * @see Used to fetch a text from an Alert
	 */
	public String alertGetText() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		return text;

	}

	/**
	 * 
	 * @param element
	 * @see Used to fetch the options from Webpage drop down
	 */
	public void getOptions(WebElement element) {
		elementVisibility(element);
		Select select = new Select(element);
		select.getOptions();

	}// There is no return type for getOptions(); method only it is in the form of
		// List

	/**
	 * 
	 * @param element
	 * @return List<WebElement>
	 * @see Used to fetch the all selected options from Webpage drop down
	 */
	public List<WebElement> getAllSelectedOptions(WebElement element) {
		elementVisibility(element);
		Select select = new Select(element);
		List<WebElement> options = select.getAllSelectedOptions();
		return options;
	}

	/**
	 * 
	 * @param element
	 * @return WebElement
	 * @see Used to fetch the first selected option from Web page drop down
	 */
	public WebElement getFirstSelectOption(WebElement element) {
		elementVisibility(element);
		Select select = new Select(element);
		WebElement selectedOption = select.getFirstSelectedOption();
		return selectedOption;
	}

	/**
	 * 
	 * @param element
	 * @param data
	 * @see Used to deselect the drop down options by using attribute values
	 */
	public void deSelectByValue(WebElement element, String data) {
		elementVisibility(element);
		Select select = new Select(element);
		select.deselectByValue(data);
	}

	/**
	 * 
	 * @param element
	 * @param data
	 * @see Used to deselect the drop down options by using visible text
	 */
	public void deSelectByVisibleText(WebElement element, String data) {
		elementVisibility(element);
		Select select = new Select(element);
		select.deselectByVisibleText(data);
	}

	/**
	 * 
	 * @param element
	 * @see Used to deselect the all drop down options
	 */
	private void deSelectAll(WebElement element) {
		elementVisibility(element);
		Select select = new Select(element);
		select.deselectAll();
	}

	/**
	 * @return byte[]
	 * @param data
	 * @throws IOException
	 * @see Used to Take Screenshot and return in the form of BYTES
	 * 
	 */
	public byte[] screenShot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;

	}

	/**
	 * 
	 * @param element
	 * @see Used to perform Right click on Webelement
	 */
	public void contextClick(WebElement element) {
		elementVisibility(element);
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * 
	 * @param element
	 * @see Used to perform double click on Webelement
	 */
	public void doubleClick(WebElement element) {
		elementVisibility(element);
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();

	}

	/**
	 * 
	 * @return String
	 * @see Used to fetch the single window Id from browser
	 */
	public String windowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;

	}

	/**
	 * 
	 * @return Set<String>
	 * @see Used to fetch the all windows Ids from browser
	 */
	public Set<String> windowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;

	}

	/**
	 * 
	 * @param element
	 * @see Used to clear a text on text box on Webpage
	 */
	public void clearTextOnTextBox(WebElement element) {

		element.clear();

	}

}
