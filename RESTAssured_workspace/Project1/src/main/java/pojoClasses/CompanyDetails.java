package pojoClasses;

import java.util.List;

public class CompanyDetails {
	
//	{
//		  "companyName" : "Shoot",
//		  "companyHQ" : "Bangalore",
//		  "companyCEO" : "Mark",
//		  "supportedBanksForSalary" : [ "HDFC", "ICICI", "Axis" ],
//		  "pincodes" : [ 123456, 151541, 21225 ],
//		  "employee" : [ {
//		    "firstname" : "Bruce",
//		    "lastname" : "Wayne",
//		    "gender" : "male",
//		    "age" : 20,
//		    "salary" : 999.9,
//		    "married" : true
//		  }, {
//		    "firstname" : "Mark",
//		    "lastname" : "Zuck",
//		    "gender" : "Female",
//		    "age" : 30,
//		    "salary" : 130.5,
//		    "married" : true
//		  }, {
//		    "firstname" : "ABC",
//		    "lastname" : "XYZ",
//		    "gender" : "male",
//		    "age" : 29,
//		    "salary" : 155.5,
//		    "married" : true
//		  } ],
//		  "contractors" : [ {
//		    "firstname" : "Peter",
//		    "lastname" : "Lynch",
//		    "contractFrom" : "Jan-2025",
//		    "contractTo" : "Jun-2025"
//		  }, {
//		    "firstname" : "seema",
//		    "lastname" : "SASASA",
//		    "contractFrom" : "Jan - 2018",
//		    "contractTo" : "Jan-2025"
//		  } ],
//		  "companyPFDetails" : {
//		    "pfName" : "MNO",
//		    "pfCity" : "Bengaluru",
//		    "pfYear" : 2023,
//		    "noOfEmployees" : "20"
//		  }
//		}
//	
	private String companyName;
	private String companyHQ;
	private String companyCEO;
	private List<String> supportedBanksForSalary;
	private List<Integer> pincodes;
	List<JsonArrayPOJO> employee;
	List<Contractors> contractors;   //if we need a child JsonArray
	CompanyPFDetails companyPFDetails; // if  we need a child Json

	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyHQ() {
		return companyHQ;
	}
	public void setCompanyHQ(String companyHQ) {
		this.companyHQ = companyHQ;
	}
	public String getCompanyCEO() {
		return companyCEO;
	}
	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}
	public List<String> getSupportedBanksForSalary() {
		return supportedBanksForSalary;
	}
	public void setSupportedBanksForSalary(List<String> supportedBanksForSalary) {
		this.supportedBanksForSalary = supportedBanksForSalary;
	}
	public List<Integer> getPincodes() {
		return pincodes;
	}
	public void setPincodes(List<Integer> pincodes) {
		this.pincodes = pincodes;
	}
	public List<JsonArrayPOJO> getEmployee() {
		return employee;
	}
	public void setEmployee(List<JsonArrayPOJO> employee) {
		this.employee = employee;
	}
	public List<Contractors> getContractors() {
		return contractors;
	}
	public void setContractors(List<Contractors> contractors) {
		this.contractors = contractors;
	}
	public CompanyPFDetails getCompanyPFDetails() {
		return companyPFDetails;
	}
	public void setCompanyPFDetails(CompanyPFDetails companyPFDetails) {
		this.companyPFDetails = companyPFDetails;
	}
	
}
