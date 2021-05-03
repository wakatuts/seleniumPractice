package com.jdbogar.seleniumPractice.dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.jdbogar.seleniumPractice.enums.AutomationEnvironmentType;
import com.jdbogar.seleniumPractice.enums.DriverType;


public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "src//test//resources//test.properties";
	private static ConfigFileReader configFileReader;
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}
	
	
	public static ConfigFileReader getConfigFileReader() {
		return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	}
	
	public String getExcelPath() {
		
		String excelPath = properties.getProperty("excel_data_path");
		if (excelPath != null) {
			return excelPath;
		} else {
			throw new RuntimeException("excel_data_path not specified in the Configuration.properties file");
		}
	}
	
	public String getEnvironment() {
		
		String environment = properties.getProperty("environment");
		if (environment != null) {
			return environment;
		} else {
			throw new RuntimeException("environment not specified in the Configuration.properties file");
		}
	}
	
	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null) {
			return driverPath;
		} else {
			throw new RuntimeException("driverPath not specified in the Configuration.properties file");
		}
	}
	
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName.equals("chrome")) {
			return DriverType.CHROME;
		} else if (browserName.equals("firefox")) {
			return DriverType.FIREFOX;
		} else if (browserName.equals("edge")) {
			return DriverType.EDGE;
		} else {
			throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
		}
	}
	
	public AutomationEnvironmentType getAutomationEnvironment() {
		String environmentName = properties.getProperty("automation_environment");
		if (environmentName.equalsIgnoreCase("local")) {
			return AutomationEnvironmentType.LOCAL;
		} else if (environmentName.equalsIgnoreCase("remote")){
			return AutomationEnvironmentType.REMOTE;
		} else if (environmentName.equalsIgnoreCase("cloud")) {
			return AutomationEnvironmentType.CLOUD;
		}else {
			throw new RuntimeException("Environment Name Key value in Configuration.properties is not matched : " + environmentName);
		}
	}
	
	public Boolean isBrowserMaximumSize() {
		String isWindowMaximize = properties.getProperty("isWindowMaximize");
		return Boolean.parseBoolean(isWindowMaximize);
	}
	
	public String getTestDataResourcePath(){
		
		 String testDataResourcePath = properties.getProperty("testDataResourcePath");
		 if(testDataResourcePath!= null) return testDataResourcePath;
		 else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath"); 
	}
	
	public Boolean isHeadlessMode() {
		
		String isHeadlessMode = properties.getProperty("isHeadlessMode");
		return Boolean.parseBoolean(isHeadlessMode);
	}
	
	public String getHostName() {
		
		String hostName = properties.getProperty("hostName");
		if (hostName != null) {
			return hostName;
		} else {
			throw new RuntimeException("hostName not specified in the Configuration.properties file");
		}
	}
	
	public int getImplicitlyWait() {
		String implicitlyWaitString = properties.getProperty("implicitlyWait");
		if (implicitlyWaitString != null) {
			return Integer.parseInt(implicitlyWaitString);
		} else {
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file");
		}
	}

}
