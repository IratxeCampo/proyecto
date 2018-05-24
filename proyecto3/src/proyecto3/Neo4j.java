package proyecto3;

import java.sql.*;

public class Neo4j {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class.forName("org.neo4j.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:neo4j:http://localhost:7474", "neo4j", "123");
		
		String query = "MATCH (h:Hotel)-[:ESTA_EN]->(c:Ciudad) return c.name";
		try (PreparedStatement stmt = con.preparedStatement(query)) {
			stmt.setString(0, "Luanda");
			
			try (ResultSet rs = stmt.executeQuery()) {
				System.out.println("Ciudades");
				while (rs.next()) {
					System.out.println(rs.getString("c.name"));
				}
			}
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
