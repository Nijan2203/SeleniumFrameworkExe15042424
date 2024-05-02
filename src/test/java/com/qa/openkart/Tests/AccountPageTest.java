package com.qa.openkart.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.openkart.base.BaseTest;
import com.qa.openkart.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("200 - Account page Test with TTD")
@Story("Account Page_201 - Test the page details with Assertion")
public class AccountPageTest extends BaseTest {

	private WebDriver driver;

	@BeforeClass
	public void doLoginPageSetup() {
		accountPage = loginPage.dologin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@Severity(SeverityLevel.NORMAL)
	@Description("Checking the page Title")
	@Test
	public void doAccPgeTitleTest() {
		Assert.assertEquals(accountPage.getAccountPageTitle(), AppConstants.EXPECTED_ACC_PAGE_TITLE);
	}

	@DataProvider
	public Object[][] getSearchKeyWord() {
		return new Object[][] { { "Macbook" }, { "Samsung" }, { "Apple" } };
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Checking the search Product")
	@Test(dataProvider = "getSearchKeyWord")
	public void doProductSearchTest(String keySearch) {

		prdSearchpage = accountPage.getSearchkeyword(keySearch);
		Assert.assertTrue(prdSearchpage.getSearchProductCount() > 0);
	}

	@DataProvider
	public Object[][] getprodcutSltData() {
		return new Object[][] { { "Macbook", "MacBook" } };
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Checking the Select searched Product")
	@Test(dataProvider = "getprodcutSltData")
	public void doSearchPrdselectTest(String keySearch, String selectPrd) {

		prdSearchpage = accountPage.getSearchkeyword(keySearch);
		if (prdSearchpage.getSearchProductCount() > 0) {

			prdInfoPage = prdSearchpage.selectProduct(selectPrd);
			String prdHeaderTxt = prdInfoPage.getprodcutHeadervalue();
			Assert.assertEquals(prdHeaderTxt, selectPrd);
		}

	}

}
