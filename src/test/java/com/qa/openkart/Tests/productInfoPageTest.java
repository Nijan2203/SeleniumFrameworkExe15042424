package com.qa.openkart.Tests;

import org.testng.annotations.BeforeClass;

import com.qa.openkart.base.BaseTest;
import com.qa.openkart.constants.AppConstants;

public class productInfoPageTest extends BaseTest {
	
	@BeforeClass
	public void doLoginPageSetup(){
		accountPage = loginPage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		
		
		
	}
	
	


}
