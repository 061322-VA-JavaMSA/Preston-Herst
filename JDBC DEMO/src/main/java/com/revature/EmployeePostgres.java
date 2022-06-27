package com.revature;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

	
public class EmployeePostgres {
	static Scanner sc = new Scanner(System.in);

	public static int Login(String username) {
		Connection conn = null;
		String sqlCustomer = "SELECT username FROM employees WHERE username = '" + username + "'";
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
	
	public static int addingOrDeleting() {
		
		int back = 0;
		int j =0;
		try {
			ItemsPostgres.viewAllItems();
			System.out.println();
			
			
			while(j != 1) {
			
				System.out.println("would you like to add or delete an item?");
				String change;
				System.out.print("(add or delete): ");
				change = sc.next();
				
				if (change.equals("add")) {
					ItemsPostgres.addToList();
					System.out.println("Updated list:");
					ItemsPostgres.viewAllItems();
					System.out.println();
					
				} else if(change.equals("delete")) {
					ItemsPostgres.deleteFromList();
					System.out.println("Updated list:");
					ItemsPostgres.viewAllItems();
					System.out.println();
				}
				
				System.out.println("Press 1 to go back to the main menu, and 2 to add or delete another item");
				int goAgain =0;
				System.out.print("Option: ");
				goAgain = sc.nextInt();
				
				if(goAgain == 1) {
					j = 1;
					back = 1;
				}
				else if(goAgain == 2) {
					j =2;
					back =2;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return back;
		}
}
