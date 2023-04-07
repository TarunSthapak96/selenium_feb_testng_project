package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class LoginMutualFund {
	
	WebDriver w;

	@BeforeTest
	public void preCondition() {

		 ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");

			w = new ChromeDriver(chromeOptions);
	}

	@Test(priority = 0, description = "Test Case to verify 'Admin' login functionality",groups="LoginMutualFund")
	public void loginAdmin() throws Exception {

		w.get("http://altoromutual.com:8080/login.jsp");
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(3000);
		w.findElement(By.linkText("Sign Off")).click();
		
	//	Assert.fail("forecely failing");
	}

	@Test(priority = 1, description = "Test Case to verify 'tuser' login functionality",dependsOnMethods = "loginAdmin",groups="LoginMutualFund",invocationCount = 1,enabled = true)
	public void loginTestUser() throws Exception {
		w.get("http://altoromutual.com:8080/login.jsp");
		w.findElement(By.id("uid")).sendKeys("tuser");
		w.findElement(By.id("passw")).sendKeys("tuser");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(3000);
		w.findElement(By.linkText("Sign Off")).click();
	}

	@Test(priority = 2, description = "Test Case to verify 'Jsmith' login functionality",dependsOnMethods = "loginAdmin",groups="LoginMutualFund")
	public void loginJsmith() throws Exception {
		
		w.get("http://altoromutual.com:8080/login.jsp");
		w.findElement(By.id("uid")).sendKeys("jsmith");
		w.findElement(By.id("passw")).sendKeys("Demo1234");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(3000);
		w.findElement(By.linkText("Sign Off")).click();
	}

	@AfterTest
	public void postCondition() {

		w.close();
	}

}
