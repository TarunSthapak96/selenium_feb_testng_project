package com.itview.webobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Code_For_JavaScriptExecutor_9 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		w = new EdgeDriver();
		w.manage().window().maximize();
	}

	@Test
	public void Code_For_JavaScriptExecutor_Test() throws Exception {

		w.get("http://demo.automationtesting.in/Register.html");

		

        JavascriptExecutor js=(JavascriptExecutor) w;
		
		js.executeScript("alert('Welcome to Register Page ...');");
		
		Thread.sleep(2000);

                   w.switchTo().alert().accept();		
		
		// JavascriptExecutor for input
                   
                  WebElement firstName = w.findElement(By.cssSelector("input[ng-model='FirstName']"));
           		WebElement lastName = w.findElement(By.cssSelector("input[ng-model='LastName']"));

		js.executeScript("arguments[0].value=''", firstName);
		js.executeScript("arguments[0].value='Jones'", firstName);
		
			
		//w.findElement(By.cssSelector("input[ng-model='FirstName']")).sendKeys("Jones");
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].value=''", lastName);
		js.executeScript("arguments[0].value='Smith'", lastName);
		
		Thread.sleep(2000);

		//Page Down (width,height) - down then postive value 
		js.executeScript("window.scrollBy(0,600)");
		
	
		Thread.sleep(2000);

		
		//Listbox
		w.findElement(By.id("msdd")).click();
		Thread.sleep(2000);
		
		w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[1]")).click();
		Thread.sleep(2000);
		
		WebElement urdu=w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[40]/a"));
		js.executeScript("arguments[0].scrollIntoView(true);", urdu);


		urdu.click();
		
		
		//Select data from drop-sown list
		Thread.sleep(2000);
		WebElement skillsDropDown= w.findElement(By.id("Skills"));

		Select sel = new Select(skillsDropDown);
		sel.selectByVisibleText("Java"); // actual text from drop down
		
		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,-600)");
		
		Thread.sleep(2000);
		js.executeScript("history.go(0)"); // refresh page
		

	}

	@AfterTest
	public void afterTest() {
	}

	
	
	
	
}
