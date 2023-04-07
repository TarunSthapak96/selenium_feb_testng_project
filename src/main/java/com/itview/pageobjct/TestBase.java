package com.itview.pageobjct;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestBase {
	
	WebDriver w;
	String baseUrl = "https://www.moneycontrol.com/personal-finance/tools";

	public void openBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			w = new ChromeDriver(co);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			w = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			w = new EdgeDriver();
		}

		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		w.manage().window().maximize();
	}

	public void closeBrowser() {
		w.quit();
	}

	public void openApplication(String htmlPage) {

		w.get(baseUrl+htmlPage);
	}

	public void handleInputEvent(WebElement we, String string) {
		we.clear();
		we.sendKeys(string);
	}

	public void handleClickEvent(WebElement we) {
		we.click();
	}

	public void handleDropDownEvent(WebElement we, String value) {
		Select sel = new Select(we);
		sel.selectByVisibleText(value);

	}

	public void handleAlert() {
		try {
			w.switchTo().alert().accept();
		} catch (Exception e) {
		}
	}
	
	public void captureScreenshot(String screenshotPath ) throws Exception {
		 TakesScreenshot ts=(TakesScreenshot) w;	       
	       File f=ts.getScreenshotAs(OutputType.FILE);       
	       FileUtils.copyFile(f, new File(screenshotPath));
	}
	
	public void waitForSec(int sec) throws Exception {		
		Thread.sleep(sec*1000);
	}
	
	public void windowScrollDown() throws Exception {		
		JavascriptExecutor js=(JavascriptExecutor) w;
		js.executeScript("window.scrollBy(0,300)");
	}
	
	
	public String readDataFromPropertiesFile(String key) throws Exception {
		
		String projectPath = System.getProperty("user.dir"); 		
		String configFilePath=projectPath+"\\Config\\config.properties";	
		
		FileInputStream fi=new FileInputStream(configFilePath);		
		Properties prop=new Properties();		
		prop.load(fi);
		
		String value=prop.getProperty(key);
		
		fi.close();
		
		return value;
	}


}
