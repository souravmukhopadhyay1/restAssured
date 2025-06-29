package test.practise;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

import java.util.HashMap;

import org.testng.annotations.Test;

public class tcs {
	
	int id;

	//@Test
	public void getUsers() {
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	public void putUsers() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "Akash");
		data.put("salary", "1234");
		data.put("age", "34");
		
		Response response  =  given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://dummy.restapiexample.com/api/v1/create")
		//.jsonPath().getInt("id");
		
		.then()
		.statusCode(200)
		.extract().response();
		if (response.statusCode() == 200) {
		    Integer id = response.path("data.id");
		    if (id != null) {
		        System.out.println("Created ID: " + id);
		    } else {
		        System.out.println("ID not found in response.");
		    }
		} else {
		    System.out.println("Request failed: " + response.statusCode());
		    response.prettyPrint();
		}

	}
	
}
