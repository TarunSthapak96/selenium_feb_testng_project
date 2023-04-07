package com.itview.webobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Code_For_IFrame_3 {
 

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		   w=new EdgeDriver();

	}

	@Test
	public void Code_For_IFrame_Test() throws Exception{
		
		w.get("https://demo.automationtesting.in/Frames.html");		
		
		w.switchTo().frame("singleframe");
		
		w.findElement(By.xpath("/html/body/section/div/div/div/input")).clear();
		w.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Selenium");
		
		Thread.sleep(3000);
		
		w.quit();
	}

	@AfterTest
	public void afterTest() {
	//	w.quit();
	}
	
	
}
