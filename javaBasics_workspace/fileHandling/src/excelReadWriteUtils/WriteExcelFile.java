package excelReadWriteUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	public static void main(String[] args) {
		
		//Blank workBook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//Create Excel Sheet
		XSSFSheet sampleSheet = workbook.createSheet("sampleSheet");
		
		//Create the data
		Map<String, Object[]> dataSet = new TreeMap<String,Object[]>();
		dataSet.put("1", new Object[] {"ID", "Name", "Company"});
		dataSet.put("2", new Object[] {"1", "Abc", "xyz"});
		dataSet.put("3", new Object[] {"2", "def", "123"});
		dataSet.put("4", new Object[] {"3", "ghi", "543"});
		dataSet.put("5", new Object[] {"4", "jkl", "1451"});
		dataSet.put("6", new Object[] {"5", "mno", "15415"});
		dataSet.put("7", new Object[] {"6", "pqr", "15411"});
		
		//Iterate over the data
		Set <String> set = dataSet.keySet();
		
		int rowNum = 0;
		for(String key : set) {
			Row row = sampleSheet.createRow(rowNum++);
			Object[] data = dataSet.get(key);
			
			int CellNum = 0;
			for(Object value : data) {
				Cell cell = row.createCell(CellNum++);
				
				
				if(value instanceof String)
					cell.setCellValue((String)value);
				else if(value instanceof Integer)
					cell.setCellValue((Integer)value);
			
			
				
			
			
			}
		}
		
		//till the above code the excel written is in the JVM
		//write file on my disk
		
		try {
			FileOutputStream  writeFile = new FileOutputStream("SampleExcel.xlsx");
			//if we want to write in some other different location
			
			workbook.write(writeFile);
			writeFile.close();
			System.out.println("Sample Excel file is created");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
