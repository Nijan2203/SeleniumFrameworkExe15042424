package com.qa.operkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.openkart.constants.AppConstants;
import com.qa.openkart.util.ElementUtil;

public class productInfoPage {
	
	private WebDriver driver;
	private ElementUtil eleutl;
	
	private By productHeader = By.tagName("h1");

	public productInfoPage(WebDriver driver) {
		this.driver = driver;
		eleutl = new ElementUtil(driver);
	}
	
	
	public String getprodcutHeadervalue() {
		String prdHeaderValue = eleutl.waitElementVisisbility(productHeader, AppConstants.DEFAULT_MEDIUM_TIMEOUT).getText();
		return prdHeaderValue;
	}

}
