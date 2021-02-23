package com.opensource.admin.qa;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opensource.admin.AddUser;
import com.opensource.admin.Login;
import com.opensource.admin.UserManagement;
import com.opensource.base.GlobalVariables;
import com.opensource.base.SeleniumWrapper;

public class TC003_Admin_AddNewUser_POM {

	WebDriver driver;
	SeleniumWrapper seleniumWrapper;
	Login login;
	UserManagement userManagement;
	AddUser addUser;
	String username, password, row, column, employee;

	@BeforeTest
	public void beforeTest() throws FileNotFoundException {
		seleniumWrapper = new SeleniumWrapper(driver);
		driver = seleniumWrapper.chromeDriverConnection();
		login = new Login(driver);
		userManagement = new UserManagement(driver);
		addUser = new AddUser(driver);

		// Setup Data JSON
		this.username = seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "username");
		this.password = seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "password");

		// Setup Data Excel
		this.row = seleniumWrapper.getCellData(this.getClass().getSimpleName(), 1, 0);
		this.column = seleniumWrapper.getCellData(this.getClass().getSimpleName(), 1, 1);
		this.employee = seleniumWrapper.getCellData(this.getClass().getSimpleName(), 1, 2);

	}

	@Test
	public void TC003_Admin_AddNewUser_POM_Test(){

		// STEP 1 Open Browser "OrangeHRM" web page
		seleniumWrapper.launchBrowser(GlobalVariables.QA_URL);

		// STEP 2 Enter Username and Password
		login.loginOrange(username, password);

		// STEP 3 Validate that you have logged in successfully
		userManagement.validateLogged();

		// STEP 4 Click Admin - Go to the admin page
		userManagement.clickAdmin();

		// STEP 5 Click Add
		userManagement.clickAdd();

		// STEP 6 Enter valid Employee Name
		// STEP 7 Enter valid username
		// STEP 8 Enter new password and confirm
		// STEP 9 Click Save
		String newUsername = addUser.createNewUser(employee, true);

		// STEP 10 Search username in field "Username"
		// STEP 11 Click Search
		userManagement.searchUser(newUsername, true);

		// STEP 12 Verify username exist in table
		userManagement.validateValueFromSystemUsersTable(row, column, newUsername);

		// STEP 13 Log out
		login.logoutOrange();

	}

	@AfterTest
	public void afterTest() {

		// STEP 9 Close Browser
		seleniumWrapper.closeBrowser();
	}
}
