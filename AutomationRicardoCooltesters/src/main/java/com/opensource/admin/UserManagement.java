package com.opensource.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.opensource.base.SeleniumWrapper;

public class UserManagement extends SeleniumWrapper{
	
	By link_admin = By.xpath("//a[@id='menu_admin_viewAdminModule']");
	By txt_search = By.xpath("//input[@id='searchSystemUser_userName']");
	By btn_search = By.xpath("//input[@id='searchBtn']");
	By btn_add = By.xpath("//input[@id='btnAdd']");	
	/*
	 * Constructor
	 * @author: Ricardo Avalos
	 */
	public UserManagement(WebDriver driver) {
		super(driver);
	}
	
	/*
	 * Validate Logged successfully
	 * @author Ricardo Avalos
	 * @date 02/18/2021
	 */
	
	public void validateLogged() {
		reportLog("Validate Logged successfully");	
		waitForElementPresent(link_admin);
		takeScreenshot("ValidateLogged");
	}
	
	/*
	 * Click Admin
	 * @author Ricardo Avalos
	 * @date 02/18/2021
	 */
	
	public void clickAdmin() {
		reportLog("Click Admin module");
		click(link_admin, "Click Admin");
		implicitlyWait(3);
		takeScreenshot("ClickAdmin");
	}
	
	/*
	 * Search User in User management page
	 * @author Ricardo Avalos
	 * @date 02/18/2021
	 */
	
	public void searchUser(String username, boolean clickSearch) {
		reportLog("Search Username in user management page");
		type(txt_search, username, "Typing Username to search..."+username);
		if(clickSearch) {
			click(btn_search, "Click Button Search");	
		}
		implicitlyWait(3);
		takeScreenshot("SearchUser");
	}
	
	/*
	 * Validate value from Table
	 * @author Ricardo Avalos
	 * @date 02/18/2021
	 */
	
	public void validateValueFromSystemUsersTable(String row, String column, String expectedValue) {
		sleep(2);
		reportLog("Verify this value: "+expectedValue+" in System User Table");
		String actualValue = getValueFromTable(row, column);
		takeScreenshot("ValueUsersTable");
		assertEquals(actualValue, expectedValue);
		SoftAssert soft = softAssertEquals("", "");
	}
	
	/*
	 * Click Add
	 * @author Ricardo Avalos
	 * @date 02/18/2021
	 */
	
	public void clickAdd() {
		reportLog("Click Add");
		takeScreenshot("BeforeClickAdd");
		click(btn_add, "Add");
		implicitlyWait(3);
		takeScreenshot("AfterClickAdd");
	}

}
