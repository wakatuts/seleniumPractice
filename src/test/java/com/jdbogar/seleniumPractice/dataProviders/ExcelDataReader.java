package com.jdbogar.seleniumPractice.dataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {

	private String testMethod;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private Map<String, Object> testData;
	
	public ExcelDataReader() {
		// TODO Auto-generated constructor stub
	}
	
	public void setExcelParam(String excelPath, String testMethod) {
		
		this.testMethod = testMethod;
		try {
			this.workbook = new XSSFWorkbook(new FileInputStream(new File(excelPath)));
			this.sheet = workbook.getSheetAt(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	
	public Map<String, Object> getExcelTestData(){

		testData = new HashMap<String, Object>();
		
		Iterator<Row> itr = sheet.iterator();
		Row headerRow = sheet.getRow(0);
		while (itr.hasNext()) {
			Row row = (Row) itr.next();
			Cell cell = row.getCell(0);
			if (cell.getStringCellValue().equals(testMethod)) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell dataCell = (Cell) cellIterator.next();
					int column = dataCell.getColumnIndex();
					String header = headerRow.getCell(column).getStringCellValue();
					if (dataCell.getCellType() != CellType.BLANK) {
						
						switch (dataCell.getCellType()) {
						case STRING:
							testData.put(header, dataCell.getStringCellValue());
							break;
							
						case NUMERIC:
							if (header.toLowerCase().contains("date")) {
								testData.put(header, dataCell.getDateCellValue());
							} else {
								testData.put(header, dataCell.getNumericCellValue());
							}
							break;
							
						default:
							break;
						}
					}
				}
				return testData;
			}

			
		}
		
		return null;
		
	}

}
