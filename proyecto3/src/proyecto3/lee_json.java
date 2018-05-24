import java.io.FileReader;
import com.*;
public class lee_json {
	public static void main(String args[]) throws java.io.IOException {
		FileReader fr = new FileReader("Usuarios.json");
		
		JsonParser parser = fr.createParser(json);
		
		while (parser.hasNext()){
			JsonParser.Event event = parser.next();
			switch(event) {
			case KEY_NAME:
				if (parser.getString().equalsIgnoreCase(key_to_find));
				event = parser.next();
				if(event == VALUE_STRING || event == VALUE_NUMBER){
					return parser.getString();
				}
			}
			break;
		}
		
	
	}
	return null;

}
