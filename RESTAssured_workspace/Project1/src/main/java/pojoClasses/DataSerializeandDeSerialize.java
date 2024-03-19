package pojoClasses;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataSerializeandDeSerialize {
	
	@Test
	public void createDatafromPOJO() throws JsonProcessingException {

		SamplePojo employee = new SamplePojo();

		employee.setFirstname("ABC");
		employee.setLastname("XYZ");
		employee.setAge(29);
		employee.setGender("male");
		employee.setSalary(155.5);
		employee.setMarried(true);

		// converting java class object to a JSON payload as string
		
		//Serializing the data

		ObjectMapper objectmapper = new ObjectMapper();
		String employeeJson = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
		System.out.println(employeeJson);

	}
	
	@Test
	public void getPojoFromObject() throws JsonProcessingException {
		
		SamplePojo employee = new SamplePojo();
		
		employee.setFirstname("ABC");
		employee.setLastname("XYZ");
		employee.setAge(29);
		employee.setGender("male");
		employee.setSalary(155.5);
		employee.setMarried(true);
		
		//converting a java class object to Json  payload as string
		
		ObjectMapper objectmapper = new ObjectMapper();
		String employeeJson = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
		
		//converting JSON string to class object
		
		//Deserializing the data
		SamplePojo employeeObj = objectmapper.readValue(employeeJson, SamplePojo.class);
		System.out.println("FirstName  " + employeeObj.getFirstname());
		System.out.println("LastName : " + employeeObj.getLastname());
		System.out.println("age : " + employeeObj.getAge());
	
	}

}
