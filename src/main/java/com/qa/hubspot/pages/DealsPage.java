package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class DealsPage extends BasePage {

	private WebDriver driver;
	ElementUtil elementUtil;

	// OR using by locators

	private By dealsPageHeader = By.xpath("(//h1)[position()=2]/span");
	private By createDealPrimaryButton = By.xpath("//button[./span/span[text()='Create deal']]");
	private By dealNameTextBox = By.xpath("//input[@data-field='dealname']");
	private By dealStageDropDownButton = By.xpath("//span[text()='Appointment scheduled']");
	private By dealStageDropDownOptions = By.xpath("//ul[@id='typeahead-52']/li/span/button/span/span/span");
	private By amountTextBox = By.xpath("//input[@data-field='amount']");
	private By createDealSecondaryButton = By.xpath("//button[@data-selenium-test='base-dialog-confirm-btn']");
//	private By nextPageTitleVerifier = By.xpath("//span[@data-selenium-test='highlightTitle']");
	private By navigateBackToAllDealsPage = By.xpath("(//i18n-string[@data-key='profileHeader.backButton.DEAL'])[position()='2']");

	// constructor of the page

	public DealsPage(WebDriver driver) {

		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	// page actions

	public String getDealsPageTitle() {

		return elementUtil.waitForTitlePresent(Constants.DEALS_PAGE_TITLE, 10);

	}

	public String getDealsPageHeader() {

		elementUtil.waitForSingleElementToBeVisible(dealsPageHeader, 10);
		return elementUtil.doGetText(dealsPageHeader);

	}

	public void createDeal(String dealName, String dealStage, String amount) {

		elementUtil.waitForSingleElementToBeVisible(createDealPrimaryButton, 10);
		elementUtil.doClick(createDealPrimaryButton);
		elementUtil.waitForSingleElementToBeVisible(dealNameTextBox, 10).sendKeys(dealName);
		elementUtil.clickWhenReady(dealStageDropDownButton, 10);
		elementUtil.selectValueFromDropDownWithOutSelect(dealStageDropDownOptions, dealStage);
		elementUtil.waitForSingleElementToBeVisible(amountTextBox, 10).sendKeys(amount);
		elementUtil.doClick(createDealSecondaryButton);
//		elementUtil.waitForSingleElementToBeVisible(nextPageTitleVerifier, 10);
//		return elementUtil.doGetText(nextPageTitleVerifier);
		elementUtil.waitForSingleElementToBeVisible(navigateBackToAllDealsPage, 22).click();
		
	}

}
