package com.jdbogar.seleniumPractice.assertions;


import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import com.jdbogar.seleniumPractice.elements.base.Element;


public class Verify {

	private SoftAssertions assertion;
	
	public Verify(SoftAssertions assertion) {
		this.assertion = assertion;
	}
	
	private static ThreadLocal<SoftAssertions> softAssert = new ThreadLocal<>();
	
	public static void setAssert(SoftAssertions assertion) {
		
		softAssert.set(assertion);
	}
	
	public static SoftAssertions get() {
		
		return softAssert.get();
	}
	
	public static void assertAll() {
		
		softAssert.get().assertAll();
	}
	
	public static void equals(String actual, String expected) {
		Assertions.assertThat(actual).isEqualTo(expected);
	}
	
	public static void equalsAndContinueOnFailure(String actual, String expected) {
		softAssert.get().assertThat(actual).isEqualTo(expected);
	}
	
	public static void contains(String actual, String expected) {
		Assertions.assertThat(actual).contains(expected);
	}
	
	public static void containsAndContinueOnFailure(String actual, String expected) {
		softAssert.get().assertThat(actual).contains(expected);
	}
	
	public static void equalsIngnoreCase(String actual, String expected ) {
		Assertions.assertThat(actual).isEqualToIgnoringCase(expected);
	}
	
	public static void equalsIngnoreCaseAndContinueOnFailure(String actual, String expected ) {
		softAssert.get().assertThat(actual).isEqualToIgnoringCase(expected);
	}
	
	public static <T extends Element> void elementIsDisplayed (T element) {
		Assertions.assertThat(element.isDisplayed());
	}
}
