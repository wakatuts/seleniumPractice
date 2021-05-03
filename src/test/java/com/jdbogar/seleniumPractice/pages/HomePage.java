package com.jdbogar.seleniumPractice.pages;

import org.openqa.selenium.support.FindBy;

import com.jdbogar.seleniumPractice.annotations.PageObject;
import com.jdbogar.seleniumPractice.elements.base.Element;

@PageObject
public class HomePage extends BasePage {
	
	@FindBy(className="login")
	private Element signInButton;

	public final Element signInButton() {
		return signInButton;
	}
}
