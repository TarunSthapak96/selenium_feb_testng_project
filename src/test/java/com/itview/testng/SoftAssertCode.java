package com.itview.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertCode {
	
WebDriver w;
	
	SoftAssert sft;

	@BeforeTest
	public void preCondition() {

		 ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");

			 w = new ChromeDriver(chromeOptions);
		
	}

	@Test(priority = 0, description = "Test Login Functionality")
	public void loginTest() {
		
		sft=new SoftAssert();
		
		w.get("http://altoromutual.com:8080/login.jsp");
		
		//1. verify page title should be "Altoro Login"		
		String loginPageTitle=w.getTitle();		
		sft.assertEquals(loginPageTitle, "Altoro Mutual");
		
		//2. verify page url should be -> http://altoromutual.com:8080/login.jsp
		String loginPageURL=w.getCurrentUrl();		
		sft.assertEquals(loginPageURL, "http://altoromutual.com:8080/login.jsp");
		
		//3. verify page label should contain "Login"

		WebElement loginPageLabel=w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
		String loginPageLabelText=loginPageLabel.getText();		
		sft.assertTrue(loginPageLabelText.contains("Admin"), "Login Page Label doesn't contains 'Login'");
		
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		
		sft.assertAll();
	}

	@Test(priority = 1, description = "Test Logout Functionality", dependsOnMethods = "loginTest")
	public void logoutTest() throws Exception {
		
		sft=new SoftAssert();
		
		String homePageTitle=w.getTitle();
		sft.assertEquals(homePageTitle, "Altoro Mutual");
		
		WebElement homePageLabel=w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
		String homePageLabelText=homePageLabel.getText();			
		sft.assertTrue(homePageLabelText.contains("Admin"), "Home Page Label doesn't contains 'Admin'");
		
		WebElement SignOffLink=w.findElement(By.linkText("Sign Off"));
		sft.assertTrue(SignOffLink.isDisplayed(),"Sign Off link not present on home page");
		
		Thread.sleep(3000);
		w.findElement(By.linkText("Sign Off")).click();
		
		sft.assertAll();
	}

	@AfterTest
	public void postCondition() {
		
		w.close();
	}

}
