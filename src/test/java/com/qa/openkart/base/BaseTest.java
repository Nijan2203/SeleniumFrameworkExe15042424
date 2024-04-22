package com.qa.openkart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.openkart.driverfacory.DriverFactory;
import com.qa.operkart.pages.AccountPage;
import com.qa.operkart.pages.LoginPage;
import com.qa.operkart.pages.RegistionPage;
import com.qa.operkart.pages.productSearchScreen;

public class BaseTest {

	public WebDriver driver;
	DriverFactory df;
	protected Properties prop;
	protected LoginPage loginPage;
	protected RegistionPage registrationPage;
	protected AccountPage accountPage;
	protected productSearchScreen prdSearchpage;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.intiProp();
		driver = df.Launchbrowser(prop);

		loginPage = new LoginPage(driver);

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
