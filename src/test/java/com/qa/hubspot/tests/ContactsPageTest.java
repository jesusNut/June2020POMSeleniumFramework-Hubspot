package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.listeners.TestAllureListener;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ExcelUtil;



@Listeners(TestAllureListener.class)
public class ContactsPageTest extends BaseTest {

	@BeforeClass
	public void homePageSetup() {

		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.gotToContactsPage();

	}

	@Test(priority = 1)
	public void verifyContactsPageTitleTest() {
		String title = contactsPage.getContactsPageTitle();
		System.out.println("Contacts pa ge title is : " + title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);

	}

	@Test(priority = 3)
	public void verifyContactsPageHeaderTest() {
		String header = contactsPage.getContactsPageHeader();
		System.out.println("Contacts page header is : " + header);
		Assert.assertTrue(header.contains("Contacts"));

	}

	@DataProvider()
	public Object[][] getContactsTestData() {

		Object[][] data = ExcelUtil.getTestData(Constants.CONTACTS_SHEET_NAME);
		return data;

	}

	@Test(priority = 2,dataProvider ="getContactsTestData")
	public void createContactTest(String email, String firstName, String lastName, String jobTitle) {
		boolean status = contactsPage.createContact(email, firstName, lastName, jobTitle);
        Assert.assertTrue(status);

	}

//	@Test(priority = 4)
//	public void checkCreationOfNewContact() {
//
//		Assert.assertTrue(contactsPage.CheckContactsCreated());
//
//	}

}
