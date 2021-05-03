package com.jdbogar.seleniumPractice.elements.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;

public class ElementImpl implements Element{

	private final WebElement element;
	
	public ElementImpl(final WebElement element) {
		this.element = element;
	}
	
	@Override
	public void click() {
		element.click();
		
	}

	@Override
	public void submit() {
		element.submit();
		
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		element.sendKeys(keysToSend);
		
	}

	@Override
	public void clear() {
		element.clear();
		
	}

	@Override
	public String getTagName() {
		return element.getTagName();
	}

	@Override
	public String getAttribute(String name) {
		return element.getAttribute(name);
	}

	@Override
	public boolean isSelected() {
		return element.isSelected();
	}

	@Override
	public boolean isEnabled() {
		return element.isEnabled();
	}

	@Override
	public String getText() {
		return element.getText();
	}

	@Override
	public List<WebElement> findElements(By by) {
		return element.findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		return element.findElement(by);
	}

	@Override
	public boolean isDisplayed() {
		return element.isDisplayed();
	}

	@Override
	public Point getLocation() {
		return element.getLocation();
	}

	@Override
	public Dimension getSize() {
		return element.getSize();
	}

	@Override
	public Rectangle getRect() {
		return element.getRect();
	}

	@Override
	public String getCssValue(String propertyName) {
		return element.getCssValue(propertyName);
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		throw new UnsupportedOperationException("getScreenshotAs() not yet implemented");
	}

	@Override
	public WebElement getWrappedElement() {
		return element;
	}

	@Override
	public Coordinates getCoordinates() {
		return ((Locatable) element).getCoordinates();
	}

	@Override
	public boolean elementWired() {
		return (element != null);
	}


}
