package activites;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.equalTo;

public class Activity1 {

//Set Base URL
	final static String ROOT_URI = "https://petstore.swagger.io/v2/pet";

	@Test(priority=1)
    public void Pet_test() {
        // Create JSON request"
        String reqBody = "{"
                + "\"id\": 70456,"
                + "\"name\": \"Riley\","
                + " \"status\": \"alive\""
            + "}";

        Response response = 
            given().contentType(ContentType.JSON) // Set headers
            .body(reqBody) // Add request body
            .when().post(ROOT_URI); // Send POST request

        // Assertion
        response.then().body("id", equalTo(70456));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
    }

    @Test(priority=2)
    public void get_check() {
        Response response = 
            given().contentType(ContentType.JSON) // Set headers
            .when().pathParam("petId", "70456") // Set path parameter
            .get(ROOT_URI + "/{petId}"); // Send GET request
        String body = response.getBody().asPrettyString();
    	
        System.out.println(body);
        // Assertion
        response.then().body("id", equalTo(70456));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
    }
    
    @Test(priority=3)
    public void delete_check() {
        Response response = 
            given().contentType(ContentType.JSON) // Set headers
            .when().pathParam("petId", "70456") // Set path parameter
            .delete(ROOT_URI + "/{petId}"); // Send DELETE request

        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("70456"));
    }

}
