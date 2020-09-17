package com.qa.hubspot.base;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.DealsPage;
import com.qa.hubspot.pages.DemoPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.ProfileDemoPage;

public class BaseTest {

	WebDriver driver;
	public BasePage basePage;
	public LoginPage loginPage;
	public Properties prop;
	public HomePage homePage;
	public ContactsPage contactsPage;
	public DealsPage dealsPage;
	public DemoPage demoPage;
	public ProfileDemoPage profileDemoPage;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void setUp(@Optional("chrome") String browserName, @Optional("https://app.hubspot.com/") String url) {

		basePage = new BasePage();
		prop = basePage.init_prop();
		prop.setProperty("browser", browserName);
		prop.setProperty("url", url);
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
