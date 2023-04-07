package com.itview.webobject;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Code_For_WindowSize_5 {
	
	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		   w=new EdgeDriver();
		   //w.manage().window().maximize();
		  // w.manage().window().fullscreen();
		   
		   org.openqa.selenium.Dimension d=new Dimension(1400, 1200);
		   w.manage().window().setSize(d);
	}

	@Test
	public void Code_For_WindowSize() throws InterruptedException {
		
	
		w.get("https://www.google.co.in/");
		Thread.sleep(3000);
		
		//w.manage().window().maximize();
		
		//w.manage().window().fullscreen();
		
		//Set Window Size  (Parameter - > width , height)
		
		//Dimension d=new Dimension(1600, 1200);
      //  w.manage().window().setSize(d);	
		
		
			
	}

	@AfterTest
	public void afterTest() {
	//	w.quit();
	}

}
