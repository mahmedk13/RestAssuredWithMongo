package vTestAPIDemo;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
		Response response = GetScreenExample.getSrceenData();
		System.out.println(response.body().prettyPrint());
		System.out.println(response.getStatusCode());
		
		
		JsonPath jp = new JsonPath(response.asString());
		List<String> list = jp.getList("allProductImages");
		
		System.out.println(list.size());
		
	}

}
