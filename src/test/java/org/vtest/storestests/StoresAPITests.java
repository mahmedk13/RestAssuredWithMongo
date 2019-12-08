package org.vtest.storestests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.vtest.base.TestBase;
import org.vtest.stores.StoresAPI;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.PropertyReader;

public class StoresAPITests extends TestBase {
	

	
	@BeforeClass
	public void setUp() {

		RestAssured.baseURI="https://planogram-editor-api-qa.azurewebsites.net";
		RestAssured.basePath="/stores";
	}
	
	@Test
	public void getAllStoreForRetailersTest() {
		Response response = StoresAPI.getAllStoreForRetailers(prop.getProperty("retailerName"));
		System.out.println("retailers response --> "+response.body().prettyPrint());
		System.out.println("retailers status code --> "+response.getStatusCode());
		
		
		JsonPath jp = new JsonPath(response.asString());
		System.out.print("retailer id ");
		String id = jp.get("[0].retailer-id");
		
		System.out.println(id);
		
	}


}
