package pojoClasses;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateNestedJsonfromPOJO {

	public String nestedPayload;
	
	@Test
	public void generatePOJOData() throws JsonProcessingException {
		CompanyDetails nestedPojo = new CompanyDetails();

		nestedPojo.setCompanyName("Shoot");
		nestedPojo.setCompanyHQ("Bangalore");
		nestedPojo.setCompanyCEO("Mark");

		List<String> supportedSalaryBanks = new ArrayList<>();
		supportedSalaryBanks.add("HDFC");
		supportedSalaryBanks.add("ICICI");
		supportedSalaryBanks.add("Axis");
		nestedPojo.setSupportedBanksForSalary(supportedSalaryBanks);

		List<Integer> pincodes = new ArrayList<Integer>();
		pincodes.add(123456);
		pincodes.add(151541);
		pincodes.add(051351);
		nestedPojo.setPincodes(pincodes);

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

		List<JsonArrayPOJO> employee = new ArrayList<>();
		employee.add(bruce);
		employee.add(mark);
		employee.add(abc);
		nestedPojo.setEmployee(employee);

		Contractors seema = new Contractors();
		seema.setFirstname("seema");
		seema.setLastname("SASASA");
		seema.setContractFrom("Jan - 2018");
		seema.setContractTo("Jan-2025");

		Contractors peter = new Contractors();
		peter.setFirstname("Peter");
		peter.setLastname("Lynch");
		peter.setContractFrom("Jan-2025");
		peter.setContractTo("Jun-2025");

		List<Contractors> contractors = new ArrayList<>();
		contractors.add(peter);
		contractors.add(seema);
		nestedPojo.setContractors(contractors);

		CompanyPFDetails companyPFDetails = new CompanyPFDetails();
		companyPFDetails.setPfName("MNO");
		companyPFDetails.setPfYear(2023);
		companyPFDetails.setNoOfEmployees("20");
		companyPFDetails.setPfCity("Bengaluru");
		nestedPojo.setCompanyPFDetails(companyPFDetails);

		ObjectMapper objectmapper = new ObjectMapper();
		nestedPayload = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(nestedPojo);
		System.out.println(nestedPayload);

	}
	
		
}
