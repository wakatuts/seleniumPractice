package com.jdbogar.seleniumPractice.elements.factory.widget;

import org.openqa.selenium.WebElement;

import com.jdbogar.seleniumPractice.elements.base.ElementImpl;

public class LabelImpl extends ElementImpl implements Label{

    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public LabelImpl(WebElement element) {
        super(element);
    }

    @Override
    public String getFor() {
        return getWrappedElement().getAttribute("for");
    }

}
