package com.jdbogar.seleniumPractice.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jdbogar.seleniumPractice.elements.base.Element;

public abstract class BasePage{
	
	protected WebDriver driver;
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElement(final WebElement webElement, final long timeOut) {
		
		final WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
	
	public void waitForOneOfElements(final long timeOut, final WebElement ... webElements) {
		
		List<WebElement> elements = Arrays.asList(webElements);
		Object[] expectedConditionsArray = elements.stream().map(element -> ExpectedConditions.elementToBeClickable(element)).toArray();
		final WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.or((ExpectedCondition<?>[]) expectedConditionsArray));
	}

	public void waitForElementAttribute(final WebElement webElement, final String attribute, final String value, final long timeOut) {
		
		final WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.attributeContains(webElement, attribute, value));
	}
	
	public void waitForElementInvisibility(final By locator, final long timeOut) {
		
		final WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public void sendEnterKey(final WebElement webElement) {
		
		webElement.sendKeys(Keys.RETURN);
	}
	
	public void selectValueFromDropdown(final WebElement dropdownWebElement, final String requiredText) {
		
		final Select dropdown = new Select(dropdownWebElement);
		dropdown.deselectByVisibleText(requiredText);
	}
	
	public WebElement selectWebElementWithTextFromList(final List<WebElement> webElementList, final String requiredText){
		
		for (final WebElement webElement : webElementList) {
			if (webElement.getText().toLowerCase().replaceAll("\\s+", " ").contains(requiredText.toLowerCase().replaceAll("\\s+", " "))) {
				return webElement;
			}
		}
		return null;
	}
	
	public String getSelectedOptionFromDropdown(final WebElement dropdownWebElement) {
		
		final Select dropdown = new Select(dropdownWebElement);
		final WebElement option = dropdown.getFirstSelectedOption();
		final String selectedOption = option.getText();
		return selectedOption;
	}
	
	public void disable(final WebElement webElement) {
		
		final JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('disabled', '');", webElement);
	}
	
	public void hide(final WebElement webElement) {
		
		final JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'display: none');", webElement);
	}
	
	public boolean isElementPresent(final WebElement webElement) {
		
		boolean present = false;
		try {
			if (webElement.isDisplayed() && webElement.isEnabled()) {
				final Point point = webElement.getLocation();
				if (point.x > 0 && point.y > 0) {
					present = true;
				}
			}
		} catch (final NoSuchElementException | StaleElementReferenceException | ElementNotVisibleException e) {
			present = false;
		}
		return present;
	}
	
	public List<String> getTextListFromWebElementList(final List<WebElement> webElementList) {
		
		final List<String> textList = new ArrayList<>();
		if (webElementList != null && !webElementList.isEmpty()) {
			for (final WebElement webElement : webElementList) {
				textList.add(webElement.getText());
			}
		}
		return textList;
	}
	
	public List<String> getAttributeListFromWebElementList(final List<WebElement> webElementList, final String attribute) {
		
		final List<String> attributeList = new ArrayList<>();
		if (webElementList != null && !webElementList.isEmpty()) {
			for (final WebElement webElement : webElementList) {
				attributeList.add(webElement.getAttribute(attribute));
			}
		}
		return attributeList;
	}
	
	public <T extends Element> void forceClick(final T element) {
		final JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element); 
		jse.executeScript("arguments[0].click();", element);
	}
	
	public <T extends Element> void hoverAndClick(final T element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}
	
	public <T extends Element> void switchToOverlay(final T element) {
		driver.switchTo().frame(element);
	}
	
	public void switchToDefaultWindow() {
		driver.switchTo().defaultContent();
	}
	
}
