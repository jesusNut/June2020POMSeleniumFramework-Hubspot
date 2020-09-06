package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

public class HomePageTest extends BaseTest {

	

	@BeforeClass
	public void homePageSetup() {

		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void verifyHomePageTitleTest() {

		String title = homePage.getHomePageTitle();

		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);

	}

	@Test
	public void verifyHomePageHeaderTest() {

		String header = homePage.getheaderValue();

		System.out.println("the header value is : " + header);

		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);

	}

	@Test
	public void verifySettingIconTest() {

		Assert.assertTrue(homePage.isSettingIconExist());

	}


}
