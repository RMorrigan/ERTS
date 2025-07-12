package util;

import java.sql.*;

public class DatabaseUtil {
	
	private static final String URL = "jdbc:mysql://localhost/db_erts";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root1234";
	
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException{
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		return connection;
	}

}
