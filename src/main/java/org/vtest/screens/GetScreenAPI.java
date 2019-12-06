package org.vtest.screens;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class GetScreenAPI {
	
	
	public static Response getSrceenDataResponse() {
		
		Response response =given().
						   contentType(ContentType.JSON).
						   when().
						   get("/WBA-15196-000-C002").
						   then().
						   extract().response();
		return response;
	}
	
	
}
