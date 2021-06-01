package activites;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity3 {
	  RequestSpecification requestSpec;
	  ResponseSpecification responseSpec;
  @BeforeClass
  public void setup() {
		    // Create request specification
		    requestSpec = new RequestSpecBuilder()
		        .setContentType(ContentType.JSON)
		        .setBaseUri("https://petstore.swagger.io/v2/pet")
		        .build();
		 // Create response specification
			responseSpec = new ResponseSpecBuilder()
			    // Check status code in response
			    .expectStatusCode(200)
			    // Check response content type
			    .expectContentType(ContentType.JSON)
			    // Check if response contains name property
			    .expectBody("status", equalTo("alive"))
			    // Build response specification
			    .build();
		}
	  @Test(priority=1)
	  public void putSet()
	  {
		  String reqBody = "{"
	                + "\"id\": 90123,"
	                + "\"name\": \"Swetha\","
	                + " \"status\": \"alive\""
	            + "}";

	        Response response = 
	            given().spec(requestSpec) // Set headers
	            .body(reqBody) // Add request body
	            .when().post(); // Send POST request
	        
	        System.out.println(response.getBody().asPrettyString());
	        reqBody = "{"
	                + "\"id\": 90124,"
	                + "\"name\": \"Kavya\","
	                + " \"status\": \"alive\""
	            + "}";
	        response = 
		            given().spec(requestSpec) // Set headers
		            .body(reqBody) // Add request body
		            .when().post(); 
	        // Assertion
	        System.out.println(response.getBody().asPrettyString());
	        response.then().spec(responseSpec);
	  }
	  @DataProvider
	    public Object[][] petInfoProvider() {
	        // Setting parameters to pass to test case
	        Object[][] testData = new Object[][] { 
	            { 90123, "Swetha", "alive" }, 
	            { 90124, "Kavya", "alive" }
	        };
	        return testData;
	    }
	  @Test(dataProvider = "petInfoProvider", priority=2)
	    public void getPets(int id, String name, String status) {
	        Response response = given().spec(requestSpec) // Use requestSpec
	                .pathParam("petId", id) // Add path parameter
	                .when().get("/{petId}"); // Send GET request
	 
	        // Print response
	        System.out.println(response.asPrettyString());
	        // Assertions
	        response.then()
	        .spec(responseSpec) // Use responseSpec
	        .body("name", equalTo(name)); // Additional Assertion
	    }
	 
	    // Test case using a DataProvider
	    @Test(dataProvider = "petInfoProvider", priority=3)
	    public void deletePets(int id, String name, String status) {
	        Response response = given().spec(requestSpec) // Use requestSpec
	                .pathParam("petId", id) // Add path parameter
	                .when().delete("/{petId}"); // Send GET request
	 
	        // Assertions
	        response.then().body("code", equalTo(200));
	    }
  
}
