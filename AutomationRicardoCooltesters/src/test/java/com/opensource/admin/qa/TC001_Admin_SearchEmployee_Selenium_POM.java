package com.opensource.admin.qa;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opensource.admin.Login;
import com.opensource.admin.UserManagement;
import com.opensource.base.GlobalVariables;
import com.opensource.base.SeleniumWrapper;

public class TC001_Admin_SearchEmployee_Selenium_POM {

	WebDriver driver;
	SeleniumWrapper seleniumWrapper;
	Login login;
	UserManagement userManagement;

	@BeforeTest
	public void beforeTest() {
		seleniumWrapper = new SeleniumWrapper(driver);
		driver = seleniumWrapper.chromeDriverConnection();
		login = new Login(driver);
		userManagement = new UserManagement(driver);
	}

	@Test
	public void TC001_Admin_SearchEmployee_Selenium_Test() {

		// STEP 1 Open Browser "OrangeHRM" web page
		seleniumWrapper.launchBrowser(GlobalVariables.QA_URL);

		// STEP 2 Enter Username and Password
		login.loginOrange("Admin", "admin123");
		
		// STEP 3 Validate that you have logged in successfully
		userManagement.validateLogged();

		// STEP 4 Click Admin - Go to the admin page
		userManagement.clickAdmin();

		// STEP 5 Search username in field "Username"
		// STEP 6 Click Search
		userManagement.searchUser("Admin", true);

		// STEP 7 Verify username exist in table
		userManagement.validateValueFromSystemUsersTable("1", "2", "Admin");

		// STEP 8 Log out
		login.logoutOrange();

	}

	@AfterTest
	public void afterTest() {

		// STEP 9 Close Browser
		seleniumWrapper.closeBrowser();
	}

}