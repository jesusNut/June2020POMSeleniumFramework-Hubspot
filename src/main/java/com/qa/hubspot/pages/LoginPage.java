package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class LoginPage extends BasePage {

	private WebDriver driver;

	ElementUtil elementUtil;

	// OR using by locators

	By emailId = By.id("username");

	By password = By.id("password");

	By loginButton = By.cssSelector("#loginBtn");

	By signUpLink = By.xpath("//i18n-string[text()='Sign up']");

	// constructor of the page

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		elementUtil = new ElementUtil(driver);
	}

	// page actions

	public String getLoginPageTitle() {

		return elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);

	}

	public Boolean isSignUpLinkExist() {
		
		elementUtil.waitForSingleElementToBeVisible(signUpLink, 20);
     	return elementUtil.doIsDisplayed(signUpLink);

	}

	public HomePage doLogin(String un, String pwd) {

		elementUtil.waitForSingleElementToBeVisible(emailId, 12);
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);

		// page chaining- login page's doLogin () method returns object of landing page
		// i.e. HomePage

		return new HomePage(driver);

	}

}