package com.itview.webobject;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcelFile {
	
	
	public static void main(String[] args) throws Exception {

		String projectPath = System.getProperty("user.dir"); // current project path return		
		String excelFilePath=projectPath+"\\TestData\\FDCal.xlsx";
		
		DataFormatter df=new DataFormatter();
		
		FileInputStream fi=new FileInputStream(excelFilePath);	// open file -> FDCal.xlsx
		
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(fi); // open workbook -> FDCal.xlsx
		
		XSSFSheet sht=wb.getSheetAt(0);
		
		XSSFRow row=sht.getRow(2);
		
		XSSFCell cell=row.getCell(1);	
		
		System.out.println(df.formatCellValue(cell).toString());
		
		int rowCount=sht.getLastRowNum();
		
		System.out.println(rowCount);
		

	}


}
