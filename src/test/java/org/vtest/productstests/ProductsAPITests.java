package org.vtest.productstests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.vtest.base.TestBase;
import org.vtest.products.ProductsAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ProductsAPITests extends TestBase {

	/**
	 * Usage: To setup BaseURI and BasePath of the API
	 * @params 
	 * @return 
	 */
	@BeforeClass
	public void setUp() {

		RestAssured.baseURI="https://planogram-editor-api-qa.azurewebsites.net";
		RestAssured.basePath="/products";
	}
	
	@Test
	public void putProductDataForProductIdTest() {
		
		Response response = ProductsAPI.putProductDataForProductId(prop.getProperty("storeId"), prop.getProperty("productId"));

	}
	
	
	

}
