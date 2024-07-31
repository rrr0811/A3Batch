package org.automation.generic_utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataProviderClass implements IAutoConstants {

	File excelFile = new File(EXCEL_PATH);

	/**
	 * this function is used to perform dataProvider action by fetching datas from
	 * excel for registration
	 * 
	 * @return 2D String array
	 */
	@DataProvider
	public String[][] dataProviderForRegister() {
		FileInputStream fis;
		Workbook workbook = null;
		try {
			fis = new FileInputStream(excelFile);
			workbook = WorkbookFactory.create(fis);
		} catch (Exception e) {

		}

		Sheet registerSheet = workbook.getSheet("RegistrationCredentials");
		int rowCount = registerSheet.getPhysicalNumberOfRows();
		int cellCount = registerSheet.getRow(0).getPhysicalNumberOfCells();

		String[][] arr = new String[rowCount - 1][cellCount];
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				arr[i - 1][j] = registerSheet.getRow(i).getCell(j).toString();
			}
		}

		return arr;
	}

}
