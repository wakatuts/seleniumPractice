package com.jdbogar.seleniumPractice.common.steps;

import com.jdbogar.seleniumPractice.annotations.CommonStep;
import com.jdbogar.seleniumPractice.annotations.PageInstance;
import com.jdbogar.seleniumPractice.pages.HomePage;
import com.jdbogar.seleniumPractice.pages.TShirtsPage;

import io.qameta.allure.Step;

@CommonStep
public class TShirtSteps {
	
	@PageInstance
	private HomePage homePage;
	
	@PageInstance
	private TShirtsPage tShirtsPage;
	
	@Step("adding {tShirt} to cart")
	public void addTShirtToCart(String tShirt) {
		switch (tShirt) {
		case "Faded Short Sleeve T-shirts":
			tShirtsPage.fadedShortSleeve().click();
			tShirtsPage.addToCart().click();
			break;
		default:
			break;
		}
	}
	
	@Step("Click TShirts Tab")
	public void clickTShirts() {
		tShirtsPage.forceClick(tShirtsPage.tShirtsTab());
	}
	
	@Step("Proceeding to Checkout")
	public void proceedToCheckOut() {
		tShirtsPage.proceedToCheckOut().click();
	}
	
	

}
