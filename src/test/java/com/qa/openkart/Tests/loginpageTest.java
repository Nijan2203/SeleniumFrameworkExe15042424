package com.qa.openkart.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.openkart.base.BaseTest;
import com.qa.openkart.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("100 - Login page Test with TTD")
@Story("Login Page_101 - Test the page details with Assertion")
public class loginpageTest extends BaseTest {

	private WebDriver driver;

	@DataProvider
	public Object[][] registerData() {
		return new Object[][] { { "nijanthksr@gmail.com", "1Tiger@home" } };
	}

	@Severity(SeverityLevel.BLOCKER)
	@Description("Login the Application")
	@Test(dataProvider = "registerData")
	public void dologincheck(String usrname, String pwd) {
		accountPage = loginPage.dologin(usrname, pwd);
		String actAccPgeTlt = accountPage.getAccountPageTitle();
		Assert.assertEquals(actAccPgeTlt, AppConstants.EXPECTED_ACC_PAGE_TITLE);
	}

}
