package com.qa.openkart.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.openkart.base.BaseTest;
import com.qa.openkart.constants.AppConstants;
import com.qa.operkart.pages.AccountPage;

public class loginpageTest extends BaseTest {

	private WebDriver driver;
	
	
	
	@BeforeClass

	@DataProvider
	public Object[][] registerData() {
		return new Object[][] { { "nijanthksr@gmail.com", "1Tiger@home" } };
	}

	@Test(dataProvider = "registerData")
	public void dologincheck (String usrname, String pwd) {
		accountPage = loginPage.dologin(usrname, pwd);
		String actAccPgeTlt = accountPage.getAccountPageTitle();
		Assert.assertEquals(actAccPgeTlt, AppConstants.EXPECTED_ACC_PAGE_TITLE);
	}

}
