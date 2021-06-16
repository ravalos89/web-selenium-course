package com.opensource.admin.qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC004_LoginDemo {

  @BeforeTest
  public void beforeTest() {
  }
  
  @Test
  public void TC004_LoginDemo_Test() {
	  
	// STEP 1 Open Browser "OrangeHRM" web page
  	System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
	// STEP 2 Login
	driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
	driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
	// STEP 3 Validate that you have logged in successfully
	Reporter.log("Validate that you have logged in successfully");
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menu_admin_viewAdminModule']")));
	
	// STEP 4 Close Browser
	Reporter.log("Close Browser");
	driver.close();
	
  }

  @AfterTest
  public void afterTest() {
  }

}
