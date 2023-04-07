package com.itview.loginmodule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Login_OpenMRS_XPATH {

	public static void main(String[] args)throws Exception {
			
			WebDriver w=new EdgeDriver();
			
			w.get("https://demo.openmrs.org/openmrs/login.htm");
			
			w.findElement(By.xpath("//input[@id='username']")).sendKeys("Admin");
			
			w.findElement(By.xpath("//*[@id='password']")).sendKeys("Admin123");

			w.findElement(By.xpath("/html/body/div/div[3]/div/div/div/form/fieldset/ul/li[1]")).click();
			
			 w.findElement(By.xpath("//input[@type='submit']")).click();
			 
			 Thread.sleep(2000);
			 
			 w.findElement(By.xpath("/html/body/header/nav/div[2]/ul/li[3]/a")).click();
			 
			 w.close();
			 
			 System.out.println("Execution Done..");

	}

}
