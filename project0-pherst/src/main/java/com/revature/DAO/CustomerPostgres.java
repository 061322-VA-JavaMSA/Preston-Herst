package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.DBConnection;
import com.revature.BaseModels.Customer;

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
	
	public static int makeAnOffer(String username) throws SQLException {
		
		int end = 0;
		try{
			ItemsPostgres.viewAllItems();
			System.out.println();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		int j = 0;
		while(j!= 1) {
			System.out.println("enter the cardID for the car you would like to make an offer for.");
			System.out.print("CarID: ");
			int carID = 0;
			carID = sc.nextInt();
			
			System.out.println("What's your offer for this vehicle?");
			System.out.print("Offer: $");
			int offer = sc.nextInt();
			
			OffersPostgres.addOffer(username, carID, offer);
			
			System.out.println();
			System.out.println("Press 1 to return to the main menu, and 2 to make another offer");
			
			int choice = 0;
			
			if (choice == 1) {
				j = 1;
				end = 2;
				
			}
			else if (choice == 2) {
				j =2;
				end = 1;	
			}
		}
		return end;
	}
	public static void addCustomer(String name, String email, String user, String pass) throws SQLException {
		Connection conn = DBConnection.getSQLConnection();
		
		Statement s;
		PreparedStatement ps;
		String cust = "SELECT customerid FROM customers";
		s = conn.createStatement();
		ResultSet rs = s.executeQuery(cust);
		
		List<Customer> list = new ArrayList<Customer>();
		Customer c1 = null;
		while(rs.next()) {
			c1.setId(rs.getInt("customerid"));
			list.add(c1);
		}
		
		String add = "INSERT INTO customer values (?, ?, ?, ?, ?)";
		int index = (list.size() + 1);
		ps = conn.prepareStatement(add);
		ps.setInt(1, index);
		ps.setString(2, name);
		ps.setString(3, email);
		ps.setString(4, user);
		ps.setString(5, pass);
		ps.execute();
	}
}