package com.qa.hubspot.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

public class LoginPageTest extends BaseTest{
	
	public Logger log = Logger.getLogger(LoginPageTest.class);
		

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		
		log.info("starting ----------->>>>>>>>>>>>>>---------verifyLoginPageTitleTest()");

		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		
		log.info("ending ----------->>>>>>>>>>>>>>---------verifyLoginPageTitleTest()");

	}

	@Test(priority = 2)
	public void verifySignUpLinkTest() {
		
		log.info("starting ----------->>>>>>>>>>>>>>---------verifySignUpLinkTest()");

		Assert.assertTrue(loginPage.isSignUpLinkExist());
		
		log.info("ending ----------->>>>>>>>>>>>>>---------verifySignUpLinkTest()");

	}

	@Test(priority = 3)
	public void loginTest() {
		
		log.info("starting ----------->>>>>>>>>>>>>>---------loginTest())");

		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		
		log.info("ending ----------->>>>>>>>>>>>>>---------loginTest())");

	}

	
}
