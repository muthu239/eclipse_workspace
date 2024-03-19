package com.InterestAmount.pageclasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*
 * runScriptWriteexcel class to write data into run scripts of excel sheet
 */
public class runScriptWriteExcel
{
	public static void write(int row,int column,String msg)
	{
		try
		{
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Testcases\\EMI Testcases.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Run Scripts");
		if(sheet.getRow(row).getCell(column).getStringCellValue().equalsIgnoreCase("No Run"))
		{
			if(msg.equals("Pass"))
			{
				sheet.getRow(row).getCell(column).setCellValue("PASS");
			}
			else
			{
				sheet.getRow(row).getCell(column).setCellValue("FAIL");
			}
		}
		FileOutputStream output_file=new FileOutputStream(System.getProperty("user.dir")+"\\Testcases\\EMI Testcases.xlsx");
		workbook.write(output_file);
		output_file.close();
		workbook.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}