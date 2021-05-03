package com.jdbogar.seleniumPractice.common.steps;

import java.util.Map;

import com.jdbogar.seleniumPractice.annotations.CommonStep;
import com.jdbogar.seleniumPractice.annotations.PageInstance;
import com.jdbogar.seleniumPractice.pages.AuthenticationPage;
import com.jdbogar.seleniumPractice.pages.HomePage;
import com.jdbogar.seleniumPractice.utilities.DateUtils;
import com.jdbogar.seleniumPractice.utilities.RandomDataUtils;

import io.qameta.allure.Step;


@CommonStep
public class AuthenticationSteps {
	
	@PageInstance
	private HomePage homePage;
	
	@PageInstance
	private AuthenticationPage authenticationPage;

	public AuthenticationSteps() {
		// TODO Auto-generated constructor stub
	}
	
	@Step("Create random account")
	public void createRandomAccount(Map<String, Object> testData) {
		Map<String,String> dateOfBirth;
		
		homePage.signInButton().click();
		
		authenticationPage.createAnAccount().emailAddress().set(RandomDataUtils.generateRandomString(10)+"test@email.com");
		authenticationPage.createAnAccount().createAccountButton().click();
		authenticationPage.createAnAccount().mrsRadioButton().click();
		authenticationPage.createAnAccount().yourPersonalInfoFirstName().set(testData.get("firstName"));
		authenticationPage.createAnAccount().yourPersonalInfoLastName().set(testData.get("lastName"));
		authenticationPage.createAnAccount().password().set(testData.get("lastName"));
		dateOfBirth = DateUtils.separateDate(testData.get("birthDate"),"MM/dd/yyyy");
		authenticationPage.createAnAccount().day().selectByValue(dateOfBirth.get("day"));
		authenticationPage.createAnAccount().month().selectByIndex(Integer.valueOf(dateOfBirth.get("month")));
		authenticationPage.createAnAccount().year().selectByValue(dateOfBirth.get("year"));
		
		authenticationPage.createAnAccount().yourAddressFirstName().set(testData.get("firstName"));
		authenticationPage.createAnAccount().yourAddressLastName().set(testData.get("lastName"));
		authenticationPage.createAnAccount().company().set(testData.get("lastName"));
		authenticationPage.createAnAccount().addressLine1().set(testData.get("addressLine1"));
		authenticationPage.createAnAccount().addressLine2().set(testData.get("addressLine2"));
		authenticationPage.createAnAccount().city().set(testData.get("lastName"));
		authenticationPage.createAnAccount().yourAddressLastName().set(testData.get("lastName"));
		authenticationPage.createAnAccount().state().selectByVisibleText((String)testData.get("state"));
		authenticationPage.createAnAccount().zipCode().set((String)testData.get("zip"));
		authenticationPage.createAnAccount().country().selectByVisibleText((String)testData.get("country"));
		authenticationPage.createAnAccount().additionalInfo().set(testData.get("additionalInfo"));
		authenticationPage.createAnAccount().homePhone().set(testData.get("homePhone"));
		authenticationPage.createAnAccount().mobilePhone().set(testData.get("mobilePhone"));
		authenticationPage.createAnAccount().addressAlias().set(testData.get("addressAlias"));
		authenticationPage.createAnAccount().registerButton().click();
	}
	
	@Step("Log in to {emailAddress}")
	public void logIn(Object emailAddress, Object password) {
		homePage.signInButton().click();
		
		authenticationPage.alreadyRegistered().emailAddress().set(emailAddress);
		authenticationPage.alreadyRegistered().password().set(password);
		authenticationPage.alreadyRegistered().signInButton().click();
	}

}
