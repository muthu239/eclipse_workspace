package pojoClasses;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonArraySerialization {

	public String employeeJson;

	@Test
	public void createJsonArrayFromPOJO() throws JsonProcessingException {

		JsonArrayPOJO abc = new JsonArrayPOJO();
		abc.setFirstname("ABC");
		abc.setLastname("XYZ");
		abc.setAge(29);
		abc.setGender("male");
		abc.setSalary(155.5);
		abc.setMarried(true);

		JsonArrayPOJO mark = new JsonArrayPOJO();
		mark.setFirstname("Mark");
		mark.setLastname("Zuck");
		mark.setAge(30);
		mark.setGender("Female");
		mark.setSalary(130.5);
		mark.setMarried(true);

		JsonArrayPOJO bruce = new JsonArrayPOJO();
		bruce.setFirstname("Bruce");
		bruce.setLastname("Wayne");
		bruce.setAge(20);
		bruce.setGender("male");
		bruce.setSalary(999.9);
		bruce.setMarried(true);

		List<JsonArrayPOJO> allEmployees = new ArrayList<JsonArrayPOJO>();

		allEmployees.add(abc);
		allEmployees.add(mark);
		allEmployees.add(bruce);

		ObjectMapper objectmapper = new ObjectMapper();
		employeeJson = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(allEmployees);

		System.out.println(employeeJson);

	}

	@Test
	public void getPOJOfromObject() throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectmapper = new ObjectMapper();
		List<JsonArrayPOJO> allEmployees = objectmapper.readValue(employeeJson,
				new TypeReference<List<JsonArrayPOJO>>() {
				});

		for (JsonArrayPOJO jsonArrayPOJO : allEmployees) {
			System.out.println("============================================");
			System.out.println("First Name of the employee : " + jsonArrayPOJO.getFirstname());
			System.out.println("Last Name of the employee : " + jsonArrayPOJO.getLastname());
			System.out.println("Age of the employee : " + jsonArrayPOJO.getAge());
			System.out.println("Gender of the employee : " + jsonArrayPOJO.getGender());
			System.out.println("Salary of the employee : " + jsonArrayPOJO.getSalary());
			System.out.println("Marital status of the employee : " + jsonArrayPOJO.isMarried());
			System.out.println("============================================");
		}

	}

}
