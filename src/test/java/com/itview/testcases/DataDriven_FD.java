package com.itview.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DataDriven_FD {
	
	WebDriver w;
	DataFormatter df;
	FileInputStream fi;
	XSSFWorkbook wb;
	XSSFSheet sht;
	XSSFRow row;
	XSSFCell principle,roi,period,frequencyValue,maturityValueFromExcel;

	@BeforeTest
	public void preCondition() throws Exception {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");

		w = new ChromeDriver(co);
		
		String projectPath = System.getProperty("user.dir"); 
		String excelFilePath=projectPath+"\\TestData\\FDCal.xlsx";
		
        df=new DataFormatter();		
		fi=new FileInputStream(excelFilePath);		
		wb=new XSSFWorkbook(fi); 		
		sht=wb.getSheetAt(0);		
		
	}

	@Test
	public void fixedDepositTest() throws Exception {

		
		
		w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

		
		
		
		try {
			w.findElement(By.id("wzrk-cancel")).click();
		} catch (Exception e) {
		}
		int rowCount=sht.getLastRowNum();

		for(int i=1;i<=rowCount;i++) // i -> represent rows
		{
			int j=0;
			
			row=sht.getRow(i);	
			
			principle=row.getCell(j);
			roi=row.getCell(j+1);
			period=row.getCell(j+2);
			frequencyValue=row.getCell(j+3);
			maturityValueFromExcel=row.getCell(j+4);
			
			
			
			
		w.findElement(By.id("principal")).clear();
		w.findElement(By.id("principal")).sendKeys(df.formatCellValue(principle).toString());

		w.findElement(By.name("interest")).clear();
		w.findElement(By.id("interest")).sendKeys(df.formatCellValue(roi).toString());

		w.findElement(By.id("tenure")).clear();
		w.findElement(By.id("tenure")).sendKeys(df.formatCellValue(period).toString());

		WebElement tenurePeriod = w.findElement(By.id("tenurePeriod"));
		Select sel_tenurePeriod = new Select(tenurePeriod);
		sel_tenurePeriod.selectByVisibleText("year(s)");

		Thread.sleep(2000);

		WebElement frequency = w.findElement(By.id("frequency"));
		Select sel_frequency = new Select(frequency);
		sel_frequency.selectByVisibleText(df.formatCellValue(frequencyValue).toString());

		w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();

		Thread.sleep(2000);

		String maturityValueUI = w.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();

		System.out.println("Principle Amount "+df.formatCellValue(principle).toString() +" | Maturity Value is : " + maturityValueUI);
		
		Assert.assertEquals(maturityValueUI, df.formatCellValue(maturityValueFromExcel).toString());
		
		}

	}

	@AfterTest
	public void postCondition() {

		w.quit();

	}


}
