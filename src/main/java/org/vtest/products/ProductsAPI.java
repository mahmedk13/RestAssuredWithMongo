package org.vtest.products;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.Filepaths;

public class ProductsAPI {
	
	/**
	 * Usage: Fetching a response for put product data API
	 * @params StoreId, ProductId
	 * @return Response
	 */

	public static Response putProductDataForProductId(String storeId, String productId) {

		Response response =given().
				contentType(ContentType.JSON).
				queryParam("storeId", storeId).
				body(Filepaths.PRODUCT_DATA).
				put("/{productid}", productId);

		return response;
	}

}
