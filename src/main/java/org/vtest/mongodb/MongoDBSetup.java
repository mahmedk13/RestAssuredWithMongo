package org.vtest.mongodb;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDBSetup {
	
	public MongoDatabase dataBase;
	public MongoCollection<Document> coll;
	public FindIterable<Document> cursor;
	
	
	/**
	 * Usage: Setting up Mongo Database connection
	 * @param 
	 * @return MongoDatabase
	 */
	public MongoDatabase setupDBConnection() {
		
		MongoClient mongo = new MongoClient(new MongoClientURI("mongodb://csi-rva-qa-db:tZzd1gGkM382G31yZuqenYRwEoxXayAeEPpIXHRJsdn7aiboOxi0KOh9N4LXo23nPPsvavitDZzQr0uzIJE3MQ==@csi-rva-qa-db.documents.azure.com:10255/?ssl=true&replicaSet=globaldb"));
		dataBase=mongo.getDatabase("cs_qa");
		return dataBase;
		
	}
	
	/**
	 * Usage: Getting collection from MongoDB
	 * @param Name of the collection
	 * @return MongoCollection
	 */
	
	public MongoCollection<Document> fetchCollection(String collectionName){
		coll = dataBase.getCollection(collectionName);
		return coll;
	}
	
	/**
	 * Usage: Getting All documents from a Collection
	 * @param 
	 * @return FindIterable
	 */
	
	public FindIterable<Document> fetchAllDocumentsInACollection() {
		FindIterable<Document> cursor =  coll.find();
		return cursor;
	}
	
	/**
	 * Usage: Preparing a DB query with where clause
	 * @param Column name and its value
	 * @return BasicDBObject
	 */
	
	public BasicDBObject prepareQueryWithWhereClass(String query, String value) {
		BasicDBObject whereQuery = new BasicDBObject();
	    whereQuery.put(query, value);
	
	    return whereQuery;
	    
	}
	
	
	
	
	
	

}
