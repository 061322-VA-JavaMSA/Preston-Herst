package com.revature.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.DBConnection;

public class CustomerPostgres {

	static Scanner sc = new Scanner(System.in); 
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
	public static int viewAllItems() {
		
		try{
			ItemsPostgres.viewAllItems();
			System.out.println();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		int back = 1;
		return back;
		
	}
	
	public static void makeAnOffer(String username) throws SQLException {
		
		try{
			ItemsPostgres.viewAllItems();
			System.out.println();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("enter the cardID for the car you would like to make an offer for.");
		System.out.print("CarID: ");
		int carID = 0;
		carID = sc.nextInt();
		
		System.out.println("What's your offer for this vehicle?");
		System.out.print("Offer: $");
		int offer = sc.nextInt();
		
		OffersPostgres.addOffer(username, carID, offer);
		
		
	}
}