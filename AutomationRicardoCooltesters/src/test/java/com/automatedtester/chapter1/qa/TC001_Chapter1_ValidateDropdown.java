package com.automatedtester.chapter1.qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001_Chapter1_ValidateDropdown {

	@BeforeTest
	public void beforeTest() {
	}

	@Test
	public void TC001() throws InterruptedException {

		// WEBDRIVERS
		
		// CHROME
//		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		//FF
//		System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/firefox/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		//IE
		System.setProperty("webdriver.ie.driver", "./src/test/resources/drivers/ie/IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();

		// STEP 1
		Reporter.log("Launch and maximize automatedtester app");
		driver.get("http://book.theautomatedtester.co.uk/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);

		// STEP 2
		Reporter.log("Click Chapter 1");
		driver.findElement(By.xpath("//a[contains(text(),'Chapter1')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='radiobutton']")));
		Thread.sleep(2000);

		// STEP 3
		Reporter.log("Check Radio button");
		driver.findElement(By.xpath("//input[@id='radiobutton']")).click();
		Thread.sleep(2000);

		// STEP 4
		Reporter.log("Select Selenium core from dropdown");
		Select dd_selenium = new Select(driver.findElement(By.xpath("//select[@id='selecttype']")));
		dd_selenium.selectByValue("Selenium Code");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String dd_value = driver.findElement(By.xpath("//option[contains(text(),'Selenium Core')]")).getText();
		Assert.assertEquals(dd_value, "Selenium Core");
		Thread.sleep(2000);

		// STEP 5
		Reporter.log("Navigate Home page clicking Home Page link");
		driver.findElement(By.xpath("//a[contains(text(),'Home Page')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Chapter1')]")));
		Thread.sleep(2000);

		// STEP 6
		Reporter.log("Close Browser");
		driver.close();
	}

	@AfterTest
	public void afterTest() {
	}

}
