package com.insurance.utils;

import java.util.Hashtable;

public class DataProviderTest 
{
	public static Object[][] getTestData(String DataFileName, String SheetName, String TestName) {

		ReadExcelData readdata = new ReadExcelData(System.getProperty("user.dir") + "\\Excelfile\\" + DataFileName +".xlsx");
		

		// Find Start Row of TestCase
		int startRowNum = 0;
		while (!readdata.getCellData(SheetName, 0, startRowNum).equalsIgnoreCase(TestName)) 
		{
			startRowNum++;
		}

		int startTestColumn = startRowNum + 1;
		int startTestRow = startRowNum + 2;

		// Find Number of Rows of TestCase
		int rows = 0;
		while (!readdata.getCellData(SheetName, 0, startTestRow + rows).equals("")) {
			rows++;
		}
		// Find Number of Columns in Test
		int colmns = 0;
		while (!readdata.getCellData(SheetName, colmns, startTestColumn).equals("")) {
			colmns++;
		}

		// Define Two Object Array
		Object[][] dataSet = new Object[rows][1];
		
		int dataRowNumber = 0;
		for (int rowNumber = startTestRow; rowNumber <= startTestColumn + rows; rowNumber++) {
			Hashtable<String, String> dataTable = new Hashtable<String, String>();
			for (int colNumber = 0; colNumber < colmns; colNumber++) {
				String key = readdata.getCellData(SheetName, colNumber, startTestColumn);
				String value = readdata.getCellData(SheetName, colNumber, rowNumber);
				dataTable.put(key, value);
				// dataSet[dataRowNumber][colNumber]=readdata.getCellData(sheetName, colNumber,
				// rowNumber);
				// 00,01,02,03
				// 10,11,12
			}
			dataSet[dataRowNumber][0] = dataTable;
			dataRowNumber++;
		}

		return dataSet;
	}

}
