package proyecto3;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDB {
	public void conexion() {
		MongoClient mongoClient = new MongoClient("localhost");
		MongoDatabase db = mongoClient.getDatabase("usuario");
		
	}
	public class JavaMongodbInsertData {
	    private MongoClient mongoClient;    // Java MongoDB client (Cliente Java MongoDB)
	    private MongoDatabase mongodb;      // Database object (Objeto base de datos)
	}
}
