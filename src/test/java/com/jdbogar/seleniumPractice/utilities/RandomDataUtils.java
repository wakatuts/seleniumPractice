package com.jdbogar.seleniumPractice.utilities;

import org.apache.commons.lang.RandomStringUtils;

public class RandomDataUtils {

	public static String generateRandomString(int length) {
		
		return RandomStringUtils.randomAlphanumeric(length);
	}

}
