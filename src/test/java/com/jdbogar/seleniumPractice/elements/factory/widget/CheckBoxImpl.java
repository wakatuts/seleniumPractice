package com.jdbogar.seleniumPractice.elements.factory.widget;

import org.openqa.selenium.WebElement;

import com.jdbogar.seleniumPractice.elements.base.ElementImpl;

public class CheckBoxImpl extends ElementImpl implements CheckBox{


    /**
     * Wraps a WebElement with checkbox functionality.
     *
     * @param element to wrap up
     */
    public CheckBoxImpl(WebElement element) {
        super(element);
    }

    public void toggle() {
        getWrappedElement().click();
    }

    public void check() {
        if (!isChecked()) {
            toggle();
        }
    }

    public void uncheck() {
        if (isChecked()) {
            toggle();
        }
    }

    public boolean isChecked() {
        return getWrappedElement().isSelected();
    }

}
