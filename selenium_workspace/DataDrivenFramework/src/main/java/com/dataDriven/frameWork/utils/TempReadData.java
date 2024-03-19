package com.dataDriven.frameWork.utils;



//THis is just to check the readExcelData class. It is not part of the framework

public class TempReadData {
	public static void main(String agrs[]) {
		ReadExcelDataFile readData = new ReadExcelDataFile(System.getProperty("user.dir") + "\\src\\main\\java\\testData\\TestData.xlsx");
		
		int totalRows = readData.getRowCount("SampleData");
		System.out.println("Total Number of Rows : " + totalRows);
		
		System.out.println(readData.getCellData("SampleData", 0, 3));
		System.out.println(readData.getCellData("SampleData", 1, 4));
		
		System.out.println(readData.getColumnCount("SampleData"));
	}

}
