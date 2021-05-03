package com.jdbogar.seleniumPractice.elements.factory.widget;

import org.openqa.selenium.WebElement;

import com.jdbogar.seleniumPractice.elements.base.ElementImpl;

public class TextInputImpl extends ElementImpl implements TextInput{

    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public TextInputImpl(WebElement element) {
        super(element);
    }

    @Override
    public void clear() {
        getWrappedElement().clear();
    }

    @Override
    public void set(Object text) {
        WebElement element = getWrappedElement();
        element.clear();
        element.sendKeys(String.valueOf(text));
    }

    /**
     * Gets the value of an input field.
     * @return String with the value of the field.
     */
    @Override
    public String getText() {
        return getWrappedElement().getAttribute("value");
    }

}
