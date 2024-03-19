package jsonUtils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteJson {
	
	public static void main(String[] args) {
		JSONObject student1 = new JSONObject();
		student1.put("studentName", "abc");
		student1.put("Grade", "1");
		student1.put("Location", "xyz");
		
		
JSONObject student2 = new JSONObject();
		
		student2.put("studentName", "mno");
		student2.put("Grade", "1");
		student2.put("Location", "bcd");
		
		System.out.println(student1.toJSONString());
		System.out.println(student2.toJSONString());
		
		JSONArray studentDetails = new JSONArray();
		studentDetails.add(student1);
		studentDetails.add(student2);
		
		System.out.println(studentDetails.toJSONString());
		
		JSONObject details = new JSONObject();
		
		details.put("studentDetails", studentDetails);
		
		System.out.println(details.toJSONString());
		
	}

}
