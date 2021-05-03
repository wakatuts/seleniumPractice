package com.jdbogar.seleniumPractice.elements.factory.widget;

import org.openqa.selenium.WebElement;

import com.jdbogar.seleniumPractice.annotations.ImplementedBy;
import com.jdbogar.seleniumPractice.elements.base.Element;

@ImplementedBy(TableImpl.class)
public interface Table extends Element{

	/**
     * Gets the number of rows in the table
     * @return int equal to the number of rows in the table
     */
    int getRowCount();

    /**
     * Gets the number of columns in the table
     * @return int equal to the number of rows in the table
     */
    int getColumnCount();

    /**
     * Gets the WebElement of the cell at the specified index
     * @param rowIdx The zero based index of the row
     * @param colIdx The zero based index of the column
     * @return the WebElement of the cell at the specified index
     */
    WebElement getCellAtIndex(int rowIdx, int colIdx); 
}
