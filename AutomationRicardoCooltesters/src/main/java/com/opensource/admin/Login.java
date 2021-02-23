package com.opensource.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opensource.base.SeleniumWrapper;

public class Login extends SeleniumWrapper{

	public Login(WebDriver driver) {
		super(driver);
	}
	
	By txt_username = By.xpath("//input[@id='txtUsername']");
	By txt_password = By.xpath("//input[@id='txtPassword']");
	By btn_login = By.xpath("//input[@id='btnLogin']");
	By btn_userWelcome = By.xpath("//a[@id='welcome']");
	By btn_logout = By.xpath("//a[contains(text(),'Logout')]");
	
	/*
	 * Login OrangeHRM
	 * @author Ricardo Avalos
	 * @date 02/18/2021
	 */
	
	public void loginOrange(String username, String password){
		reportLog("Login into Orange HRM Portal");
		waitForElementPresent(txt_username);
		type(txt_username, username, "Username");
		type(txt_password, password, "Password");
		takeScreenshot("LoginOrange");
		click(btn_login, "Button Login");
		takeScreenshot("AfterClickLogin");
		implicitlyWait(5);
	}
	
	/*
	 * Logout OrangeHRM
	 * @author Ricardo Avalos
	 * @date 02/18/2021
	 */
	
	public void logoutOrange() {
		reportLog("Logout Orange HRM Portal");
		click(btn_userWelcome, "Click Welcome User");
		takeScreenshot("ClickWelcome");
		click(btn_logout, "Click Logout");
		takeScreenshot("ClickLogout");
		implicitlyWait(5);
	}
	
}
