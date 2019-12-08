package org.vtest.stores;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoresAPI {
	
	/**
	 * Usage: Fetching a response for Get All Store for Retailers API
	 * @params retailerName
	 * @return Response
	 */

	public static Response getAllStoreForRetailers(String retailerName) {

		Response response =given().
				contentType(ContentType.JSON).
				param("retailerId", retailerName).
				get();

		return response;

	}

}
