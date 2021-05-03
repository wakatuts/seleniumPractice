package com.jdbogar.seleniumPractice.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.jdbogar.seleniumPractice.dataProviders.ConfigFileReader;
import com.jdbogar.seleniumPractice.enums.AutomationEnvironmentType;
import com.jdbogar.seleniumPractice.enums.DriverType;

public class WebDriverManager {
	
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static ConfigFileReader configFileReader;
	private static WebDriver driver;
	private static AutomationEnvironmentType automationEnvironment;
	private static DriverType driverType;

	public static WebDriver createInstance() {
		
		configFileReader = ConfigFileReader.getConfigFileReader();
		automationEnvironment = configFileReader.getAutomationEnvironment();
		driverType = configFileReader.getBrowser();
		
		WebDriver driver = null;
		
		switch (automationEnvironment) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		default:
			break;
		}
		return driver;
	}
	
	private static WebDriver createLocalDriver() {
		switch (driverType) {
		case FIREFOX: 
			driver = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY, configFileReader.getDriverPath());
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--incognito");
			
			if(configFileReader.isHeadlessMode()) {
				chromeOptions.addArguments("--headless");
				chromeOptions.addArguments("--disable-gpu");
			}

			if (configFileReader.isBrowserMaximumSize()) {
				chromeOptions.addArguments("--window-size=1920,1080");			
			}
			
			driver = new ChromeDriver(chromeOptions);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
			break;
		case EDGE: 
			driver = new EdgeDriver();
			break;
		}
		
		return driver;
		
	}
	
	
	private static WebDriver createRemoteDriver() {
		String hostName = configFileReader.getHostName();
		switch (driverType) {
		case FIREFOX: 
			throw new RuntimeException("FireFoxRemoteDriver is not yet implemented");
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY, configFileReader.getDriverPath());
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--incognito");
			
			if(configFileReader.isHeadlessMode()) {
				chromeOptions.addArguments("--headless");
				chromeOptions.addArguments("--disable-gpu");
			}

			if (configFileReader.isBrowserMaximumSize()) {
				chromeOptions.addArguments("--window-size=1920,1080");			
			}
			
			try {
				driver = new RemoteWebDriver(new URL("http://"+hostName+":4444/wd/hub"), chromeOptions);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
			break;
		case EDGE: 
			throw new RuntimeException("EdgeRemoteDriver is not yet implemented");
		}

		return driver;
		
	}

}
