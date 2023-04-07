package com.itview.pageobjct;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCard_PageObject extends TestBase{

	@FindBy(id = "/html/body")
	public WebElement Credit_Card_Debt_Payoff_textbox;

	@FindBy(id = "monthly_interest")
	public WebElement monthly_interest_textbox;

	@FindBy(id = "payment_plan_every_month")
	public WebElement payment_plan_every_month_textbox;

	@FindBy(xpath = "/html/body/div[13]/section[1]/div/div/div[1]/div/div/div[2]/div[1]/div/div[3]/a[1]")
	public WebElement submit_Btn;

	@FindBy(id = "total_payment")
	public WebElement total_payment_output;

	public WebElement noThanks_window;


	public void callPageFactoryElement() {
	
	PageFactory.initElements(w, this);

		
	}
	

}
