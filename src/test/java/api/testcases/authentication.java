package api.testcases;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import api.EndPoints.UserEndPoints;
import api.EndPoints.authEndPoints;
import api.UserData.CreateUserDataForPet;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import io.restassured.response.Response;
import junit.framework.Assert;

public class authentication {

	// @Test
	public void basicAuthentications() {
		Response response = authEndPoints.retrieveUser();
		int statusCode = response.statusCode();
		System.out.println("Response is: " + statusCode);
	}

//	@Test
//	public void bearerAuthentications() {
//		Response response = authEndPoints.retrieveUsingBearerToken();
//		int statusCode = response.statusCode();
//		System.out.println("Response is: " + statusCode);
//	}
}
