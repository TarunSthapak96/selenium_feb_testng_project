package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;

public class WaitCode {
	
	public static void main(String[] args) throws Exception {

		 ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");

			WebDriver w = new ChromeDriver(chromeOptions);
		
		//w.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); // 60 sec = 1 mins

		w.get("https://in.via.com/flight-tickets");

		w.findElement(By.id("wzrk-cancel")).click(); // 60 sec

		// Select source location
		w.findElement(By.id("source")).sendKeys("Mumbai"); // 60 sec

		Thread.sleep(2000);

		w.findElement(By.id("ui-id-1")).click();

		// Select target location

		w.findElement(By.id("destination")).sendKeys("Pune");

		Thread.sleep(2000);

		w.findElement(By.id("ui-id-2")).click();

		Thread.sleep(2000);

		w.findElement(By.xpath("//*[@id=\"depart-cal\"]/div[4]/div[2]/div[6]/div[4]")).click();

		Thread.sleep(2000);

		w.findElement(By.id("search-flight-btn")).click();

		//Thread.sleep(10000);
		
	//	WebDriverWait wt=new WebDriverWait(w, Duration.ofSeconds(60));
	//	wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cheap_flight_container\"]/div[2]/div/div[1]/div[3]/span[2]")));
		
		Wait<WebDriver> fluentwt = new FluentWait<WebDriver>(w)
				.withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchElementException.class); // this defines the exception to ignore

		fluentwt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cheap_flight_container\"]/div[2]/div/div[1]/div[3]/span[2]")));

		
		WebElement getLowestFlightPrice = w
				.findElement(By.xpath("//*[@id=\"cheap_flight_container\"]/div[2]/div/div[1]/div[3]/span[2]"));
		String lowestFlightPrice = getLowestFlightPrice.getText();

		System.out.println("Cheapest Flights is : " + lowestFlightPrice);

		w.close();
	}

}
