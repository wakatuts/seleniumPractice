package com.jdbogar.seleniumPractice.listeners;

import com.jdbogar.seleniumPractice.assertions.Verify;
import com.jdbogar.seleniumPractice.dataProviders.ConfigFileReader;
import com.jdbogar.seleniumPractice.dataProviders.ExcelData;
import com.jdbogar.seleniumPractice.dataProviders.ExcelDataReader;
import com.jdbogar.seleniumPractice.driver.Driver;
import io.qameta.allure.Attachment;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebDriverListener implements IInvokedMethodListener, StepLifecycleListener{
	
	private ThreadLocal<ITestResult> testResultThread = new ThreadLocal<ITestResult>();
	private ConfigFileReader configFileReader;
	
	@Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

        if(method.isTestMethod()) {
        	
        	configFileReader = ConfigFileReader.getConfigFileReader();
        	
        	String methodName = method.getTestMethod().getMethodName();
        	String excelPath = System.getProperty("user.dir")+configFileReader.getExcelPath()+"\\"+configFileReader.getEnvironment()+"Regression.xlsx";
        
        	System.out.println("Running test --> " + methodName);
        	
        	ExcelDataReader reader = new ExcelDataReader();
        	reader.setExcelParam(excelPath, methodName);
        	ExcelData.setReader(reader);
        	
        	Verify.setAssert(new SoftAssertions());
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

        if(method.isTestMethod()) {
        	
        	setTestResult(testResult);
        	
            WebDriver driver = Driver.getDriver();
            if(driver != null) {

                try {
                    takeScreenshotOnFailure(testResult);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Closing webdriver session: " + Thread.currentThread().getId());
                driver.quit();
                Driver.removeDriver();
            }
        }
    }

    public void takeScreenshotOnFailure(ITestResult testResult) throws IOException {

        if(testResult.getStatus() == ITestResult.FAILURE) {

            File screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            File destination = new File("target/failure-screenshots/" + testResult.getName() + "-"
                    + new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date()) + ".png");
            FileUtils.copyFile(screenShot, destination);

            InputStream screenShotStream = new FileInputStream(destination);
            byte[] screen = IOUtils.toByteArray(screenShotStream);

            saveScreenshot(screen);
        }
    }

    @Attachment(value = "Screenshot of the failure", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {

        return screenShot;
    }
    
    private void setTestResult (ITestResult testResult) {
    	this.testResultThread.set(testResult);
    }
    
    private ITestResult getTestResult() {
    	return this.testResultThread.get();
    }
    
    @Override
    public void afterStepStop (StepResult result) {
    	
    	if (getTestResult().getStatus() == ITestResult.FAILURE) {
			result.setStatus(Status.FAILED);
		} else if (getTestResult().getStatus() == ITestResult.SUCCESS) {
			result.setStatus(Status.PASSED);
		} else if (getTestResult().getStatus() == ITestResult.SKIP) {
			result.setStatus(Status.SKIPPED);
		}
    }

}
