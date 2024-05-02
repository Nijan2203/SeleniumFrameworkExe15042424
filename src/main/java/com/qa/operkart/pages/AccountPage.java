
package com.qa.operkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.openkart.constants.AppConstants;
import com.qa.openkart.util.ElementUtil;

import io.qameta.allure.Step;

public class AccountPage {

	private WebDriver driver;
	private ElementUtil eleutl;
	private By accPgeTlt = By.xpath("//div[@id='content']/h2");
	private By Searchkey = By.xpath("//input[@placeholder='Search']");
	private By Searchbtn = By.xpath("//button[@class='btn btn-default btn-lg']");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleutl = new ElementUtil(driver);
		// TODO Auto-generated constructor stub
	}

	@Step("Check the Header text of Account Page")
	public String getAccountPageTitle() {
		return eleutl.waitElementVisisbility(accPgeTlt, AppConstants.DEFAULT_MEDIUM_TIMEOUT).getText();

	}

	@Step("Search the Keyword in Account Page")
	public productSearchScreen getSearchkeyword(String keysearch) {
		eleutl.doSendKeys(Searchkey, keysearch);
		eleutl.doclick(Searchbtn);
		return new productSearchScreen(driver);
	}

}
