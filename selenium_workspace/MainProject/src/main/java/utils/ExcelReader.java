package utils;

import java.util.Map;
import java.util.TreeMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelReader {
	
	public static Map<String,String> getTestDataInMap(String testDataFile,String SheetName,String testCaseId) throws Exception{
		
		Map<String,String> TestDataInMap = new TreeMap<String,String>();
		String query = null;
		query = String.format("SELECT * FROM %s WHERE TestCaseId = '%s'", SheetName,testCaseId);
		Fillo fillo = new Fillo();
		Connection conn = null;
		Recordset recordset = null;
		try {
			conn = fillo.getConnection(testDataFile);
			recordset = conn.executeQuery(query);
			while(recordset.next()) {
				for(String field: recordset.getFieldNames()) {
					TestDataInMap.put(field, recordset.getField(field));
				}
			}
		}catch(FilloException e) {
			e.printStackTrace();
			throw new Exception("Test data cannot be found....");
		}
		conn.close();
		
		
		return TestDataInMap;
		
	}

}
