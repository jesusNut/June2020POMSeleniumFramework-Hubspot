package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class ContactsPage extends BasePage {

	private WebDriver driver;
	ElementUtil elementUtil;

	// OR using by locators

	private By header = By.xpath("//h1[contains(@class,'IndexPageRedesignHeader')]/span");
	private By createContactPrimary = By.xpath("//span[text()='Create contact']");
	private By emailId = By.xpath("//input[@data-field='email']");
	private By firstName = By.xpath("//input[@data-field='firstname']");
	private By lastName = By.xpath("//input[@data-field='lastname']");
	private By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	private By createContactSecondary = By.xpath("(//span[text()='Create contact'])[position()=2]");
	private By contactsBackLink = By.xpath("//div[@class='UIAbstractColumn__ColumnWrapper-vkv1rx-0 ggAAfp UIColumn-content']//i18n-string[contains(text(),'Contacts')]");
	private By jobTitleRestricter = By.xpath("//div[@class='private-modal__container']");
	private By totalContactsCount = By.xpath("//h1[contains(@class,'IndexPageRedesignHeader')]/div/i18n-string");

	// constructor of the page

	public ContactsPage(WebDriver driver) {

		this.driver = driver;

		elementUtil = new ElementUtil(driver);
	}

	// page actions

	public String getContactsPageTitle() {

		return elementUtil.waitForTitlePresent(Constants.CONTACTS_PAGE_TITLE, 10);

	}

	public String getContactsPageHeader() {

		elementUtil.waitForElementPresent(header, 10);
		return elementUtil.doGetText(header);

	}

	public boolean createContact(String emailId, String firstname, String lastName, String jobTitle) {

		elementUtil.clickWhenReady(createContactPrimary, 10);
		elementUtil.waitForSingleElementToBeVisible(this.emailId, 10);
		elementUtil.doSendKeys(this.emailId, emailId);
		elementUtil.doSendKeys(this.firstName, firstname);
		elementUtil.doSendKeys(this.lastName, lastName);

		// handling job title sync issue

		elementUtil.waitForElementToBeInVisible(jobTitleRestricter, 10);

		elementUtil.waitForSingleElementToBeVisible(this.jobTitle, 20);
		elementUtil.doSendKeys(this.jobTitle, jobTitle);
		elementUtil.clickWhenReady(this.createContactSecondary, 10);

		// use of dynamic data: the below By locator cannot be used as OR as the data
		// depends on parameters passed in method

		boolean userCreationStatus = elementUtil
				.waitForSingleElementToBeVisible(By.xpath("(//span[text()='" + firstname + " " + lastName + "'])[position()=2]"), 30)
				.isDisplayed();

		elementUtil.clickWhenReady(contactsBackLink, 12);
		return userCreationStatus;

	}
	
	public boolean CheckContactsCreated() {
		
		return elementUtil.waitTillAttributeContains(totalContactsCount, 10, "innerHTML", "1");
	}

}
