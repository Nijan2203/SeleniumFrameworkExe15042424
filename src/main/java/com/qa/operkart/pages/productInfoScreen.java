package com.qa.operkart.pages;

import org.openqa.selenium.WebDriver;

import com.qa.openkart.util.ElementUtil;

public class productInfoScreen {

	private WebDriver driver;
	private ElementUtil eleutl;

	public productInfoScreen(WebDriver driver) {
		this.driver = driver;
		this.eleutl = new ElementUtil(driver);

	}

}
