package org.vtest.mongodb;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
	
	public static void main(String[] args) {
		
		
		MongoClient mongo = new MongoClient(new MongoClientURI("mongodb://csi-rva-qa-db:tZzd1gGkM382G31yZuqenYRwEoxXayAeEPpIXHRJsdn7aiboOxi0KOh9N4LXo23nPPsvavitDZzQr0uzIJE3MQ==@csi-rva-qa-db.documents.azure.com:10255/?ssl=true&replicaSet=globaldb"));

		MongoDatabase db=mongo.getDatabase("cs_qa");
		MongoCollection<Document> col = db.getCollection("screens");


		/*
		FindIterable<Document> cursor =  col.find();
		MongoCursor<Document> itr = cursor.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().toJson());
		}
		*/
		
		
		
			BasicDBObject whereQuery = new BasicDBObject();
		    whereQuery.put("name", "WBA00211-C001-DU");
		
		    FindIterable<Document> cursor = col.find(whereQuery);

		    Document doc =cursor.first();
		    System.out.println(doc.toJson());
		    

		
	}

}
