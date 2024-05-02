package com.qa.operkart.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.openkart.constants.AppConstants;
import com.qa.openkart.util.ElementUtil;

import io.qameta.allure.Step;

public class productInfoPage {

	private WebDriver driver;
	private ElementUtil eleutl;

	private By productHeader = By.tagName("h1");
	private By productInfo = By.xpath("(//ul[@class = 'list-unstyled'])[8]//li");
	private By priceInfo = By.xpath("(//ul[@class = 'list-unstyled'])[9]//li");
	private By cartQty = By.id("input-quantity");
	private By addcartbtn = By.id("button-cart");
	private By successMsg = By.className("alert-success");

	private Map<String, String> prdInfoMap;

	public productInfoPage(WebDriver driver) {
		this.driver = driver;
		eleutl = new ElementUtil(driver);
	}

	@Step("Check the project Title")
	public String getprodcutHeadervalue() {
		String prdHeaderValue = eleutl.waitElementVisisbility(productHeader, AppConstants.DEFAULT_MEDIUM_TIMEOUT)
				.getText();
		return prdHeaderValue;
	}

	@Step("Get the product info Details")
	public Map<String, String> getProductDetails() {

		prdInfoMap = new LinkedHashMap<String, String>();
		prdInfoMap.put("Product Name", getprodcutHeadervalue());
		getproductMap();
		getpricetMap();
		System.out.println(prdInfoMap);
		return prdInfoMap;

	}

	public void getproductMap() {
		List<WebElement> prdInfoList = eleutl.waitElementsVisisbility(productInfo, AppConstants.DEFAULT_MEDIUM_TIMEOUT);
		for (WebElement e : prdInfoList) {
			String txt = e.getText();
			String[] meta = txt.split(":");
			String key = meta[0].trim();
			String value = meta[1].trim();
			prdInfoMap.put(key, value);
		}
	}

	public void getpricetMap() {
		List<WebElement> priceInfoList = eleutl.waitElementsVisisbility(priceInfo, AppConstants.DEFAULT_MEDIUM_TIMEOUT);
		String price = priceInfoList.get(0).getText();
		String exprice = priceInfoList.get(1).getText();
		String expriceVal = exprice.split(":")[1].trim();

		prdInfoMap.put("price", price);
		prdInfoMap.put("Extra Tax", expriceVal);
	}

	@Step("Add the product into Cart")
	public String doaddcart(int qty) {
		eleutl.waitElementVisisbility(cartQty, AppConstants.DEFAULT_MEDIUM_TIMEOUT).sendKeys(String.valueOf(qty));
		eleutl.doclick(addcartbtn);
		String succMsg = eleutl.waitElementVisisbility(successMsg, AppConstants.DEFAULT_MEDIUM_TIMEOUT).getText();
		StringBuilder msgtext = new StringBuilder(succMsg);
		String suctxt = msgtext.substring(0, msgtext.length() - 2);
		System.out.println(succMsg);
		System.out.println(suctxt);
		return suctxt;

	}

}
