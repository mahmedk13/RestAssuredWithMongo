package vTestAPIDemo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class GetScreenExample {
	
	
	public static Response getSrceenData() {
		
		Response response =given().contentType(ContentType.JSON).get("/WBA-15196-000-C002");
		return response;
	}
	
	
}
