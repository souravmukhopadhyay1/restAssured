package test.practise;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class jsonResponseBody {
	
	@Test
	public void assertJSONResponse() {
		
		boolean assertVal = false;
		
		RestAssured.baseURI= "https://reqres.in";
		Response res = given()
						.pathParam("myParam", "users")
						.queryParam("page", 2)
					   .when()
					   	.get("/api/{myParam}")
					   .then()
					   	.statusCode(200)
		                .extract().response();
		
		
		//Asserting JSONArray
		JSONObject jo = new JSONObject(res.asString());
		
		for(int i=0; i<jo.getJSONArray("data").length(); i++) {
			String dataArray = jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			System.out.println("First Name of index " + i + " is " + dataArray);
			if(dataArray.contains("Lindsay")) {
				assertVal = true;
				break;
			}
		}
		Assert.assertEquals(assertVal, true);
		
		//Asserting JSON
		
		List <String> getJSONList = res.jsonPath().getList("data.email");
		System.out.println("First Name of index " + getJSONList);
		
		for(String email: getJSONList) {
			assertThat(email, endsWith("@reqres.in"));
			System.out.println("First Name of index " + email);
		}
	}

}
