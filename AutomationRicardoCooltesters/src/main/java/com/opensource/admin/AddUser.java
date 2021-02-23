package com.opensource.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opensource.base.GlobalVariables;
import com.opensource.base.SeleniumWrapper;

public class AddUser extends SeleniumWrapper{
	
	public AddUser(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By txt_employeeName = By.xpath("//input[@id='systemUser_employeeName_empName']");
	By txt_newUsername = By.xpath("//input[@id='systemUser_userName']");
	By txt_newPassword = By.xpath("//input[@id='systemUser_password']");
	By txt_confirmPassword = By.xpath("//input[@id='systemUser_confirmPassword']");
	By btn_save = By.xpath("//input[@id='btnSave']");
	
	/*
	 * Create New User
	 * @author Ricardo Avalos
	 */
	
	public String createNewUser(String employeeName, boolean clickSave) {
		String randomName = GlobalVariables.STD_TEST_NAME+randomNumber();
		type(txt_employeeName, employeeName, "Employee Name Field");
		type(txt_newUsername, randomName, "Username Field");
		type(txt_newPassword, GlobalVariables.STD_PASSWORD, "Password field");
		type(txt_confirmPassword, GlobalVariables.STD_PASSWORD, "Confirm Password field");
		takeScreenshot("FillCreateUser");
		if(clickSave) {
			click(btn_save, "Button Save");
		}
		takeScreenshot("AfterFillUser");
		return randomName;
	}
}
