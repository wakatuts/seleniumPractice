package com.jdbogar.seleniumPractice.tests;

import org.testng.annotations.Test;

import com.jdbogar.seleniumPractice.annotations.PageInstance;
import com.jdbogar.seleniumPractice.annotations.StepInstance;
import com.jdbogar.seleniumPractice.assertions.Verify;
import com.jdbogar.seleniumPractice.common.steps.AuthenticationSteps;
import com.jdbogar.seleniumPractice.common.steps.ShoppingCartSteps;
import com.jdbogar.seleniumPractice.common.steps.TShirtSteps;
import com.jdbogar.seleniumPractice.pages.ShoppingCartPage;
import com.jdbogar.seleniumPractice.pages.TShirtsPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class TestBuyTShirt extends BaseTest{
	
	@StepInstance
	private AuthenticationSteps authenticationSteps;
	
	@StepInstance
	private TShirtSteps tshirtSteps;
	
	@StepInstance
	private ShoppingCartSteps shoppingCartSteps;
	
	@PageInstance
	private TShirtsPage tShirtPage;
	
	@PageInstance
	private ShoppingCartPage shoppingCartPage;
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify user is able to buy TShirt")
	@Test
	public void testBuyTShirt() {
		
		authenticationSteps.logIn(testData.get("emailAddress"), testData.get("password"));
		
		tshirtSteps.clickTShirts();
//		tshirtSteps.selectTShirtSize("M");
		tshirtSteps.addTShirtToCart((String) testData.get("tShirtName"));
		
		verifyAddToCartSuccessful();
		
		tshirtSteps.proceedToCheckOut();
		shoppingCartSteps.finalizeCheckOut();
		
		verifyOrderIsComplete();
	}
	
	@Step("Verify add to cart is successful")
	private void verifyAddToCartSuccessful() {
		Verify.elementIsDisplayed(tShirtPage.productAddCartSuccessful());
	}
	
	@Step("Verify that Order is Complete") 
	private void verifyOrderIsComplete() {
		Verify.elementIsDisplayed(shoppingCartPage.orderComplete());
	}
}
