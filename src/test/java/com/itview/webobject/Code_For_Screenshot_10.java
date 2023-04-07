package com.itview.webobject;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Code_For_Screenshot_10 {
 
	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		   w=new EdgeDriver();
		w.manage().window().maximize();
		
	}

	@Test
	public void Code_For_Screenshot() throws Exception {

   //C:\Users\Lenovo\eclipse-workspace\selenium-testng-test
		
		String projectPath = System.getProperty("user.dir"); // current project path return
	
		System.out.println(projectPath);
		
		String screenshotPath=projectPath +"\\Screenshot\\SeleniumPage.png";
		
		w.get("https://www.selenium.dev/");

		
       TakesScreenshot ts=(TakesScreenshot) w;	       
       File f=ts.getScreenshotAs(OutputType.FILE);       
       FileUtils.copyFile(f, new File(screenshotPath));
		
	   Thread.sleep(2000);
		
        
		/*
		  
		 * For FileUtils add dependencies in pom.xml.
		 
		  <dependency>
		  
		   <groupId>commons-io</groupId>
		 <artifactId>commons-io</artifactId> 
		 <version>2.6</version>
		 
		    </dependency>
		 
		 
		 * 
		 */

	}

	@AfterTest
	public void afterTest() {

		w.quit();
	}
	
	
	
	
  }
