package test.practise;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;

public class jsonSchemaValidator {

	@Test
	public void jsonScnemaVal() {

		given().pathParam("myParam", "users").queryParam("page", 2)
		.when().get("https://reqres.in/api/{myParam}")
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchemaValidation.json"));
	}

}
