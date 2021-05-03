package com.jdbogar.seleniumPractice.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtils {

	public DateUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static Map <String, String> separateDate(Object date, String pattern) {
		
		DateFormat df = new SimpleDateFormat(pattern);
		Map <String, String> dateMap = new HashMap<String, String>();
		String dateString = df.format(date);
		
		dateMap.put("month",dateString.replace("/", "").substring(0,2));
		dateMap.put("day",dateString.replace("/", "").substring(2,4));
		dateMap.put("year",dateString.replace("/", "").substring(4));
		
		return dateMap;
	}
	
	public static String formatDate(Date date, String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}
}
