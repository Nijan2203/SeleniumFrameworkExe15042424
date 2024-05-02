package com.qa.operkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.openkart.constants.AppConstants;
import com.qa.openkart.util.ElementUtil;

import io.qameta.allure.Step;

public class productSearchScreen {

	private WebDriver driver;
	private ElementUtil eleutl;

	private By productList = By.cssSelector("div.product-layout");

	public productSearchScreen(WebDriver driver) {
		this.driver = driver;
		this.eleutl = new ElementUtil(driver);

	}

	@Step("Checking the search product count")
	public int getSearchProductCount() {
		int prdCount = eleutl.waitElementsVisisbility(productList, AppConstants.DEFAULT_MEDIUM_TIMEOUT).size();
		return prdCount;

	}

	@Step("Select the searched product")
	public productInfoPage selectProduct(String productname) {
		By selectPrd = By.linkText(productname);
		eleutl.doclick(selectPrd);
		return new productInfoPage(driver);
	}

}
