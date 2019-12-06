package org.vtest.storestests;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.vtest.screens.GetScreenAPI;
import org.vtest.stores.GetStoresAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StoresTest {
	
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI="https://planogram-editor-api-qa.azurewebsites.net";
		RestAssured.basePath="/stores";
	}
	
	@Test
	public void getScreenNameTest() {
		Response response = GetStoresAPI.getAllStoreForRetailers();
		System.out.println("retailers response --> "+response.body().prettyPrint());
		System.out.println("retailers status code --> "+response.getStatusCode());
		
		
		JsonPath jp = new JsonPath(response.asString());
		System.out.print("retailer id ");
		String id = jp.get("[0].retailer-id");
		
		System.out.println(id);
		
	}


}
