package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.DemoPage;
import com.qa.hubspot.utils.Constants;

public class DemoPageTest extends BaseTest {

	@BeforeClass
	public void homePageSetup() {
		demoPage = new DemoPage();

	}

	@Test
	public void checkString() {

		Assert.assertEquals(demoPage.provideAString(), Constants.DEMO_STRING_FOR_DEMO_CLASS);
	}

}
