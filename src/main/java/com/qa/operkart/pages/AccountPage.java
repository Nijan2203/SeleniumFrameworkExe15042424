package com.qa.operkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.openkart.constants.AppConstants;
import com.qa.openkart.util.ElementUtil;

public class AccountPage {
	
	private WebDriver driver;
	private ElementUtil eleutl;
	private By accPgeTlt = By.xpath("//div[@id='content']/h2");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleutl = new ElementUtil(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public String getAccountPageTitle() {
		return eleutl.waitElementVisisbility(accPgeTlt, AppConstants.DEFAULT_MEDIUM_TIMEOUT).getText();
		
	}
	
	
	
	
	

}
