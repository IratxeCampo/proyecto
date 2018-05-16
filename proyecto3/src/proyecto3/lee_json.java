package proyecto3;
import java.io.FileReader;

import jdk.nashorn.internal.parser.JSONParser;

public class lee_json {
	public static void main(String args[]) throws java.io.IOException {
		JSONParser parser = new JSONParser(null, null, false);
		FileReader fr = new FileReader("Usuarios.json");
//		JsonElement datos = parser.parse(fr);
//		dumpJSONElement(datos);
	}
	

}
