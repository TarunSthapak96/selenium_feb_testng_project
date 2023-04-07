package com.itview.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CrossBrowserCode {
	
	WebDriver w;

	@Test(priority = 0, description = "Verify on Chrome")
	public void EdgeBrowser() throws Exception {

		 ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");

			w = new ChromeDriver(chromeOptions);		
		
		w.get("https://www.google.com/");
		Thread.sleep(2000);
		String pageTitle = w.getTitle();
		Assert.assertEquals(pageTitle, "Google");
		w.close();

	}

	@Test(priority = 1, description = "Verify on firefox")
	public void ChromeBrowser() throws Exception {

		 ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");

			w = new ChromeDriver(chromeOptions);
			
		
		w.get("https://www.google.com/");
		Thread.sleep(2000);
		String pageTitle = w.getTitle();
		Assert.assertEquals(pageTitle, "Google");
		w.close();
	}

	@Test(priority = 2, description = "Verify on Edge")
	public void edgeBrowser() throws Exception {

		w = new EdgeDriver();
		
		
		w.get("https://www.google.com/");
		Thread.sleep(2000);
		String pageTitle = w.getTitle();
		Assert.assertEquals(pageTitle, "Google");
		w.close();
	}

}
