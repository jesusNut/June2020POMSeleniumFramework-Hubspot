package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {

	private WebDriver driver;
	ElementUtil elementUtil;

	// OR using by locators

	private By header = By.tagName("h1");
	private By settingIcon = By.id("navSetting");
	private By contactsParentMenu = By
			.xpath("(//a[@id='nav-primary-contacts-branch'])[position()=1]");
	private By contactsSubMenu = By
			.xpath("(//a[@id='nav-secondary-contacts'])[position()=1]");
	private By salesParentmenu = By.xpath("(//*[@id='nav-primary-sales-branch'])[position()=1]");
	
	private By dealsSubMenu = By.xpath("(//*[@id='nav-secondary-deals'])[position()=1]");
	

	// constructor of the page

	public HomePage(WebDriver driver) {

		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	// page actions

	public String getHomePageTitle() {

		return elementUtil.waitForTitlePresent(Constants.HOME_PAGE_TITLE, 10);

	}

	public String getheaderValue() {
		
		elementUtil.waitForSingleElementToBeVisible(header, 20);

		if (elementUtil.doIsDisplayed(header)) {

			return elementUtil.doGetText(header);

		}

		return null;

	}

	public Boolean isSettingIconExist() {
		
		elementUtil.waitForSingleElementToBeVisible(settingIcon, 20);

		return elementUtil.doIsDisplayed(settingIcon);

	}
	
	//method causing navigation to Contacts page

	public ContactsPage gotToContactsPage() {

		clickOnContacts();

		return new ContactsPage(driver);

	}
	


	private void clickOnContacts() {

		elementUtil.waitForSingleElementToBeVisible(contactsParentMenu, 20);
		elementUtil.doClick(contactsParentMenu);
		elementUtil.waitForSingleElementToBeVisible(contactsSubMenu, 20);
		elementUtil.doClick(contactsSubMenu);

	}
	
	//method causing navigation to Deals page
	
	public DealsPage goToDealsPage() {

		clickOnDeals();
		
		return new DealsPage(driver);

	}
	
	public void clickOnDeals() {
		
		elementUtil.waitForSingleElementToBeVisible(salesParentmenu, 10);
		elementUtil.doClick(salesParentmenu);
		elementUtil.waitForSingleElementToBeVisible(dealsSubMenu, 10);
		elementUtil.doClick(dealsSubMenu);
		
	}



}
