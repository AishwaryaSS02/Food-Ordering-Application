package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.tap.model.User;

public class DBconnection {
	
	private static String URL="jdbc:mysql://localhost:3306/dao";
	private static String USERNAME="root";
	private static String PASSWORD="Aishwarya";
	private static Connection connection=null;
	
	public static Connection getConnection()
	{
	
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return connection;		

	}
}
