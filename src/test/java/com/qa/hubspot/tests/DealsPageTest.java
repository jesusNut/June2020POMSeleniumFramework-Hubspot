package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ExcelUtil;

public class DealsPageTest extends BaseTest {
	
	@BeforeClass
	public void homePageSetup() {

		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		dealsPage = homePage.goToDealsPage();
		
	}
	
	@Test(priority = 1)
	public void verifyDealsPageTitleTest() {

		String title = dealsPage.getDealsPageTitle();
		System.out.println("Deals page title is : " + title);
		Assert.assertEquals(title, Constants.DEALS_PAGE_TITLE);

	}

	@Test(priority = 2)
	public void verifyDealsPageHeaderTest() {

		String header = dealsPage.getDealsPageHeader();
		System.out.println("Delas page header is : " + header);
		Assert.assertEquals(header, Constants.DEALS_PAGE_HEADER);

	}
	
	@DataProvider()
	public Object[][] getDealsTestData() {

		Object[][] data = ExcelUtil.getTestData(Constants.DEALS_SHEET_NAME);
		return data;

	}
	
	
	@Test(priority = 3, dataProvider = "getDealsTestData")
	public void createDealTest(String nameOFDeal, String typeOfDeal, String amount) {
		
	 dealsPage.createDeal(nameOFDeal, typeOfDeal, amount);
	//Assert.assertEquals(textFoundOnNextPage, "$6,999 nirma saabun");
		
		
	}



}
