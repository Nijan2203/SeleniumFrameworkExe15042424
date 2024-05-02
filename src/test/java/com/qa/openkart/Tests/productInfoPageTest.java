package com.qa.openkart.Tests;

import java.util.Map;

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

@Epic("300 - Product page Test with TTD")
@Story("Product Page_301 - Test the page details with Assertion")
public class productInfoPageTest extends BaseTest {

	@BeforeClass
	public void doLoginPageSetup() {
		accountPage = loginPage.dologin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Checking the search Product")
	@DataProvider
	public Object[][] getprodcutSltData() {
		return new Object[][] { { "Macbook", "MacBook" } };
	}

	@Test(dataProvider = "getprodcutSltData")
	public void doPrdInfoTest(String keySearch, String selectPrd) {
		prdSearchpage = accountPage.getSearchkeyword(keySearch);
		prdInfoPage = prdSearchpage.selectProduct(selectPrd);
		Map<String, String> prdlist = prdInfoPage.getProductDetails();
		softAssert.assertEquals(prdlist.get("Brand"), "Apple");
		softAssert.assertEquals(prdlist.get("Product Code"), "Product 16");
		softAssert.assertEquals(prdlist.get("Reward Points"), "600");
		softAssert.assertEquals(prdlist.get("Availability"), "In Stock");

		softAssert.assertAll();
	}

	@DataProvider
	public Object[][] getaddcartData() {
		return new Object[][] { { "Macbook", "MacBook", 5 } };
	}

	@Severity(SeverityLevel.NORMAL)
	@Description("Checking the add cart Product")
	@Test(dataProvider = "getaddcartData")
	public void doaddcartTest(String keySearch, String selectPrd, int Qty) {
		prdSearchpage = accountPage.getSearchkeyword(keySearch);
		prdInfoPage = prdSearchpage.selectProduct(selectPrd);
		String succtext = prdInfoPage.doaddcart(Qty);
		Assert.assertEquals(succtext, AppConstants.EXPECTED_ADD_CART_SUCCESS_MESSAGE);

	}

}
