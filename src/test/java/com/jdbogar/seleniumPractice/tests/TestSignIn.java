package com.jdbogar.seleniumPractice.tests;

import org.testng.annotations.Test;

import com.jdbogar.seleniumPractice.annotations.PageInstance;
import com.jdbogar.seleniumPractice.annotations.StepInstance;
import com.jdbogar.seleniumPractice.assertions.Verify;
import com.jdbogar.seleniumPractice.common.steps.AuthenticationSteps;
import com.jdbogar.seleniumPractice.pages.MyAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class TestSignIn extends BaseTest {
	
	@PageInstance
	private MyAccountPage myAccountPage;
	
	@StepInstance
	private AuthenticationSteps authenticationSteps;
	
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify acccount is successfully created")
	@Test
	public void testSignIn() {
		authenticationSteps.createRandomAccount(testData);
		
		verifyAccountCreationSuccessful(myAccountPage.loggedAccountName().getText(), testData.get("firstName")+" "+testData.get("lastName"));
		verifySoftAssertion("test", "test2");
		verifySoftAssertion("test", "test");

		
	}
	
	@Step("Verify Account Creation for {expected} Successful")
	private void verifyAccountCreationSuccessful(String actual, String expected) {
		Verify.equals(actual, expected);
	}
	
	
	@Step("Verify {actual} is equal to {expected}")
	private void verifySoftAssertion(String actual, String expected) {
		Verify.equalsAndContinueOnFailure(actual, expected);
		Verify.assertAll();
	}
	

}
