package com.revature;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerPostgres {

	public static int Login(String username) {
		Connection conn = null;
		String sqlCustomer = "SELECT username FROM customers WHERE username = '" + username + "'";
		Statement s;
		ResultSet rs;
		
		int x = 0;
		try {
			conn = DBConnection.getSQLConnection();
			s = conn.createStatement();
			rs = s.executeQuery(sqlCustomer);
			if(rs.next()) {
				x =1;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
		
	}
}
