package api.EndPoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.UserData.CreateUserDataForPet;
import api.Utilities.Routes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;

public class UserEndPoints {

	public static Response createPet(CreateUserDataForPet payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.post_baseURl);
		return response;
	}
	
	public static Response retrievePet(int getPetId) {
		Response response = given().pathParam("getPetId", getPetId)
				.when()
				.get(Routes.get_baseURl);
		return response;
	}
	
	public static Response updatePet(CreateUserDataForPet payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
							.when().put(Routes.put_baseURl);
		return response;
	}
	
	public static Response retrievePetDataByStatus() {
		String status[]= {"available", "sold", "pending"};
		Response response = given()
							.pathParam("myParam", "findByStatus")
							.queryParam("status", status)
							.when()
							.get(Routes.get_baseURlWithStatus);
		return response;
	}
}
