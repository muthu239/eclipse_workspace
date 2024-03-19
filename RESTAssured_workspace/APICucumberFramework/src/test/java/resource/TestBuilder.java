package resource;

import pojoPayloads.PojoClasses;

public class TestBuilder {
	
	PojoClasses req_payload = new PojoClasses();
	
	public PojoClasses createRepoPayload() {
		
		req_payload.setName("API-TEST-REPO");
		req_payload.setDescription("API repo created via BDD Test");
		return req_payload;
	}
	
	public PojoClasses createRepoPayload(String name, String description) {
		req_payload.setName(name);
		req_payload.setDescription(description);
		return req_payload;
	}
	
	public String getRepoName() {
		return req_payload.getName();
	}
	
}
