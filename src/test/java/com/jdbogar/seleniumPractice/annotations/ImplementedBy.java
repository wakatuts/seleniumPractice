package com.jdbogar.seleniumPractice.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.jdbogar.seleniumPractice.elements.base.ElementImpl;


@Retention(RUNTIME)
@Target(TYPE)
public @interface ImplementedBy {
	
	Class<?> value() default ElementImpl.class;

}
