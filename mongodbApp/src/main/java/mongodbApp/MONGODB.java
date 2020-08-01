package mongodbApp;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MONGODB {

	public static void main(String[] args) throws UnknownHostException, JsonMappingException, JsonProcessingException {
		MongoClient mongo = new MongoClient();
		DB db = mongo.getDB("teste");
		DBCollection users = db.getCollection("users");

		/*
		 * for (int i=5;i<100;i++) { User u = new User(i,"teste"+i, "Teste "+i,
		 * "32723h23h2"); users.insert(u.toJson()); }
		 */
		DBObject query = BasicDBObjectBuilder.start().add("_id", 5).get();
		DBCursor cursor = users.find(query);
		while (cursor.hasNext()) {
			User u = new User(cursor.next().toString());
			System.out.println(u.getName());
		}

	}

}
