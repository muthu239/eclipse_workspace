package apachePOIBasics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CusRegExcel {
	public static String[] customerData = new String[5];
	
	public static String[] readExcelData(String fileName) throws IOException{
		
FileInputStream readFile = new FileInputStream(fileName);
		
		XSSFWorkbook workbook = new XSSFWorkbook(readFile);
		
		// to get the sheet
		//if we dont want to use the name of sheet the index of sheet can be used .. index starts at 0
		XSSFSheet sheet = workbook.getSheet("sampleSheet");  
		
		Row row;
		Cell cell;
		int i=0;
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
			row = rowIterator.next();
			
			Iterator<Cell> cellIterator = row.cellIterator();
			while(cellIterator.hasNext()) {
				cell = cellIterator.next();
				
				// As the sheet's cell can contain any format of value like date, int,string we use formatter
				DataFormatter formatter = new DataFormatter();
				String text = formatter.formatCellValue(cell);
				customerData[i] = text;
				System.out.println(customerData[i]);
				i++;
				
				}
				
			}
		workbook.close();
		return customerData;
	}

}
