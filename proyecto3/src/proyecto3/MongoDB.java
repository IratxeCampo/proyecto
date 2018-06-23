package proyecto3;
import org.bson.Document;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.Block;


import static java.util.Arrays.asList;

import java.rmi.UnknownHostException;

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
							.append("tituloOpinion", "Satisfecho")
							.append("opinion", "Un hotel de lujo en el centro de Accra que, además de la comodidad "
									+ "y limpieza de las habitaciones y la calidad del descanso, cuenta con un buen "
									+ "buffet que mezcla platos europeos con sabores locales; la repostería es muy "
									+ "destacable. Como curiosidad,el hotel muestra en sus pasillos y paredes esculturas "
									+ "y pinturas de autores locales muy sobresalientes."),
						new Document()
							.append("nombreHotel", "Reefs")
							.append("tituloOpinion", "Un buen sitio")
							.append("opinion", "La estadia fue correcta. Quizas esperaba algo mas por los comentarios"
									+ " que encontre antes de reservarlo pero lo que indicaba lo ofrecia, no mas ni menos.")
							)
					)
		);
				
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Jon")
				.append("password", "Jon")
				.append("edad", "20")
				.append("tipo", "nivel 1")
				.append("email", "jonbart@gmail.com")
				.append("opiniones", asList(
						new Document()
							.append("nombreHotel", "")
							.append("tituloOpinion", "")
							.append("opinion", "Es un hotel normal y a precio razonable, mi pareja y yo solo lo "
									+ "utilizábamos para ir a dormir ya que no buscábamos otra funcionalidad. Lo "
									+ "que deberían hacer es cambiar las almohadas y poner unas más duras, por lo"
									+ " demás es estupendo."))));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Maialen")
				.append("password", "Maialen")
				.append("edad", "50")
				.append("tipo", "nivel 4")
				.append("email", "maiial@gmail.com")
				.append("opiniones", asList(
						new Document()
						.append("nombreHotel", "")
						.append("tituloOpinion", "")
						.append("opinion", "Es un hotel excelentemente situado, con una recepción "
								+ "muy agradable y un bar muy luminoso donde se pueden tomar buenos"
								+ " cocktails. Las habitaciones son un tanto antiguas y no se corresponden a la"
								+ " imagen de la entrada."))));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Maddi")
				.append("password", "Maddi")
				.append("edad", "19")
				.append("tipo", "nivel 1")
				.append("email", "maddi_98@hotmail.es")
				.append("opinion", asList(
						new Document()
							.append("nombreHotel", "")
							.append("tituloOpinion", "")
							.append("opinion", "buena atención , buen servicio, habitación "
								+ "confortable y con todo lo necesario para que la estancia sea lo más "
								+ "agradable posible."))));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Asier")
				.append("password", "Asier")
				.append("edad", "28")
				.append("tipo", "nivel 1")
				.append("email", "art7@hotmail.es")
				.append("opinion", asList(
						new Document()
							.append("nombreHotel", "")
							.append("tituloOpinion", "")
							.append("opinion", "la atención del personal del hotel excelente y la habitación"
									+ " limpia y correcta. Buena insonorizacion de la habitación que garantiza buen "
									+ "descanso. lo unico malo es que el hotel no dispone de parking propio"))));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Maite")
				.append("password", "Maite")
				.append("edad", "41")
				.append("tipo", "nivel 3")
				.append("email", "mait_14@gmail.com")
				.append("opinion", asList(
						new Document()
							.append("nombreHotel", "")
							.append("tituloOpinion", "")
							.append("opinion", "Para ser un hotel con buena ubicación y lindo la atención deja mucho que "
									+ "desear poco o nada de servicio poco personal a pesar de estar pronto al carnaval..."
									+ " esperaba mucho más. Un desayuno con pocas cosas pocas frutas tres y nada de buenas "
									+ "sólo jugó de naranja esperaba probar mucho mas delas frutas de aca . "
									+ "Sólo un tipo de pan de molde en fin nada acordé al precio pagado"))));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Aitor")
				.append("password", "Aitor")
				.append("edad", "33")
				.append("tipo", "nivel 2")
				.append("email", "ai_tortilla@yahoo.es")
				.append("opinion", asList(
						new Document()
							.append("nombreHotel", "")
							.append("tituloOpinion", "")
							.append("opinion", "las comodidades e instalaciones son poco acogedoraspara un hotel de lujo,"
									+ " especialmente la habitación poco acogedora el conjunto muy impersonal demasiados"
									+ " espacios vacíos clima un poco frío en la habitación"))));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Ane")
				.append("password", "Ane")
				.append("edad", "30")
				.append("tipo", "nivel 3")
				.append("email", "ane_iturbe@hotmail.es")
				.append("opinion", asList(
						new Document()
							.append("nombreHotel", "")
							.append("tituloOpinion", "")
							.append("opinion", "El hotel muy bonito pero incómodo, la "
									+ "habitación es hermosa pero la cama doble es pequeña y el baño regular."))));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Amaia")
				.append("password", "Amaia")
				.append("edad", "36")
				.append("tipo", "nivel 2")
				.append("email", "amaia55a@gmail.es")
				.append("opinion", asList(
						new Document()
							.append("nombreHotel", "")
							.append("tituloOpinion", "")
							.append("opinion", "El hotel en si esta bastante bien, pero esta mal explotado... "
									+ "la comida para la categoria que es , y la variedad deja mucho que desear"))));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Unai")
				.append("password", "Unai")
				.append("edad", "24")
				.append("tipo", "nivel 1")
				.append("email", "uni.bertso@opendeusto.es")
				.append("opinion", asList(
						new Document()
							.append("nombreHotel", "")
							.append("tituloOpinion", "")
							.append("opinion", "Grandes instalaciones, pero lo mejor fue el trato que recibimos de "
									+ "todo el personal, un 10, en recepción una esmerada atención, y el personal del "
									+ "comedor y limpieza siempre con una sonrisa en la cara. Celebraba mi cumpleaños y"
									+ " recibí un buen detalle en la habitación"))));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Eneko")
				.append("password", "Eneko")
				.append("edad", "29")
				.append("tipo", "nivel 3")
				.append("email", "ene_32@hotmail.es")
				.append("opinion", asList(
						new Document()
							.append("nombreHotel", "")
							.append("tituloOpinion", "")
							.append("opinion", "Es un sitio muy agradable y muy relajante el personal es muy "
									+ "atento y servicial,nosotros somos repetidores van ya 5 estancias es genial."))));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Ana")
				.append("password", "Ana")
				.append("edad", "47")
				.append("tipo", "nivel 3")
				.append("email", "art_12@gmail.com")
				.append("opinion", asList(
						new Document()
							.append("nombreHotel", "")
							.append("tituloOpinion", "")
							.append("opinion", "Todo fabuloso. La única pega es que la piscina "
									+ "infantil está muy fria y a consecuencia estaba totalmente vacía."))));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Garazi")
				.append("password", "Garazi")
				.append("edad", "52")
				.append("tipo", "nivel 4")
				.append("email", "garazi.lauzirika@deusto.es")
				.append("opinion", asList(
						new Document()
							.append("nombreHotel", "")
							.append("tituloOpinion", "")
							.append("opinion", "Agradable estancia en un hotel bien ubicado y confortable."))));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Ainhoa")
				.append("password", "Ainhoa")
				.append("edad", "31")
				.append("tipo", "nivel 2")
				.append("email", "ainho19@gmail.com")
				.append("opinion", asList(
						new Document()
							.append("nombreHotel", "")
							.append("tituloOpinion", "")
							.append("opinion", "Confortable hotel con todos los servicios. Buenas y modernas "
									+ "instalaciones. Exquisita atención y trato personal. Restaurante buffet con "
									+ "calida. Situado en una zona centrica de la isla., muy turística."))));
		db.getCollection("usuarios").insertOne( 
				new Document()
				.append("nick", "Ander")
				.append("password", "Ander")
				.append("edad", "44")
				.append("tipo", "nivel 4")
				.append("email", "ander_xy@hotmail.es")
				.append("opinion", asList(
						new Document()
							.append("nombreHotel", "")
							.append("tituloOpinion", "")
							.append("opinion", "Mi estancia en el hotel es positiva, muy céntrico, el personal del h"
									+ "otel muy agradable y muy predispuesto a ayudar. 100% recomendable."))));
		mongoClient.close();
		
		
		
	}
	public static void main(String[] args) throws UnknownHostException {
		MongoClient mongoClient = new MongoClient();
	    MongoDatabase db = mongoClient.getDatabase("aplicacion");
	    
	    FindIterable<Document> iterable = db.getCollection("usuarios").find(
	    		new Document("nick", "Mikel").append("nombreHotel", "Reefs"));
	    iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		        System.out.println(document.get("nick"));
		    }
		});
	    
	    mongoClient.close();
	}
}
