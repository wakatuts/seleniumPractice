package com.jdbogar.seleniumPractice.tests;

import java.util.Map;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.IHookCallBack;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.jdbogar.seleniumPractice.context.TestContext;
import com.jdbogar.seleniumPractice.dataProviders.ExcelData;
import com.jdbogar.seleniumPractice.dataProviders.ExcelDataReader;
import com.jdbogar.seleniumPractice.driver.Driver;
import com.jdbogar.seleniumPractice.listeners.DirtiesContextListener;
import com.jdbogar.seleniumPractice.listeners.WebDriverListener;


@Listeners(WebDriverListener.class)
@ContextConfiguration(classes = {TestContext.class})
@TestPropertySource(locations="classpath:test.properties")
@TestExecutionListeners(listeners = DirtiesContextListener.class, mergeMode = MergeMode.MERGE_WITH_DEFAULTS)
public class BaseTest extends AbstractTestNGSpringContextTests{
	
    @Value("${url}")
    protected String url;
    
    protected Map<String, Object> testData;
    
	@Override
    public void run(@NotNull IHookCallBack callBack, ITestResult testResult) {
        ExcelDataReader reader = ExcelData.getTestData();
        testData = reader.getExcelTestData();
		super.run(callBack, testResult);
    }
	
	@BeforeMethod
	public void initialize() {
		System.out.println("opening browser");
		WebDriver driver = Driver.getDriver();
        driver.get(url);
	}
	
}
