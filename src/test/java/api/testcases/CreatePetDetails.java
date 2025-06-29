package api.testcases;

import com.github.javafaker.Faker;

import api.EndPoints.UserEndPoints;
import api.UserData.CreateUserDataForPet;
import io.restassured.response.Response;
import junit.framework.Assert;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreatePetDetails {

	Faker fakeData = new Faker();
	CreateUserDataForPet payload = new CreateUserDataForPet();
	int getPetId;

	@BeforeClass
	public void createData() {
		payload.setId(fakeData.idNumber().hashCode());
		payload.setName(fakeData.name().toString());
		payload.setCategoryid(fakeData.number().hashCode());
		payload.setStatus("avaialble");
	}

	//@Test(priority = 1)
	public void createPet() {
		Response response = UserEndPoints.createPet(payload);
		int captureResponseCode = response.statusCode();
		response.then().log().all();
		
		//Validating every field
		getPetId = response.jsonPath().get("id");
		System.out.println("ID is: " + getPetId);
		
		String getName = response.jsonPath().getString("name");
		System.out.println("Name is: " + getName);
		Assert.assertEquals(getName, payload.getName());
		
		List<String> photoURL= response.jsonPath().getList("photoUrls");
		Assert.assertTrue(photoURL.isEmpty());
		
		List <String> tags = response.jsonPath().getList("tags");
		Assert.assertTrue(tags.isEmpty());
		
		String status = response.jsonPath().getString("status");
		Assert.assertEquals(status, "avaialble");
	}

	//@Test(priority = 2)
	public void retrievePet() {
		Response response = UserEndPoints.retrievePet(getPetId);
		int captureResponseCode = response.statusCode();
		response.then().log().all();
		getPetId = response.jsonPath().get("id");
		System.out.println("ID is: " + getPetId);
	}
	
	//@Test(priority = 3)
	public void UpdatePetPet() {
		payload.setName(fakeData.name().toString());
		payload.setStatus("unavailable");
		Response response = UserEndPoints.updatePet(payload);
		int captureResponseCode = response.statusCode();
		response.then().log().all();
		int getPetId1 = response.jsonPath().get("id");
		Assert.assertEquals(getPetId1, getPetId);
		System.out.println("ID is: " + getPetId);
	}

	@Test (priority = 4)
	public void getPetsByStatus() {
		Response response = UserEndPoints.retrievePetDataByStatus();
		int captureResponseCode = response.statusCode();
		response.then().log().all();
		
		if(response.statusCode() == 200) {
			System.out.println("Status code is " + response.statusCode());
		}
		else {
			System.out.println("Status code is " + response.statusCode());
		}
		
		//Count the number of available dogs
		int getNoOfArray = response.jsonPath().getList("").size();
		
		List<String> getStatus = response.jsonPath().getList("status");
		List <String> getNames = response.jsonPath().get("name");
		for(String status:getStatus) {
			for(String names:getNames) {
				System.out.println("Pet name is " + names + " and the statis is " +status);	
			}
		}
		
		List <String> getTags = response.jsonPath().getList("tags.id");
		
	}
}
