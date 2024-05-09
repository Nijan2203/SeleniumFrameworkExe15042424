package com.qa.openkart.driverfacory;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {

	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
	
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

	public FirefoxOptions firefoxopt() {

		fo = new FirefoxOptions();

		if (Boolean.parseBoolean(prop.getProperty("headless").trim()))
			fo.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim()))
			fo.addArguments("--incognito");
		System.out.println("================================Headless Mode is ON==============================");

		return fo;

	}

	
	public EdgeOptions edgeopt() {

		eo = new EdgeOptions();

		if (Boolean.parseBoolean(prop.getProperty("headless").trim()))
			eo.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim()))
			eo.addArguments("--incognito");
		System.out.println("================================Headless Mode is ON==============================");

		return eo;

	}
}
