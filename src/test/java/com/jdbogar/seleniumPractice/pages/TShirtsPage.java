package com.jdbogar.seleniumPractice.pages;

import org.openqa.selenium.support.FindBy;

import com.jdbogar.seleniumPractice.annotations.PageObject;
import com.jdbogar.seleniumPractice.elements.base.Element;
import com.jdbogar.seleniumPractice.elements.factory.widget.Label;

@PageObject
public class TShirtsPage extends BasePage {
	
	@FindBy(css="img[title='Faded Short Sleeve T-shirts']")
	private Element fadedShortSleeve;
	
	public final Element fadedShortSleeve() {
		return fadedShortSleeve;
	}

	@FindBy(css="a[title='T-shirts']")
	private Element tShirtsTab;

	public final Element tShirtsTab() {
		return tShirtsTab;
	}
	
	@FindBy(css="button[name='Submit'] span")
	private Element addToCart;

	public final Element addToCart() {
		return addToCart;
	}
	
	@FindBy(xpath="//h2[normalize-space()='Product successfully added to your shopping cart']")
	private Label productAddCartSuccessful;

	public final Label productAddCartSuccessful() {
		return productAddCartSuccessful;
	}
	
	@FindBy(css="a[title='Proceed to checkout'] span")
	private Element proceedToCheckOut;

	public final Element proceedToCheckOut() {
		return proceedToCheckOut;
	}
}
