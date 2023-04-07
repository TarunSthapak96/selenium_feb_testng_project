package com.itview.testcases;

import org.testng.annotations.Test;

import com.itview.pageobjct.CarHomeEMI_PageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class CarHomeEMI_Test {
	
	CarHomeEMI_PageObject carhome_emi = new CarHomeEMI_PageObject();
	
	@BeforeTest
	  public void preCondition() throws Exception {
		
		carhome_emi.openBrowser(carhome_emi.readDataFromPropertiesFile("browser"));
		carhome_emi.openApplication(carhome_emi.readDataFromPropertiesFile("carHomeEMI"));		
		carhome_emi.callPageFactoryElement();
		
		carhome_emi.handleClickEvent(carhome_emi.noThanks_window);

	  }
	
	@Test(priority = 0,description = "verify Loan amount for 1 lakhs")
	public void oneLakhLoanAmount() throws Exception {
		
		carhome_emi.windowScrollDown();
		
		//Scanner sc=new Scanner(System.in);
	//	System.out.print("Enter laon Amount : ");
		//String loanAmt=sc.next();
		
		carhome_emi.handleInputEvent(carhome_emi.carhome_loan_textbox,"100000" );
		carhome_emi.handleInputEvent(carhome_emi.loan_period_textbox, "10");
		carhome_emi.handleDropDownEvent(carhome_emi.custselect_DropDownlist, "From next month after disbursement");
	
		carhome_emi.handleInputEvent(carhome_emi.interest_rate_textbox, "7.5");
		carhome_emi.handleInputEvent(carhome_emi.upfront_charges_textbox, "600");
		
		carhome_emi.handleClickEvent(carhome_emi.submit_Btn);
		
		carhome_emi.waitForSec(3);
		
		System.out.println("EMI Value for 1 lakh Loan Amount : "+carhome_emi.emi_output.getText());
	
		//sc.close();
	}
	
	
}
