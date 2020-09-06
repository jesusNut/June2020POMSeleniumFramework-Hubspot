package com.qa.hubspot.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.DealsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class BaseTest {

	WebDriver driver;
	public BasePage basePage;
	public LoginPage loginPage;
	public Properties prop;
	public HomePage homePage;
	public ContactsPage contactsPage;
	public DealsPage dealsPage;
	
	@Parameters({"browser","url"})
	@BeforeTest
	public void setUp(@Optional ("chrome") String browserName,@Optional ("https://app.hubspot.com/") String url) {

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
