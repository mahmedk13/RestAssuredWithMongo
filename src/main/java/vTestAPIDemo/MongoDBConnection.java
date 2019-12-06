package vTestAPIDemo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
	
	public static void main(String[] args) {
		
		
		MongoClient mongo = new MongoClient(new MongoClientURI("mongodb://csi-rva-qa-db:tZzd1gGkM382G31yZuqenYRwEoxXayAeEPpIXHRJsdn7aiboOxi0KOh9N4LXo23nPPsvavitDZzQr0uzIJE3MQ==@csi-rva-qa-db.documents.azure.com:10255/?ssl=true&replicaSet=globaldb"));

		MongoDatabase db=mongo.getDatabase("cs_qa");
		MongoCollection<Document> col = db.getCollection("retailers");
		System.out.println(col.count());
		
	}

}
