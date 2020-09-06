package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

public class LoginPageTest extends BaseTest{

	

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {

		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);

	}

	@Test(priority = 2)
	public void verifySignUpLinkTest() {

		Assert.assertTrue(loginPage.isSignUpLinkExist());

	}

	@Test(priority = 3)
	public void loginTest() {

		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

	}

	
}
