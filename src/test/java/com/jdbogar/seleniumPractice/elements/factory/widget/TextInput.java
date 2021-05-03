package com.jdbogar.seleniumPractice.elements.factory.widget;

import com.jdbogar.seleniumPractice.annotations.ImplementedBy;
import com.jdbogar.seleniumPractice.elements.base.Element;

@ImplementedBy(TextInputImpl.class)
public interface TextInput extends Element{
	
    /**
     * @param object The text to type into the field.
     */
    void set(Object object);

}
