package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
	private static Connection c;
	public static Connection getSQLConnection(String url, String user, String pass) throws SQLException{
		
		if(c == null || c.isClosed()) {
			c = DriverManager.getConnection(url, user, pass);
		}
		return c;
	}
}
