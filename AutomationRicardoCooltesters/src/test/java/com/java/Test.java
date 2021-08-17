package com.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
//		driver = new ChromeDriver();
//		
//		driver.get("https://www.google.com/");
//		driver.manage().window().maximize();
		
		DecimalComparator decimalComparator = new DecimalComparator();
		boolean isTrue = decimalComparator.areEqualByThreeDecimalPlaces(3.145, 3.145);
		
		System.out.println(isTrue);
		
//		Random r = new Random();
//		int[] fiveRandomNumbers = r.ints(5, 0, 11).toArray();
//		
//		List<Integer> list = new ArrayList();
//		
//		for(int i=0; i<20; i++) {
//			int randomNumber = r.ints(1, 1, 13).findFirst().getAsInt();
//			System.out.println(randomNumber);
//		}
		
		
		
//		List<Integer> list = new ArrayList<Integer>();
//		int count = 0;
//		for(int i=0; i<=1425; i+=15) {
//			list.add(i);
//			count++;
//		
//		}
//		
//		Random random = new Random();
//		int randomNumber = random.nextInt(count - 0) + 0;
//		System.out.println(String.valueOf(list.get(randomNumber)));

	}

}
