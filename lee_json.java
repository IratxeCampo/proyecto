import java.io.FileReader;
import com.
public class lee_json {
	public static void main(String args[]) throws java.io.IOException {
		JsonParser parser = new JsonParser();
		FileReader fr = new FileReader("Usuarios.json");
		JsonElement datos = parser.parse(fr);
		dumpJSONElement(datos);
	}
	

}
