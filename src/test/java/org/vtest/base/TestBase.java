package org.vtest.base;

import java.util.List;

import org.bson.Document;
import org.testng.annotations.BeforeSuite;
import org.vtest.mongodb.MongoDBSetup;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.PropertyReader;

public class TestBase {
	
	public static PropertyReader prop;
	public MongoDBSetup mSetup = new MongoDBSetup();
	public MongoDatabase db;
	public FindIterable<Document> cursor;


	
	/**
	 * Usage: To initialize PropertyReader class
	 * @params 
	 * @return 
	 */
	@BeforeSuite
	public void initProperty() {
		prop = PropertyReader.getInstance();

	}
	
	/**
	 * Usage: To fetch MongoDB Database 
	 * @params 
	 * @return MongoDatabase
	 */
	@BeforeSuite
	public MongoDatabase getDatabase() {
		db = mSetup.setupDBConnection();
		return db;
		
	}
	
	/**
	 * Usage: To fetch value for a given key from a JSON
	 * @params json, key
	 * @return String
	 */
	
	public String fetchValueFromJSON(String json, String key) {
		JsonPath jp = new JsonPath(json);
		return jp.get(key);
	}
	
	/**
	 * Usage: To fetch a list of values for a given key from a JSON
	 * @params json, key
	 * @return List of String
	 */
	
	public List<String> fetchListValueFromJSON(String json, String key){
		JsonPath jp = new JsonPath(json);
		List<String> list = jp.getList(key);
		return list;	
	}
	
	
	/**
	 * Usage: To fetch value for a given key from a JSON
	 * @params key, value, MongoCollection
	 * @return String
	 */
	public String fetchDocumentFromMongo(String key, String value, MongoCollection<Document> col) {
		BasicDBObject whereQuery = mSetup.prepareQueryWithWhereClass(key, value);
		Document doc=col.find(whereQuery).first();
		return doc.toJson();
		
	}

}
