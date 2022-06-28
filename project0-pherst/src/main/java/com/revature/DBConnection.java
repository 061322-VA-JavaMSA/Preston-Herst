package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static String username = "postgres";
	private static String password = "M0ch1las";
	private static String url = "jdbc:postgresql://database-1.cgirejzkuupc.us-east-2.rds.amazonaws.com:5432/postgres";
	private static Connection c;
	public static Connection getSQLConnection() throws SQLException{
		try {
			if(c == null || c.isClosed()) {
				c = DriverManager.getConnection(url, username, password);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
