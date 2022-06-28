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
import com.revature.BaseModels.Items;

public class ItemsPostgres {
	
	static Scanner sc = new Scanner(System.in);
	public static List<Items> list = null;
	
	public static List<Items> listOfItems() throws SQLException {
		
		Connection cc = DBConnection.getSQLConnection();
		String sql = "SELECT * FROM items";
		Statement s;
		ResultSet rs;
		Items item = null;
		list = new ArrayList<Items>();
		
		try {
			s = cc.createStatement();
			rs = s.executeQuery(sql);
			
			while (rs.next()) {
				item = new Items();
				item.setCarid(rs.getString("carid"));
				item.setCarYear(rs.getString("caryear"));
				item.setMake(rs.getString("make"));
				item.setModel(rs.getString("model"));
				item.setType(rs.getString("type"));
				item.setPrice(rs.getInt("price"));
				item.setStatus(rs.getString("status"));
				
				list.add(item);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		}
	
	public static void viewAllItems() throws SQLException {
		Connection c = DBConnection.getSQLConnection();
		list = listOfItems();
		for(int i = 0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void addToList() {
		
		PreparedStatement add;
		int carID;
		
		System.out.println("Please enter the cars ID, year, make, model, type, price, and status.");
		System.out.print("Car ID: ");
		carID = sc.nextInt();
		System.out.print("Year: ");
		String year = sc.next();
		System.out.print("Make: ");
		String make = sc.next();
		System.out.print("Model: ");
		String model = sc.next();
		System.out.print("Type: ");
		String type = sc.next();
		System.out.print("Price: ");
		int price = sc.nextInt();
		String status = "For sale";
		
		try {
			Connection conn = DBConnection.getSQLConnection();
			String adding = "INSERT INTO items(carid, caryear, make, model, type, price, status) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			add = conn.prepareStatement(adding);
			add.setInt(1, carID);
			add.setString(2, year);
			add.setString(3, make);
			add.setString(4, model);
			add.setString(5, type);
			add.setInt(6, price);
			add.setString(7, status);
			
			add.execute();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	public static void deleteFromList() {
		
		PreparedStatement del;
		PreparedStatement changeRow;
		PreparedStatement updateOffers;
		System.out.println("Enter the carid for the car you would like to delete");
		System.out.print("CarID: ");
		
		int carID;
		carID = sc.nextInt();
		
		try {
			Connection conn = DBConnection.getSQLConnection();
			
			String offers = "delete from offers where carid = (?)";
			updateOffers = conn.prepareStatement(offers);
			updateOffers.setInt(1, carID);
			updateOffers.execute();
					
			String delete = "delete from items where carid = (?)";
			del = conn.prepareStatement(delete);
			del.setInt(1,carID);
			del.execute();
			
			String update = "update items set carid = carid -1 where carid > ?";
			changeRow = conn.prepareStatement(update);
			changeRow.setInt(1, carID);
			changeRow.execute();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
