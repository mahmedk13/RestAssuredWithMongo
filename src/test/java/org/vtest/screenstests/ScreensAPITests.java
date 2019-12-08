package org.vtest.screenstests;

import java.util.List;

import org.bson.Document;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.vtest.base.TestBase;
import org.vtest.screens.ScreensAPI;
import com.mongodb.client.MongoCollection;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ScreensAPITests extends TestBase {
	
	public MongoCollection<Document> collection;

	
	@BeforeClass
	public void setUp() {

		RestAssured.baseURI="https://planogram-editor-api-qa.azurewebsites.net";
		RestAssured.basePath="/screens";
		collection = mSetup.fetchCollection("screens");
		
	}
	
	@Test
	public void getScreenNameTest() {
		String screenName1 = prop.getProperty("screenName1");
		Response response = ScreensAPI.getSrceenData(screenName1);
		
		//Converting Json response into String
		String res = response.asString();
		
		//parsing coolerid, number of products and cooler category from API response
		String coolerid = fetchValueFromJSON(res, "coolerId");
		List<String> noOfProducts = fetchListValueFromJSON(res, "products");
		String coolerCategory = fetchValueFromJSON(res, "coolerCategory");
		
		//fetching document from MongoDB
		String mongoJson = fetchDocumentFromMongo("name", screenName1, collection);
		
		//parsing id, number of products and category from MongoDB document 
		String mId = fetchValueFromJSON(mongoJson, "_id.$oid");
		List<String> mNoOfProducts = fetchListValueFromJSON(mongoJson, "products");
		String mCategory = fetchValueFromJSON(mongoJson, "category");

		//Validating if id, number of products and category is equal in API response and MongoDB
		Assert.assertEquals(coolerid, mId);
		Assert.assertEquals(noOfProducts.size(), mNoOfProducts.size());
		Assert.assertEquals(coolerCategory, mCategory);

	}
	
	@Test
	public void postScreenPreviewTest() {
		Response response = ScreensAPI.postScreenDataPreview(prop.getProperty("screenName2"));
		//System.out.println("screen response --> "+response.body().prettyPrint());
		//System.out.println("screen status code --> "+response.getStatusCode());

	}

}
