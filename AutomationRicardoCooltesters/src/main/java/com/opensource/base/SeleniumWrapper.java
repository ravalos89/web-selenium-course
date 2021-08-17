/**
 * Selenium wrapper Base class
 * 
 * @author Ricardo Avalos
 */

package com.opensource.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;


public class SeleniumWrapper {
	
	private WebDriver driver;
	ExtentTest extentTest;

	/**
	 * Constructor SeleniumWrapper Class @author Ricardo Avalos @param driver
	 * WebDriver instance @return @throws
	 */
	public SeleniumWrapper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Chrome driver connection
	 * 
	 * @author ricardo.avalos
	 */

	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	/*
	 * Initialize Extent Test (Report)
	 * 
	 * @author ricardo.avalos
	 */
	public void initializeExtentTest(ExtentTest extentTest) {
		this.extentTest = extentTest;
	}

	/**
	 * Launch Browser
	 * 
	 * @author Ricardo Avalos
	 * @param url, URL application
	 * @return
	 * @throws IOException
	 */
	public void launchBrowser(String url) {
		try {
			reportLog("Launch " + url + " applicaction Web");
			driver.get(url);
			driver.manage().window().maximize();
			implicitlyWait(5);
			extentTest.log(LogStatus.PASS,"Launch Browser" + extentTest.addScreenCapture(takeScreenshot("lauchBrowser")));
		} catch (Exception e) {
			extentTest.log(LogStatus.FAIL,"Launch Browser" + extentTest.addScreenCapture(takeScreenshot("lauchBrowser")));
			e.printStackTrace();
		}
	}

	/**
	 * Implicity Wait
	 * 
	 * @author ricardo.avalos
	 */
	public void implicitlyWait(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		} catch(TimeoutException e) {
			extentTest.log(LogStatus.FAIL,"Launch Browser" + extentTest.addScreenCapture(takeScreenshot("Timeout error")));
		}
		
	}

	/**
	 * Reporter log
	 * 
	 * @author ricardo.avalos
	 */
	public void reportLog(String log) {
		Reporter.log(log);
	}

	/**
	 * Find Element in application @author Ricardo Avalos @param locator @return
	 * locator @throws
	 */
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	/**
	 * Find Elements in application @author Ricardo Avalos @param locator @return
	 * locator @throws
	 */
	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	/**
	 * Get text from object @author Ricardo Avalos @param element @return value of
	 * object @throws
	 */
	public String getText(WebElement element) {
		return element.getText();
	}

	/**
	 * Get text from object by locator @author Ricardo Avalos @param locator @return
	 * value of object @throws
	 */
	public String getText(By locator) throws NoSuchElementException {
		try {
			return driver.findElement(locator).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	/**
	 * type in text box @author Ricardo Avalos @param inputText - value to insert
	 * into text box @param locator - Selenium locator @return @throws
	 */
	public void type(String inputText, By locator) {
		if (inputText == null || inputText == "") {
			return;
		}
		driver.findElement(locator).sendKeys(inputText);
	}

	/**
	 * type in text box @author Ricardo Avalos @param inputText - value to insert
	 * into text box @param locator - Selenium locator @return @throws
	 */
	public void type(By locator, String inputText, String ObjDescription) {

		if (inputText == null || inputText == "") {
			return;
		}

		System.out.println("Typing text:" + inputText + " Object: " + ObjDescription);
		driver.findElement(locator).sendKeys(inputText);
	}

	/**
	 * Click Object @author Ricardo Avalos @param locator @return @throws
	 */
	public void click(By locator) {
		driver.findElement(locator).click();
	}

	/**
	 * Click Object @author Ricardo Avalos @param locator,
	 * objDescription @return @throws
	 */
	public void click(By locator, String objDescription) {
		System.out.println("Click... " + objDescription);
		driver.findElement(locator).click();
	}

	/**
	 * Click Object @author Ricardo Avalos @param locator, clickAction,
	 * objDescription @return @throws
	 */
	public void click(By locator, boolean clickAction, String objDescription) {
		if (clickAction == false) {
			return;
		}
		System.out.println("Click... " + objDescription);
		driver.findElement(locator).click();
	}

	/**
	 * Validate if object is displayed correctly
	 * 
	 * @author Ricardo Avalos
	 * @param locator
	 * @return True;False - Boleean value if object is displayed
	 * @throws NoSuchElementException, If object is not displayed correctly
	 */
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Get Data from JSON file(2 Nodes)
	 * 
	 * @author Ricardo Avalos
	 * @param jsonFile, jsonObjName, jsonObjName2, jsonKey
	 * @return jsonValue
	 * @throws FileNotFoundException
	 */
	public String getJSONValue(String jsonFile, String jsonObjName, String jsonObjName2, String jsonKey)
			throws FileNotFoundException {
		try {

			// JSON Data
			InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFile + ".json");
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

			// Get Data
			String jsonValue = (String) jsonObject.getJSONObject(jsonObjName).getJSONObject(jsonObjName2).get(jsonKey);
			return jsonValue;

		} catch (FileNotFoundException e) {
			Assert.fail("JSON file is not found");
			return null;
		}
	}

	/**
	 * Get Data from JSON file (1 Node)
	 * 
	 * @author Ricardo Avalos
	 * @param jsonFile, jsonObjName, jsonKey
	 * @return jsonValue
	 * @throws FileNotFoundException
	 */
	public String getJSONValue(String jsonFile, String jsonObjName, String jsonKey) throws FileNotFoundException {
		try {

			// JSON Data
			InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFile + ".json");
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

			// Get Data
			String jsonValue = (String) jsonObject.getJSONObject(jsonObjName).get(jsonKey);
			return jsonValue;

		} catch (FileNotFoundException e) {
			Assert.fail("JSON file is not found");
			return null;
		}
	}

	/**
	 * Get Data from JSON file (Directly)
	 * 
	 * @author Ricardo Avalos
	 * @param jsonFile, jsonKey
	 * @return jsonValue
	 * @throws FileNotFoundException
	 */
	public String getJSONValue(String jsonFileObj, String jsonKey) throws FileNotFoundException {
		try {

			// JSON Data
			InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFileObj + ".json");
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

			// Get Data
			String jsonValue = (String) jsonObject.getJSONObject(jsonFileObj).get(jsonKey);
			return jsonValue;

		} catch (FileNotFoundException e) {
			Assert.fail("JSON file is not found");
			return null;
		}
	}

	/**
	 * Wait For Element Present
	 * 
	 * @author Ricardo Avalos
	 * @param locator
	 * @return
	 * @throws TimeoutException
	 */
	public void waitForElementPresent(By locator) throws TimeoutException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {

		}
	}

	/**
	 * Generate Ramdom Number @author Ricardo Avalos @param digit @return @throws
	 */
	public String getRandomNumber(int digit) {
		Random random = new Random();
		int randomNumber = 0;
		boolean loop = true;
		while (loop) {
			randomNumber = random.nextInt();
			if (Integer.toString(randomNumber).length() == digit && !Integer.toString(randomNumber).startsWith("-")) {
				loop = false;
			}
		}
		return Integer.toString(randomNumber);
	}

	/**
	 * Select first value from dropdown @author Ricardo Avalos @param
	 * locator @return @throws
	 */
	public void selectFirstValueDropdown(By locator) {
		waitForElementPresent(locator);
		WebElement element = findElement(locator);
		Select dropdown = new Select(element);
		dropdown.selectByIndex(1);
	}

	/**
	 * Select by value from dropdown @author Ricardo Avalos @param
	 * locator @return @throws
	 */
	public void selectByValueDropdown(By locator, String value) {
		waitForElementPresent(locator);
		WebElement element = findElement(locator);
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}

	/**
	 * Scroll to element @author Ricardo Avalos @param locator @return @throws
	 */
	public void scrollElement(By locator) {
		WebElement element = findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * Compare two string values @author Ricardo Avalos @param expectedValue,
	 * actualValue @return @throws
	 */
	public void compareStringValues(String expectedValue, String actualValue) throws NullPointerException {
		try {
			if (expectedValue.equals(actualValue)) {
				System.out.println(
						"Passed Expected value:" + expectedValue + " and Actual Value:" + actualValue + " are equals");
			} else {
				Assert.fail("Failed Expected value:" + expectedValue + " and Actual Value:" + actualValue
						+ " are not equals");
			}
		} catch (NullPointerException e) {

		}

	}

	/**
	 * Wait For Element Not Present
	 * 
	 * @author Ricardo Avalos
	 * @param locator
	 * @return
	 * @throws TimeoutException
	 */
	public void waitForElementNotPresent(By locator) throws TimeoutException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (TimeoutException e) {

		}
	}

	/**
	 * Hard Assert Equals
	 * 
	 * @author Ricardo Avalos
	 * @param String actualValue, String expectedValue
	 * @return N/A
	 * @throws AssertionError
	 */
	public void assertEquals(String actualValue, String expectedValue) throws AssertionError {
		try {
			Assert.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			Assert.fail("Not able to Assert " + actualValue);
		}

	}

	/**
	 * Soft Assert Equals
	 * 
	 * @author Ricardo Avalos
	 * @param String actualValue, String expectedValue
	 * @return N/A
	 * @throws AssertionError
	 */
	public void softAssertEquals(String actualValue, String expectedValue) throws AssertionError {
		try {
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			Assert.fail("Not able to Assert " + actualValue);
		}

	}

	/**
	 * Close Browser
	 * 
	 * @author Ricardo Avalos
	 * @param locator
	 * @return locator
	 * @throws NoSuchElementException
	 */
	public void closeBrowser() throws NoSuchSessionException {
		try {
			reportLog("Close Browser");
			driver.close();
		} catch (NoSuchSessionException e) {
			Assert.fail("Not able to close Browser");
		}

	}

	/*
	 * Take screenshot
	 * 
	 * @author Ricardo Avalos
	 * @throws IOException
	 */
	public String takeScreenshot(String fileName){
		try {
			String pathFileName= GlobalVariables.PATH_SCREENSHOTS + fileName + ".png";
			Screenshot screenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "PNG", new File(pathFileName));
			return pathFileName;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	/**
	 * Get value from Table
	 * 
	 * @author Ricardo Avalos
	 * @date 02/18/2021
	 */
	public String getValueFromTable(String row, String column) {
		try {
			return driver.findElement(By.xpath("//tbody/tr[" + row + "]/td[" + column + "]")).getText();
		} catch (NoSuchElementException e) {
			return null;
		}

	}

	/*
	 * Get Value from Excel
	 * @author Ricardo Avalos 
	 * @date 02/18/2019
	 */
	public String getCellData(String excelName, int row, int column) {
		try {
			// Reading Data
			FileInputStream fis = new FileInputStream(GlobalVariables.PATH_EXCEL_DATA+excelName+".xlsx");
			// Constructs an XSSFWorkbook object
			@SuppressWarnings("resource")
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheetAt(0);
			Row rowObj = sheet.getRow(row);
			Cell cell = rowObj.getCell(column);
			String value = cell.getStringCellValue();
			return value;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
	}
	
	/*
	 * Random Number
	 * @author Ricardo Avalos
	 * @date 02/23/2021
	 */
	
	public int randomNumber() {
		return (int)(Math.random()*10000);
	}
	
	/*
	 * Sleep
	 * @author Ricardo Avalos
	 * @date 02/23/2021
	 */
	
	public void sleep(int seg) {
		try {
			Thread.sleep(seg*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean validateSortOrderColumn(By locator) {
		
		ArrayList<String> actualList = new ArrayList<>();
		ArrayList<String> sortedList = new ArrayList<>();
		
		// Store values in array list
		List<WebElement> elementList= driver.findElements(locator);
		for(WebElement webElement : elementList){
			actualList.add(webElement.getText());
		}
		
		// Store values from actualList to SortedList
		for(String strValue : actualList){
			sortedList.add(strValue);
		}
		
		// Sort alphabetically and compare with actuaList
		Collections.sort(sortedList);
		return sortedList.equals(actualList);		
	}
	
	/**
	 * Waits for JS on page to in ready state. If page has JS to load, use this
	 * method for page load
	 * 
	 * @param driver
	 * @param timeout
	 */
	public static void waitForJSLoad(WebDriver driver, int timeout) {
		new WebDriverWait(driver, timeout).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
	}

	/**
	 * Waits for JQuery on page to be active. If page has Jquery on load, use this
	 * method for page load
	 * 
	 * @param driver
	 * @param timeout
	 */
	public static void waitForJQuery(WebDriver driver, int timeout) {
		new WebDriverWait(driver, timeout).until((ExpectedCondition<Boolean>) wd -> ((Boolean) ((JavascriptExecutor) wd)
				.executeScript("return window.jQuery != undefined && jQuery.active === 0")));
	}

	/**
	 * Waits for JS on page to in ready state. Waits for JQuery on page to be
	 * active. If the page has both JQuery and JS on load use this method
	 * 
	 * @param driver
	 * @param timeout
	 */
	public static void waitForJSJQuery(WebDriver driver, int timeout) {
		waitForJSLoad(driver, timeout);
		waitForJQuery(driver, timeout);
	}

}
