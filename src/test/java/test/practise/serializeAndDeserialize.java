package test.practise;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.MatcherAssert.assertThat;

public class serializeAndDeserialize {

	@Test
	public void serializePojo2Json() throws JsonProcessingException {
		student stu = new student();
		stu.setName("Kiran Kumar");
		stu.setId("1");
		String courses [] = {"Java", "Rest Assured"};
		stu.setCourses(courses);
		
		ObjectMapper objMapper = new ObjectMapper();
		String pojo2Json = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stu);
		System.out.println("POJO to JSON:" + pojo2Json);
	}
	
	@Test
	public void jsonToPojo() throws JsonMappingException, JsonProcessingException {
		String input = "{\r\n"
				+ "  \"id\" : \"1\",\r\n"
				+ "  \"name\" : \"Kiran Kumar\",\r\n"
				+ "  \"courses\" : [ \"Java\", \"Rest Assured\" ]\r\n"
				+ "}";
		
		ObjectMapper objMap = new ObjectMapper();
		student stu = objMap.readValue(input, student.class);
		
		System.out.println("ID: " + stu.getId());
		System.out.println("Name: " + stu.getName());
	}
}