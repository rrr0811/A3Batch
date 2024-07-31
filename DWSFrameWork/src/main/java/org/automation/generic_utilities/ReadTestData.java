package org.automation.generic_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Harsha G R
 *
 */
public class ReadTestData implements IAutoConstants {
	
	File propertyFile = new File(PROPERTYFILE_PATH); 
	File excelFile = new File(EXCEL_PATH);

	/**
	 * this function is used to fetch the data from Properties file
	 * @param key
	 * @return data -->String
	 */
	public String readDataFromPropertyFile(String key) {
		FileInputStream fis ;
		Properties prop = null;
		try {
			fis = new FileInputStream(propertyFile);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			
		}
		String data = prop.getProperty(key);
		return data;
	}
	
	/**
	 * this function is used to fetch the data from Excel file
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return data --> String
	 */
	public String readDataFromExcelFile(String sheetName, int rowNum, int cellNum) {
		FileInputStream fis ;
		Workbook workbook = null ;
		try {
			fis = new FileInputStream(excelFile);
			workbook = WorkbookFactory.create(fis);
		} catch (Exception e) {
			
		}
		String data = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
		return data;
	}
	
	/**
	 * this function is used to get the no of rows in a sheet
	 * @param sheetName
	 * @return rowCount --> int
	 */
	public int getRowCount(String sheetName) {
		FileInputStream fis ;
		Workbook workbook = null ;
		try {
			fis = new FileInputStream(excelFile);
			workbook = WorkbookFactory.create(fis);
		} catch (Exception e) {
			
		}
		int rowCount = workbook.getSheet(sheetName).getPhysicalNumberOfRows();
		return rowCount;
	}
	
	/**
	 * this function is used to get the no of cells in a row of a particular sheet
	 * @param sheetName
	 * @param rowNum
	 * @return cellCount --> int
	 */
	public int getCellCount(String sheetName, int rowNum) {
		FileInputStream fis ;
		Workbook workbook = null ;
		try {
			fis = new FileInputStream(excelFile);
			workbook = WorkbookFactory.create(fis);
		} catch (Exception e) {
			
		}
		int cellCount = workbook.getSheet(sheetName).getRow(rowNum).getPhysicalNumberOfCells();
		return cellCount;
	}
}
