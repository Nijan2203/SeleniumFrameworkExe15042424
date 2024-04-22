package com.qa.openkart.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.openkart.base.BaseTest;
import com.qa.openkart.constants.AppConstants;
import com.qa.operkart.pages.AccountPage;
import com.qa.operkart.pages.productSearchScreen;

public class AccountPageTest extends BaseTest {

	private WebDriver driver;

	@BeforeClass
	public void doLoginPageSetup() {
		accountPage = loginPage.dologin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
	
	
	@Test
	public void doAccPgeTitleTest() {
		Assert.assertEquals(accountPage.getAccountPageTitle(), AppConstants.EXPECTED_ACC_PAGE_TITLE);
	}
	
	
	@DataProvider
	public Object[][] getSearchKeyWord() {
		return new Object[][] {
			{"Macbook"},
			{"Samsung"},
			{"Apple"}
		};
	}
	
	@Test(dataProvider = "getSearchKeyWord")
	public void doProductSearchTest(String keySearch) {
		
		prdSearchpage = accountPage.getSearchkeyword(keySearch);
		Assert.assertTrue(prdSearchpage.getSearchProductCount()>0);
	}
	
	
}
