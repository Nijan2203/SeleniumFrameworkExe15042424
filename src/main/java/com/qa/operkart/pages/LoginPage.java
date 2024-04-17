package com.qa.operkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.openkart.constants.AppConstants;
import com.qa.openkart.util.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleutl;
	
	private By Regiserbtn = By.linkText("Register");
	private By username = By.id("input-email");
	private By pwd = By.id("input-password");
	private By loginbtn = By.xpath("//input[@type='submit']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleutl = new ElementUtil(driver);
	}

	
	
	public RegistionPage doclickRegisterbtn() {
		eleutl.waitElementVisisbility(Regiserbtn, AppConstants.DEFAULT_MEDIUM_TIMEOUT);
		eleutl.doclick(Regiserbtn);
		return new RegistionPage(driver);
	}
	
	
	
	
	public AccountPage dologin(String usrname, String pwsd) {
		eleutl.waitElementVisisbility(username, AppConstants.DEFAULT_MEDIUM_TIMEOUT).sendKeys(usrname);
		eleutl.doSendKeys(pwd, pwsd);
		eleutl.doclick(loginbtn);
		return new AccountPage(driver);
		
		
	}
	
}
