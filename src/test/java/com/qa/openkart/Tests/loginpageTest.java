package com.qa.openkart.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.openkart.base.BaseTest;
import com.qa.openkart.constants.AppConstants;

public class loginpageTest extends BaseTest {

	private WebDriver driver;

	@Test
	public void doclickRegisterbtnTest() {
		registrationPage = loginPage.doclickRegisterbtn();
		String actRegheader = registrationPage.getPageHeaderText();
		Assert.assertEquals(actRegheader, AppConstants.EXPECTED_REG_PAGE_HEADER);
	}
	
	

}
