package proyecto3;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;


import java.io.FileReader;
import java.util.Iterator;


public class lee_json {
	
	public static void main(String args[]) throws java.io.IOException {
		
		JSONParser parser = new JSONParser();
	
		
		try {
			
			Object obj = parser.parse(new FileReader("/Users/irati98o/Desktop/Usuarios.json"));
			
			JSONObject jsonObject = (JSONObject) obj;
			
			String opinion = (String) jsonObject.get("opinion");
			System.out.println(obj);

		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
