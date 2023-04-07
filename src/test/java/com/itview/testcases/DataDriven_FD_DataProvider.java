package com.itview.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class DataDriven_FD_DataProvider {
	
	WebDriver w;

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { 
			new Object[] { "100000", "9" , "5" ,"Simple Interest" }, 
			new Object[] { "300000", "6.5" , "8" ,"Simple Interest" }, 
			new Object[] { "600000", "7" , "2" ,"Simple Interest" }, 
			};
	}

	@BeforeTest
	public void beforeTest() {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");

		w = new ChromeDriver(co);
	}

	@Test(dataProvider = "dp")
	public void f(String principle, String roi,String period, String frequencyValue) throws Exception {

		w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

		try {
			w.findElement(By.id("wzrk-cancel")).click();
		} catch (Exception e) {
		}

		w.findElement(By.id("principal")).clear();
		w.findElement(By.id("principal")).sendKeys(principle);

		w.findElement(By.name("interest")).clear();
		w.findElement(By.id("interest")).sendKeys(roi);

		w.findElement(By.id("tenure")).clear();
		w.findElement(By.id("tenure")).sendKeys(period);

		WebElement tenurePeriod = w.findElement(By.id("tenurePeriod"));
		Select sel_tenurePeriod = new Select(tenurePeriod);
		sel_tenurePeriod.selectByVisibleText("year(s)");

		Thread.sleep(2000);

		WebElement frequency = w.findElement(By.id("frequency"));
		Select sel_frequency = new Select(frequency);
		sel_frequency.selectByVisibleText(frequencyValue);

		w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();

		Thread.sleep(2000);

		String maturityValueUI = w.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();

		System.out.println("Principle Amount " + principle + " | Maturity Value is : "
				+ maturityValueUI);

	}

	@AfterTest
	public void afterTest() {
		
		w.quit();
	}
	

}
