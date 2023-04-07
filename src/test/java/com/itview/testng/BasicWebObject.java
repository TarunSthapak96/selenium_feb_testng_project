package com.itview.testng;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class BasicWebObject {
	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		 ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");

			w = new ChromeDriver(chromeOptions);
		
			w.get("http://demo.automationtesting.in/Register.html");
	}

	@Test(priority = 0, description = "Handle TextBox field")
	public void validate_textBox() {

		w.findElement(By.cssSelector("input[ng-model='FirstName']")).clear();
		w.findElement(By.cssSelector("input[ng-model='FirstName']")).sendKeys("Steve");

		w.findElement(By.cssSelector("input[ng-model='LastName']")).clear();
		w.findElement(By.cssSelector("input[ng-model='LastName']")).sendKeys("Jones");

		w.findElement(By.cssSelector("textarea[ng-model='Adress']")).clear();
		w.findElement(By.cssSelector("textarea[ng-model='Adress']")).sendKeys("Block 123, Sample Address");

		WebElement firstName = w.findElement(By.cssSelector("input[ng-model='FirstName']"));
		String firstNameValue = firstName.getAttribute("value");

		System.out.println("FirstName is : " + firstNameValue);

		Assert.assertEquals(firstNameValue, "Steve");

	}

	@Test(priority = 1, description = "Handle checkbox_radiobutton field")
	public void validate_checkbox_radiobutton() {

		w.findElement(By.cssSelector("input[value='FeMale']")).click();

		w.findElement(By.id("checkbox1")).click();

		w.findElement(By.id("checkbox3")).click();

	}
	
	@Test(priority = 2, description = "Handle drop down list")
	public void validate_drop_down() {
		
		WebElement Skills=w.findElement(By.id("Skills"));		
		Select sel=new Select(Skills);
		
	//	sel.selectByIndex(9);
		
	//	sel.selectByValue("CSS");
		
		sel.selectByVisibleText("Java");
		
		
		List<WebElement> SkillsDropDown=sel.getOptions(); // getOptions (return all values from drop-down)
		
		for(int i=0;i<SkillsDropDown.size();i++) {
			
			//SkillsDropDown[0]= some text

			System.out.println(SkillsDropDown.get(i).getText());
		}
		
		
	}

	@AfterTest
	public void afterTest() {
	}

}
