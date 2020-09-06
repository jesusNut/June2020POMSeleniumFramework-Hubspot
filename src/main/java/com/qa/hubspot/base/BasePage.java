package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.hubspot.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Ankush420
 * 
 * 
 */

public class BasePage {

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	Properties prop;
	OptionsManager optionsManager;
	public static String flashElement;
	public String env = null;

	/**
	 * This method is used to initialize the webdriver on the basis of provided
	 * browser name
	 * 
	 * @param browsername
	 * @return this returns the driver instance
	 */

	public WebDriver init_driver(Properties prop) {

		flashElement = prop.getProperty("highlight");

		String browsername = prop.getProperty("browser").trim();

		System.out.println("Browser name is : " + browsername);

		optionsManager = new OptionsManager(prop);

		if (browsername.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			// driver = new ChromeDriver(optionsManager.getChromeOptions());

			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));

		}

		else if (browsername.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			// driver = new FirefoxDriver();

			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));

		}

		else

			System.out.println("Please pass the correct browser name " + browsername);

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		// getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url").trim());

		return getDriver();

	}

	/**
	 * This method is used to get the properties value from config file Environment
	 * properties are passed using the maven command line
	 * 
	 * @return it return prop (properties instance)
	 */

	public Properties init_prop() {

		String path = null;

		prop = new Properties();

		try {

			env = System.getProperty("env");

			// logic to print the name of the environment on console- for NUll, provide env
			// as "PRODUCTION-DEFAULT"

			if (this.env == null) {

				System.out.println("Runnning on environment : " + "PRODUCTION-DEFAULT");
			}

			else {

				System.out.println("Runnning on environment : " + env);
			}

			// logic to create a configuration property files-String path- based on env name

			if (this.env == null) {

				path = "./src/main/java/com/qa/hubspot/config/config.properties";

			} else {
				switch (env) {
				case "qa":
					path = "./src/main/java/com/qa/hubspot/config/config.qa.properties";
					break;
				case "dev":
					path = "./src/main/java/com/qa/hubspot/config/config.dev.properties";
					break;

				default:
					System.out.println(" INVALID ENVIRONMENT NAME");
					break;
				}

			}

			FileInputStream ip = new FileInputStream(path);

			prop.load(ip);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return prop;

	}

	/**
	 * 
	 * @return this method returns the threadlocal webdriver
	 */
	public static synchronized WebDriver getDriver() {

		return tlDriver.get();

	}

	public String getScreenshot() {

		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";

		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return path;

	}

}
