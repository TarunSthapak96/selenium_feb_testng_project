package com.itview.webobject;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Code_For_WindowTab_8 {
 
	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		   w=new EdgeDriver();
		w.manage().window().maximize();	
		
	}

	
	@Test(priority=0,description="Test case to handle Flipkart Tab")
	public void tabFlipkart() throws Exception {
		
		
		w.get("https://www.flipkart.com/home-kitchen/home-appliances/washing-machines/fully-automatic-front-load~function/pr?sid=j9e%2Cabm%2C8qx&otracker=nmenu_sub_TVs%20%26%20Appliances_0_Fully%20Automatic%20Front%20Load");
		
		w.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a")).click();
		
        Thread.sleep(2000);
        
        Set<String> windowsIds=w.getWindowHandles(); // return number of window open by selenium (id) 
        
        System.out.println(windowsIds);
        
      Object [] window=windowsIds.toArray();
        
        System.out.println(window[0]);
        System.out.println(window[1]);


       w.switchTo().window(window[0].toString());
        System.out.println("Tab 1 title : "+w.getTitle());
        
        Thread.sleep(2000);
        
        w.switchTo().window(window[1].toString());
        System.out.println("Tab 2 title : "+w.getTitle());
        
        Thread.sleep(2000);

        w.switchTo().window(window[0].toString());
        System.out.println("Tab 1 title : "+w.getTitle());
        
        Thread.sleep(2000);
        
        w.switchTo().window(window[1].toString());
        System.out.println("Tab 2 title : "+w.getTitle());
      
        
	}
	@AfterTest
	public void afterTest() {
		
		//w.close();
		w.quit();
	}
	
}
