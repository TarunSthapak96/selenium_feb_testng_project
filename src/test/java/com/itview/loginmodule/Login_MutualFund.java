package com.itview.loginmodule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_MutualFund {

	public static void main(String[] args)throws Exception {
		
	// interfaceName instance=new implementationClassName(); > instance of interface

		WebDriverManager.edgedriver().setup();
		
		WebDriver w=new EdgeDriver(); // open a blank browser

		//Step 1 : Open application with url
		w.get("http://altoromutual.com:8080/login.jsp");		
		
		//Step 2 : Enter username
		w.findElement(By.id("uid")).sendKeys("admin");
		
		//Step 3 : Enter Password
		w.findElement(By.id("passw")).sendKeys("admin");
		
		//Step 4: Click login
        w.findElement(By.name("btnSubmit")).click();
        
        Thread.sleep(3000);// 3000ms = 3 sec
        
       // Step 5: Click Logout
		
        w.findElement(By.linkText("Sign Off")).click();
        
        w.close();
        
        System.out.println("Admin Test Case Executed Successfully !!");

	}

}
