package com.qa.operkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.openkart.constants.AppConstants;
import com.qa.openkart.util.ElementUtil;

public class RegistionPage {

	private WebDriver driver;
	private ElementUtil eleutl;
	private By pageHeader = By.tagName("h1");
	private By firstName = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By cfmpassword = By.id("input-confirm");
	private By subradio = By.xpath("//input[@value = '1' and @name='newsletter']");
	private By plyagree = By.name("agree");
	private By ctnbtn = By.xpath("//input[@type='submit']");
	private By registerSuccessMesg = By.cssSelector("div#content h1");

	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	public RegistionPage(WebDriver driver) {
		this.driver = driver;
		eleutl = new ElementUtil(driver);
	}

	public String getPageHeaderText() {
		String actpagetle = eleutl.dofindWebElement(pageHeader).getText();
		return actpagetle;
	}

	public boolean douserRegister(String firstname, String lastname, String email, String telephone, String password)
			throws InterruptedException {
		eleutl.waitElementVisisbility(firstName, AppConstants.DEFAULT_MEDIUM_TIMEOUT);
		eleutl.doSendKeys(this.firstName, firstname);
		eleutl.doSendKeys(this.lastname, lastname);
		eleutl.doSendKeys(this.email, email);
		eleutl.doSendKeys(this.telephone, telephone);
		eleutl.doSendKeys(this.password, password);
		eleutl.doSendKeys(this.cfmpassword, password);
		eleutl.doclick(subradio);
		eleutl.doclick(plyagree);
		eleutl.doclick(ctnbtn);
		String regsuccesmsg = eleutl.waitElementVisisbility(registerSuccessMesg, AppConstants.DEFAULT_MEDIUM_TIMEOUT)
				.getText();
		if (regsuccesmsg.contains(AppConstants.EXPECTED_REG_SUCCESS_MESSAGE)) {
			eleutl.doclick(logoutLink);
			eleutl.doclick(registerLink);
			return true;
		}
		return false;
	}

}
