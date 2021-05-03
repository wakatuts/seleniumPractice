package com.jdbogar.seleniumPractice.pages;

import org.openqa.selenium.support.FindBy;

import com.jdbogar.seleniumPractice.annotations.PageObject;
import com.jdbogar.seleniumPractice.elements.base.Element;
import com.jdbogar.seleniumPractice.elements.factory.widget.CheckBox;
import com.jdbogar.seleniumPractice.elements.factory.widget.Label;

@PageObject
public class ShoppingCartPage extends BasePage {

	@FindBy(css="p a[title='Proceed to checkout']")
	private Element proceedToCheckOut;

	public final Element proceedToCheckOut() {
		return proceedToCheckOut;
	}
	
	@FindBy(name="processAddress")
	private Element proceedToCheckOutinAddress;
	
	public final Element proceedToCheckOutinAddress() {
		return proceedToCheckOutinAddress;
	}
	
	@FindBy(name="processCarrier")
	private Element proceedToCheckOutinShipping;
	
	public final Element proceedToCheckOutinShipping() {
		return proceedToCheckOutinShipping;
	}
	
	@FindBy(id="cgv")
	private CheckBox agreeToTermsAndService;
	
	public final CheckBox agreeToTermsAndService() {
		return agreeToTermsAndService;
	}
	
	@FindBy(className="bankwire")
	private Element payByBankWire;
	
	public final Element payByBankWire() {
		return payByBankWire;
	}

	@FindBy(css="p button")
	private Element confirmOrder;
	
	public final Element confirmOrder() {
		return confirmOrder;
	}

	@FindBy(xpath="//strong[normalize-space()='Your order on My Store is complete.']")
	private Label orderComplete;
	
	public final Label orderComplete() {
		return orderComplete;
	}
}
