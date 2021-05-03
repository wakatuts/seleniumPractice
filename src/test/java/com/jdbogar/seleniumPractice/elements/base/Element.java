package com.jdbogar.seleniumPractice.elements.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.internal.WrapsElement;

import com.jdbogar.seleniumPractice.annotations.ImplementedBy;

@ImplementedBy(ElementImpl.class)
public interface Element extends WebElement, WrapsElement, Locatable{

	boolean elementWired();
}
