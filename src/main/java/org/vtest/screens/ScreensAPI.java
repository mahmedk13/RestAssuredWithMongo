package org.vtest.screens;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.Filepaths;

public class ScreensAPI {
	
	/**
	 * Usage: Fetching a response for Get Screen data API
	 * @params screenName
	 * @return Response
	 */



	public static Response getSrceenData(String screenName) {

		Response response =given().
				contentType(ContentType.JSON).
				get("/"+screenName);

		return response;
	}
	
	/**
	 * Usage: Fetching a response for Post Screen data Preview API
	 * @params screenName
	 * @return Response
	 */

	public static Response postScreenDataPreview(String screenName) {

		Response response =given().
				contentType(ContentType.JSON).
				body(Filepaths.PREVIEW).
				post("/{screenName}/preview", screenName);

		return response;
	}




}
