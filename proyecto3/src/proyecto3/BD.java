package proyecto3;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {
	
	 private static Connection connection = null;
	 private static Statement statement = null;
	 
	 public static Connection initBD (String nombreBD) {
		 try{
			 Class.forName("org.sqlite.JDBC");
			 connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);
			 statement = connection.createStatement();
			 statement.setQueryTimeout(30);
			 return connection;
		 }catch (ClassNotFoundException | SQLException e){
			 return null;
		 }
	 }
	 
	 public static void close(){
		 try{
			 statement.close();
			 connection.close();
		 }catch(SQLException e){
			 e.printStackTrace();
		 }
	 }

	public static Connection getConnection() {
		return connection;
	}

	public static Statement getStatement() {
		return statement;
	}
	
	public static void crearTablaBD() {
		if(statement == null) return;
		try{
			statement.executeUpdate("create table "+ )
		}
	}
}
