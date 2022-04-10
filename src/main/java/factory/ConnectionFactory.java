package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/produto";
	
	public static Connection createConnectionToMySql() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");	
		Connection connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		Connection connection = createConnectionToMySql();
		if (connection != null)
			connection.close();
	}
	
}
