package com.qa.openkart.Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.openkart.base.BaseTest;
import com.qa.openkart.constants.AppConstants;
import com.qa.openkart.util.ExcelUtil;

public class RegistrationPageTest extends BaseTest {

//	@BeforeClass
//	public void getregistrationloginsetup() {
//		registrationPage =  loginPage.doclickRegisterbtn();
//	}

	@Test
	public void doclickRegisterbtnTest() {
		registrationPage = loginPage.doclickRegisterbtn();
		String actRegheader = registrationPage.getPageHeaderText();
		Assert.assertEquals(actRegheader, AppConstants.EXPECTED_REG_PAGE_HEADER);
	}

	@DataProvider
	public Object[][] userregdata() {
		Object regdata[][] = ExcelUtil.getexceldata("Registertestdata");
		return regdata;

//		return new Object [][] {
//			{"firstName", firstName, email, telephone, password}
//		};

	}

	@Test(dataProvider = "userregdata")
	public void doregistrationTest(String firstName, String lastName, String email, String telephone, String password)
			throws InterruptedException {
		Assert.assertTrue(registrationPage.douserRegister(firstName, lastName, email, telephone, password));

	}

}
