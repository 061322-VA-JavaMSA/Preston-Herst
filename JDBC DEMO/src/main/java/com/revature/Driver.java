package com.revature;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Driver {
	

	private static Connection c;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//defining values for database login
		String username = "postgres";
		String password = "M0ch1las";
		String url = "jdbc:postgresql://database-1.cgirejzkuupc.us-east-2.rds.amazonaws.com:5432/postgres";
		
		//establishing a connection to the database
		try{
			c = DBConnection.getSQLConnection(url, username, password);
			System.out.println(c.getMetaData().getDriverName());
		}
		catch(Exception e) {
			e.printStackTrace();	
		}
		
		//defining test values to see if user is in either tables
		String user1 = "jj850";
		String name;
		String pass;
		
		//do while statement to get username and pass
		//checks to see if user is in tables
		//if not iterates again for them 
		int x = 0;
		do {
			System.out.println("Please enter your username and password");
			System.out.print("username: ");
			name = sc.next();
			System.out.println("Please enter your password");
			System.out.print("password: ");
			pass = sc.next();
		
			if(customerLogin(name, c) ==1 || employeeLogin(name,c) ==1) {
					System.out.println("user in database");
					System.out.println();
					x = 2;
				}
			else
				{
					System.out.println();
					System.out.println("user not in database");
					System.out.println();
					x =1;
				}
		}while (x != 2);
		
		
		if(customerLogin(name, c) == 1) {
			System.out.println("Customer menu");
		}
		else if(employeeLogin(name, c) == 1) {
			printEmployeeMenu();
			
		}
		System.out.println("End of program");
	}
	
	
	
	//Function to determine if user is in customer table
	public static int customerLogin(String username, Connection cc) {
		String sqlCustomer = "SELECT username FROM users WHERE username = '" + username + "'";
		Statement s;
		ResultSet rs;
		int x = 0;
		try {
		s = cc.createStatement();
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
	
	//function to determine if user is in employee table
	public static int employeeLogin(String username, Connection cc) {
		String sqlEmployee = "SELECT username FROM customers WHERE username = '" + username + "'";
		int x = 0;
		try {
		Statement s = cc.createStatement();
		ResultSet rs = s.executeQuery(sqlEmployee);
		if(rs.next()) {
			x = 1;
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
	
	public static void printEmployeeMenu() {
		System.out.println("Employee Menu:");
		System.out.println("1: View items in shop");
		System.out.println("2: view pending orders");
		System.out.println("3: View all payments");
		
	}
}
