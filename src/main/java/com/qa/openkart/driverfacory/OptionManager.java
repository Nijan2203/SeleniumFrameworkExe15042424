package com.qa.openkart.driverfacory;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OptionManager {

	private Properties prop;
	private ChromeOptions co;

	public OptionManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions browserOption() {

		co = new ChromeOptions();

		if (Boolean.parseBoolean(prop.getProperty("headless").trim()))
			co.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim()))
			co.addArguments("--incognito");
		System.out.println("================================Headless Mode is ON==============================");

		return co;

	}

}
