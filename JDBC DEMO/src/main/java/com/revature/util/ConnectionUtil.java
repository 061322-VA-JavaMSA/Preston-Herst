package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection c;
	
	public static Connection getDBConnection(String url, String user, String pass) throws SQLException{
		
		if(c == null || c.isClosed()) {
			c = DriverManager.getConnection(url, user, pass);
		}
		return c;
	}
}
