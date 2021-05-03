package com.jdbogar.seleniumPractice.elements.factory.widget;

import com.jdbogar.seleniumPractice.annotations.ImplementedBy;
import com.jdbogar.seleniumPractice.elements.base.Element;

@ImplementedBy(LabelImpl.class)
public interface Label extends Element{
	
	String getFor();

}
