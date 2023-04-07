package com.itview.webobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Code_For_CountElements_1 {
  

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		   w=new EdgeDriver();

	}

	@Test(priority = 0, description = "Test case to Count WebElements ")
	public void CountWebElement() throws Exception {

		w.get("http://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);

		// Count number of radio button on web page.
		
		List <WebElement> radioButton = w.findElements(By.name("radiooptions"));
		
		System.out.println("Count of radio button : "+radioButton.size());
		
		// Count number of checkBox on web page.
		
       List <WebElement> checkBox = w.findElements(By.cssSelector("input[type='checkbox']"));
		
		System.out.println("Count of checkBox : "+checkBox.size());
		
		// Count number of drop down on web page.
		
		List<WebElement> dropDown=w.findElements(By.tagName("select"));
		
		System.out.println("Count of Drop-Down : "+dropDown.size());
		
		// Count number of links on web page.
		
        List<WebElement> links=w.findElements(By.tagName("a"));
		
		System.out.println("Count of links : "+links.size());
		
		//Print value from Drop Down List
		
		WebElement MonthDropDown=w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select"));
		
		Select sel=new Select(MonthDropDown);
			
		System.out.println("\n Value inside Month DropDown : \n");
		List<WebElement> MonthDropDown_Values = sel.getOptions(); // .getOptions() method to fetch all elements from drop-down list
		
		for(int i=1;i<MonthDropDown_Values.size();i++) {
		
		System.out.println(MonthDropDown_Values.get(i).getText());
		
		}
	}

	@AfterTest
	public void afterTest() {

		//w.quit();
	}

}
