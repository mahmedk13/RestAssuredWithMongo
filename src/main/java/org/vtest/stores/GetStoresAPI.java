package org.vtest.stores;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetStoresAPI {
	
public static Response getAllStoreForRetailers() {
		
	Response response =given().
			   		   contentType(ContentType.JSON).
			   		   param("retailerId", "Walgreens").
			   		   when().
			   		   get().
			   		   then().
			   		   extract().response();
	return response;
	
}

}
