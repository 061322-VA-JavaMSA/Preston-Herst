package com.revature;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Driver {
	

	private static Connection c;
	public static void main(String[] args) {
		
		String username = "postgres";
		String password = "M0ch1las";
		String url = "jdbc:postgresql://database-1.cgirejzkuupc.us-east-2.rds.amazonaws.com:5432/postgres";

		try{
			c = ConnectionUtil.getDBConnection(url, username, password);
			System.out.println(c.getMetaData().getDriverName());
		}
		catch(Exception e) {
			e.printStackTrace();	
		}
		
		try {
			String sql = "select * from users where id =1;";
			
			Connection c = DriverManager.getConnection(url, username, password);
			Statement s = c.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
		}
		catch(Exception e) {
			e.printStackTrace();	
		}

		System.out.println("End of program");
	}
	
	
}
