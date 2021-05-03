package com.jdbogar.seleniumPractice.dataProviders;

public class ExcelData {
	
	ExcelDataReader reader;
	
	public ExcelData(ExcelDataReader reader) {
		this.reader = reader;
	}
	
	private static ThreadLocal<ExcelDataReader> excelDataReader = new ThreadLocal<>();
	
	public static void setReader(ExcelDataReader reader) {
		
		excelDataReader.set(reader);
	}
	
	public static ExcelDataReader getTestData() {
		
		return excelDataReader.get();
	}

}
