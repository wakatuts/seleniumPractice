package com.jdbogar.seleniumPractice.pages;

import org.openqa.selenium.support.FindBy;

import com.jdbogar.seleniumPractice.annotations.PageObject;
import com.jdbogar.seleniumPractice.elements.base.Element;

@PageObject
public class MyAccountPage extends BasePage {
	
	@FindBy(css="a[title='View my customer account'] span")
	private Element loggedAccountName;

	public final Element loggedAccountName() {
		return loggedAccountName;
	}
		
}
