package com.qa.openkart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.openkart.driverfacory.DriverFactory;
import com.qa.operkart.pages.AccountPage;
import com.qa.operkart.pages.LoginPage;
import com.qa.operkart.pages.RegistionPage;
import com.qa.operkart.pages.productInfoPage;
import com.qa.operkart.pages.productSearchScreen;

public class BaseTest {

	public WebDriver driver;
	DriverFactory df;
	protected Properties prop;
	protected LoginPage loginPage;
	protected RegistionPage registrationPage;
	protected AccountPage accountPage;
	protected productSearchScreen prdSearchpage;
	protected productInfoPage prdInfoPage;
	protected SoftAssert softAssert;

	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browsername) {
		df = new DriverFactory();
		prop = df.intiProp();
		if(browsername!=null) {
			prop.setProperty("browser", browsername);
		}
		driver = df.Launchbrowser(prop);

		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
