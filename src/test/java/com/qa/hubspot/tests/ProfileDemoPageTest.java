package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ProfileDemoPage;
import com.qa.hubspot.utils.Constants;

public class ProfileDemoPageTest extends BaseTest {
	
	@BeforeClass
	public void homePageSetup() {
		
		profileDemoPage = new ProfileDemoPage();

	}

	@Test
	public void checkStringProfile() {

		Assert.assertEquals(demoPage.provideAString(), Constants.DEMO_STRING_FOR_PROFILEDEMO_CLASS);
	}

}