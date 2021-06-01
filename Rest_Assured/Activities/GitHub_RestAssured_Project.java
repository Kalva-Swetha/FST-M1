package gitHub_RestAssured_Project;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GitHub_RestAssured_Project {
	RequestSpecification requestSpec;
	String SSH_Key = "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";
	int id;

	@BeforeClass
	public void setUp() {
		// Create request specification
		requestSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setBaseUri("https://api.github.com")
				.build();
	}

	@Test(priority = 1)
	public void post_test() {
		// Create JSON request"
		String reqBody = "{" + "\"title\": \"TestAPIKey\","
				+ "\"key\": \"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCvaSRwFZP4W/jfplMqEUttqsjX6pIx8ULxvea5tzsVo35KgDLl4irS/tTlvi4kbxYhOcXLz3GndTUA+vE9Swfr0BoROgH1GqVgQuhFopp4b9Q/jScl+AK38fxt1tdWfzL4a7WCyo9y4vmOsSSH8Brq9dDxEU8OPr/mPDsDqCxWyiZGQPSjozeB1CwXrvOvz/+Q3jzMfkf288dMzSPkYdqSLkiFLKwxV1aJLljNHt6LT1PorZzFE9ZNSwf3oNkYY8+EnUdTh6WlYkLguvFp1Q78hcrtJpBJXlMvcwG6B8s0IiFLKAMceMl+8dbeVe9DHd5yrf5s+vzNQmlfRmfnn7f3\""
				+ "}";

		Response response = given().spec(requestSpec).auth().oauth2(SSH_Key)// Set headers
				.body(reqBody) // Add request body
				.when().post("/user/keys"); // Send POST request
		id = response.then().extract().path("id");
		System.out.println(id);
		// Assertion
		response.then().statusCode(201);

	}

	@Test(priority = 2)
	public void get_test() {
		Response response = given().spec(requestSpec).auth().oauth2(SSH_Key) // Use requestSpec // Set path parameter
				.get("/user/keys");
		System.out.println(response.getBody().asPrettyString());
		response.then().statusCode(200);
	}

	@Test(priority = 3)
	public void delete_check() {
		Response response = given().spec(requestSpec).auth().oauth2(SSH_Key) // Set headers
				.when().pathParam("keyId", id) // Set path parameter
				.delete("/user/keys/{keyId}"); // Send DELETE request
		// Assertion
		System.out.println(response.getBody().asPrettyString());
		response.then().statusCode(204);
	}
}
