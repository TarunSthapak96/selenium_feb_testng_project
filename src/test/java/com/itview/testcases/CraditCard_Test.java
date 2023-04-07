package com.itview.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.itview.pageobjct.CreditCard_PageObject;

public class CraditCard_Test {
	
	CreditCard_PageObject CreditCard = new CreditCard_PageObject();
	
	@BeforeTest
	  public void preCondition() throws Exception {
		
		CreditCard.openBrowser(CreditCard.readDataFromPropertiesFile("browser"));
		CreditCard.openApplication(CreditCard.readDataFromPropertiesFile("CreditCard"));		
		CreditCard.callPageFactoryElement();
		
		CreditCard.handleClickEvent(CreditCard.noThanks_window);

	  }
	
	@Test(priority = 0,description = "verify Outstanding Loan Amount for 1 lakhs")
	public void oneLakhLoanAmount() throws Exception {
		
		CreditCard.windowScrollDown();
		
		CreditCard.handleInputEvent(CreditCard.Credit_Card_Debt_Payoff_textbox, "100000");
	
		CreditCard.handleInputEvent(CreditCard.monthly_interest_textbox, 2.5);
		
		CreditCard.handleInputEvent(CreditCard.payment_plan_every_month_textbox, 6000);
	
	CreditCard.handleClickEvent(CreditCard.submit_Btn);
	
	CreditCard.waitForSec(4);
	
	System.out.println("Outstanding Loan Amount Value for 1 lakh Loan Amount : "+CreditCard.total_payment_output.getText());
	}
}
