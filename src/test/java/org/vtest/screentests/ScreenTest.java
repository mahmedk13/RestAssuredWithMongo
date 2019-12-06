package org.vtest.screentests;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.vtest.screens.GetScreenAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ScreenTest {
	
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI="https://planogram-editor-api-qa.azurewebsites.net";
		RestAssured.basePath="/screens";
	}
	
	@Test
	public void getScreenNameTest() {
		Response response = GetScreenAPI.getSrceenDataResponse();
		System.out.println("screen response --> "+response.body().prettyPrint());
		System.out.println("screen status code --> "+response.getStatusCode());
		
		
		JsonPath jp = new JsonPath(response.asString());
		List<String> list = jp.getList("allProductImages");
		
		System.out.println("size of product images "+list.size());
		
	}

}
