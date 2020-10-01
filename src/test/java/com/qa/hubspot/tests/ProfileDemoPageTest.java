package com.qa.hubspot.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ProfileDemoPage;
import com.qa.hubspot.utils.Constants;

public class ProfileDemoPageTest extends BaseTest {

	public Logger log = Logger.getLogger(ProfileDemoPageTest.class);

	@BeforeClass
	public void homePageSetup() {

		log.warn("Initializing-----------*************---------homePageSetup()");

		profileDemoPage = new ProfileDemoPage();

	}

	@Test
	public void checkStringProfile() {

		log.warn("starting ----------->>>>>>>>>>>>>>---------checkStringProfile()");

		
		Assert.assertEquals(profileDemoPage.provideAStringProfile(), Constants.DEMO_STRING_FOR_PROFILEDEMO_CLASS);

		log.warn("ending ----------->>>>>>>>>>>>>>---------checkStringProfile()");
	}

}