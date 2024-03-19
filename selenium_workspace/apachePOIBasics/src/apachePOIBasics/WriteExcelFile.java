package apachePOIBasics;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {
	
	public static void main(String[] args) {
		
		//create blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//create excel sheet
		XSSFSheet sampleSheet = workbook.createSheet("sampleSheet");
		
		//creating the data
		Map<String, Object[]> dataSet = new TreeMap<String, Object[]>();
		dataSet.put("1", new Object[] {1, "Sam", "Company","John" ,"lenny"});
		//dataSet.put("2", new Object[] {"1", "James", "Amazon.inc" });
		//dataSet.put("3", new Object[] {"2", "Oliver", "Queen consolidates" });
		//dataSet.put("4", new Object[] {"3", "Barry", "Star Labs" });
		//dataSet.put("5", new Object[] {"4", "Bruce Wayne", "Wayne enterprises" });
		
		//Iterate over the data
		Set<String> set = dataSet.keySet();
		int rowNum = 0;
		
		for(String key: set) {
			
			//to create a new row in sheet
			Row row = sampleSheet.createRow(rowNum++);
			
			Object[] data = dataSet.get(key);
			
			//for iterating over the data
			int cellNum = 0;
			for(Object value: data) {
				Cell cell = row.createCell(cellNum++);
				
				if(value instanceof String)
					cell.setCellValue((String)value);
				else if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				
			}
		}
		//write files on disk
		try {
			FileOutputStream writeFile = new FileOutputStream("sampleTest.xlsx");
			
			//C:Test//Sample//...//fileName
			
			workbook.write(writeFile);
			//closing the file
			writeFile.close();
			System.out.println("The sample xl file is created");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
 }
