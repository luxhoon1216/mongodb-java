package dannyk.project;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

public class demo {
	
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("test");
		
		MongoCollection<Document> collection = database.getCollection("performence_test");
//		collection.createIndex(new Document("seq", 1));
		
//		List<Document> docs = new ArrayList<Document>();
//		Random r = new Random();
//		for(int j = 0; j < 20; j++) {
//			for(int i = 0; i < 1000000; i++) {
//				docs.add(new Document("seq", r.nextInt(200))
//						.append("name", "MongoDB")
//			            .append("type", "database")
//			            .append("count", 1)
//			            .append("info", new Document("x", 203).append("y", 102)));
//			}
//			
//			double time = System.currentTimeMillis();
//			collection.insertMany(docs);
//			System.out.println(System.currentTimeMillis() - time);
//			docs.clear();
//		}
		
		double time = System.currentTimeMillis();
		UpdateResult updateResult = collection.updateMany(eq("seq", 101), new Document("$mul", new Document("info.x", 3)));
		time = System.currentTimeMillis() - time;
		System.out.println("Updated " + updateResult.getModifiedCount() + " documents: " + time + "ms");
		
		mongoClient.close();
	}
}
