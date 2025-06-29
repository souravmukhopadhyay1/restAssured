package api.EndPoints;

import java.util.ResourceBundle;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class authEndPoints {
	
	public static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("auth");
		return routes;
	}
	
	public static Response retrieveUser() {
		String get_url = getURL().getString("get_url");
		
		Response response = given()
								.auth().basic("admin", "admin") 
								.header("accept", "application/json")
								.log().all()
							.when()
								.get(get_url + "/basic-auth/admin/admin")
							.then()
								.statusCode(200)
								.log().all()
								.extract().response();
		
		return response;
	}
	
//	public static Response retrieveUsingBearerToken() {
//		//String bearer_token = "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";
//		
//		Response response = given()
//								.header("authorization", "bearer " + bearer_token)
//							.when()
//								.get("https://api.github.com/user")
//							.then()
//								.statusCode(200)
//								.log().all()
//								.extract().response();
//								;
//								return response;
//	}

}
