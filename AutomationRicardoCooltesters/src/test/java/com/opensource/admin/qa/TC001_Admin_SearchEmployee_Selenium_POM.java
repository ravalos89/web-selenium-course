package com.opensource.admin.qa;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opensource.admin.Login;
import com.opensource.admin.UserManagement;
import com.opensource.base.GlobalVariables;
import com.opensource.base.SeleniumWrapper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC001_Admin_SearchEmployee_Selenium_POM {

	WebDriver driver;
	SeleniumWrapper seleniumWrapper;
	Login login;
	UserManagement userManagement;
	String username, password, row, column;
	ExtentReports reports;
	ExtentTest extentTest;

	@BeforeTest
	public void beforeTest() throws FileNotFoundException {
		seleniumWrapper = new SeleniumWrapper(driver);
		driver = seleniumWrapper.chromeDriverConnection();
		login = new Login(driver);
		userManagement = new UserManagement(driver);
		
		// Extent Report
		reports = new ExtentReports("C:\\Users\\ravalos\\Documents\\Evidences\\test.html");
		extentTest = reports.startTest(this.getClass().getSimpleName());
		seleniumWrapper.initializeExtentTest(extentTest);
		
		//Setup Data JSON
		this.username = seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "username");
	    this.password = seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "password");
	    
	    //Setup Data Excel
	    this.username = seleniumWrapper.getCellData(this.getClass().getSimpleName(), 1, 0);
	    this.password = seleniumWrapper.getCellData(this.getClass().getSimpleName(), 1, 1);
	    this.row = seleniumWrapper.getCellData(this.getClass().getSimpleName(), 1, 2);
	    this.column = seleniumWrapper.getCellData(this.getClass().getSimpleName(), 1, 3);
	}

	@Test
	public void TC001_Admin_SearchEmployee_Selenium_Test(){

		// STEP 1 Open Browser "OrangeHRM" web page
		seleniumWrapper.launchBrowser(GlobalVariables.QA_URL);
		extentTest.log(LogStatus.PASS,"Launch Browser" + extentTest.addScreenCapture(seleniumWrapper.takeScreenshot("lauchBrowser")));

		// STEP 2 Enter Username and Password
		login.loginOrange(username, password);
		
		// STEP 3 Validate that you have logged in successfully
		userManagement.validateLogged();

		// STEP 4 Click Admin - Go to the admin page
		userManagement.clickAdmin();

		// STEP 5 Search username in field "Username"
		// STEP 6 Click Search
		userManagement.searchUser(username, true);

		// STEP 7 Verify username exist in table
		userManagement.validateValueFromSystemUsersTable(row, column, username);

		// STEP 8 Log out
		login.logoutOrange();

	}

	@AfterTest
	public void afterTest() {

		// STEP 9 Close Browser
		seleniumWrapper.closeBrowser();
		
		// Extent Report
		reports.endTest(extentTest);
		reports.flush();
	}

}
