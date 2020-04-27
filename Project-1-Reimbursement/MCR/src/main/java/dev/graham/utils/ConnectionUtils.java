package dev.graham.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	public static Connection createConnection() 
	{
		try {
			//create a properties object to store information
			
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conn = DriverManager.getConnection
					("jdbc:mariadb://projectdb.cu1md7k1zskf.us-east-2.rds.amazonaws.com:3306/basketballdb?user=Nuria&password=Destinyaws");
			return conn;
		}
		catch (SQLException e) {			
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		
	}

}


