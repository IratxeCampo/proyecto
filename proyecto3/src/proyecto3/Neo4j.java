package proyecto3;

import java.sql.*;
import org.neo4j.driver.internal.connector.socket.*;
import org.neo4j.driver.v1.GraphDatabase;
public class Neo4j {

	public static void main(String[] args) {
		
		try{
			
		Class.forName("org.neo4j.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:neo4j:http://localhost:7474", "neo4j", "1234");
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("MATCH (n) RETURN n LIMIT 500");
		
		while(rs.next()){
			System.out.println(rs.getString("n"));
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}
