package com.itview.webobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Code_For_navigate_4 {
 
	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		   w=new EdgeDriver();

		
	}

	@Test
	public void Code_For_navigate() throws Exception {
		
	//	w.get("https://www.selenium.dev/");
		  
		 //OR
		
		w.navigate().to("https://www.selenium.dev/");

		Thread.sleep(3000);
		
		w.findElement(By.xpath("//*[@id=\"main_navbar\"]/ul/li[3]/a/span")).click();
		
		Thread.sleep(3000);

		w.navigate().back();
		
		Thread.sleep(3000);

		w.navigate().forward();
		
		Thread.sleep(3000);		
		
		w.navigate().back();


		Thread.sleep(3000);		
		
		w.findElement(By.xpath("//*[@id=\"main_navbar\"]/ul/li[5]/a/span")).click();
		
		Thread.sleep(3000);

		w.navigate().refresh();
        
       
	}

	@AfterTest
	public void afterTest() {

		//w.quit();
	}

	
	
	
}
