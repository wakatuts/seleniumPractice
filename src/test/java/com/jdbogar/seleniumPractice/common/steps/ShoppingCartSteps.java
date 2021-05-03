package com.jdbogar.seleniumPractice.common.steps;

import com.jdbogar.seleniumPractice.annotations.CommonStep;
import com.jdbogar.seleniumPractice.annotations.PageInstance;
import com.jdbogar.seleniumPractice.pages.ShoppingCartPage;

import io.qameta.allure.Step;

@CommonStep
public class ShoppingCartSteps {
	
	@PageInstance
	private ShoppingCartPage shoppingCartPage;
	
	@Step("Finalizing Checkout in Shopping Cart")
	public void finalizeCheckOut() {
		shoppingCartPage.proceedToCheckOut().click();
		shoppingCartPage.proceedToCheckOutinAddress().click();
		shoppingCartPage.agreeToTermsAndService().check();
		shoppingCartPage.proceedToCheckOutinShipping().click();
		shoppingCartPage.payByBankWire().click();
		shoppingCartPage.confirmOrder().submit();
	}

}
