package proyecto3;
import org.bson.Document;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;

import static java.util.Arrays.asList;

public class MongoDB {
	public void conexion() {
		MongoClient mongoClient = new MongoClient("localhost");
		MongoDatabase db = mongoClient.getDatabase("aplicacion");
		
		db.getCollection("usuarios").insertOne( 
				new Document()
					.append("nick", "Mikel")
					.append("password", "Mikel")
					.append("edad", "37")
					.append("tipo", "nivel 1")
					.append("email", "mikel05@yahoo.es")
					.append("opiniones", asList(
						new Document()
							.append("nombreHotel", "Accra")
							.append("TituloOpinion", "Satisfecho")
							.append("opinion", "Un hotel de lujo en el centro de Accra que, además de la comodidad "
									+ "y limpieza de las habitaciones y la calidad del descanso, cuenta con un buen "
									+ "buffet que mezcla platos europeos con sabores locales; la repostería es muy "
									+ "destacable. Como curiosidad,el hotel muestra en sus pasillos y paredes esculturas "
									+ "y pinturas de autores locales muy sobresalientes."))
					));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Jon")
				.append("password", "Jon")
				.append("edad", "20")
				.append("tipo", "nivel 1")
				.append("email", "jonbart@gmail.com"));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Maialen")
				.append("password", "Maialen")
				.append("edad", "50")
				.append("tipo", "nivel 4")
				.append("email", "maiial@gmail.com"));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Maddi")
				.append("password", "Maddi")
				.append("edad", "19")
				.append("tipo", "nivel 1")
				.append("email", "maddi_98@hotmail.es"));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Asier")
				.append("password", "Asier")
				.append("edad", "28")
				.append("tipo", "nivel 1")
				.append("email", "art7@hotmail.es"));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Jon")
				.append("password", "Jon")
				.append("edad", "20")
				.append("tipo", "nivel 1")
				.append("email", "jonbart@gmail.com"));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Maite")
				.append("password", "Maite")
				.append("edad", "41")
				.append("tipo", "nivel 3")
				.append("email", "mait_14@gmail.com"));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Aitor")
				.append("password", "Aitor")
				.append("edad", "33")
				.append("tipo", "nivel 2")
				.append("email", "ai_tortilla@yahoo.es"));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Ane")
				.append("password", "Ane")
				.append("edad", "30")
				.append("tipo", "nivel 3")
				.append("email", "ane_iturbe@hotmail.es"));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Amaia")
				.append("password", "Amaia")
				.append("edad", "36")
				.append("tipo", "nivel 2")
				.append("email", "amaia55a@gmail.es"));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Jon")
				.append("password", "Jon")
				.append("edad", "20")
				.append("tipo", "nivel 1")
				.append("email", "jonbart@gmail.com"));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Unai")
				.append("password", "Unai")
				.append("edad", "24")
				.append("tipo", "nivel 1")
				.append("email", "uni.bertso@opendeusto.es"));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Eneko")
				.append("password", "Eneko")
				.append("edad", "29")
				.append("tipo", "nivel 3")
				.append("email", "ene_32@hotmail.es"));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Ana")
				.append("password", "Ana")
				.append("edad", "47")
				.append("tipo", "nivel 3")
				.append("email", "art_12@gmail.com"));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Garazi")
				.append("password", "Garazi")
				.append("edad", "52")
				.append("tipo", "nivel 4")
				.append("email", "garazi.lauzirika@deusto.es"));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Ainhoa")
				.append("password", "Ainhoa")
				.append("edad", "31")
				.append("tipo", "nivel 2")
				.append("email", "ainho19@gmail.com"));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Ander")
				.append("password", "Ander")
				.append("edad", "44")
				.append("tipo", "nivel 4")
				.append("email", "ander_xy@hotmail.es"));
		mongoClient.close();
		
		
		
	}
	public class JavaMongodbInsertData {
	    private MongoClient mongoClient;    // Java MongoDB client (Cliente Java MongoDB)
	    private MongoDatabase mongodb;      // Database object (Objeto base de datos)
	}
}
