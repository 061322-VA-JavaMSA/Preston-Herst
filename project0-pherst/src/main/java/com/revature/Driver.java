package com.revature;
import com.revature.BaseModels.Customer;
import com.revature.BaseModels.Employee;
import com.revature.BaseModels.Items;
import com.revature.DAO.CarsOwnedPostgres;
import com.revature.DAO.CustomerPostgres;
import com.revature.DAO.EmployeePostgres;
import com.revature.DAO.ItemsPostgres;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {
	
	private static Connection c;
	static Scanner sc = new Scanner(System.in);
	static CustomerPostgres shopCustomer = null;
	static EmployeePostgres shopEmployee = null;
	
	public static void main(String[] args) {
		
		try{
			c = DBConnection.getSQLConnection();
			System.out.println(c.getMetaData().getDriverName());
		}
		catch(Exception e) {
			e.printStackTrace();	
		}
		
		String name;
		String pass; 
		int x = 0;
		
		do {
			System.out.println("Please enter your username and password");
			System.out.print("username: ");
			name = sc.next();
			System.out.println("Please enter your password");
			System.out.print("password: ");
			pass = sc.next();
		
			if(shopCustomer.Login(name) ==1 || shopEmployee.Login(name) ==1) {
				System.out.println("user in database");
				System.out.println();
				x = 2;
				} 
			else {
					System.out.println();
					System.out.println("user not in database");
					System.out.println();
					x =1;
				}
		}while (x != 2);
		
		try{
			ItemsPostgres.listOfItems();
			
			if(shopCustomer.Login(name) == 1) {
				
				int option =0;
				int back = 0;
				Customer.printMenu();
				
				while (back != 2) {
					
					System.out.print("option: ");
					option = sc.nextInt();
					
					if(option == 1) {
						back = shopCustomer.viewAllItems();
					}
					else if(option ==2) {
						shopCustomer.makeAnOffer(name);
					}
					else if(option ==3) {
						CarsOwnedPostgres.listOfCarsOwned(name);
					}
					else if(option ==4) {
						System.out.println("view remaining payments");
					}
					Customer.printMenu();
				}
					
			}
			else if(shopEmployee.Login(name) ==1) {
			
				Employee.printMenu();
				
				int option;
				int back = 0;
				while (back != 2) {
					
					System.out.print("option: ");
					option = sc.nextInt();
					
					if(option == 1) {
						System.out.println();
						back = shopEmployee.addingOrDeleting();
					}
					else if(option == 2) {
						System.out.println();
						back = shopEmployee.viewPendingOrders();
					}
					Employee.printMenu();
				}	
			}
		}catch(Exception e ) {
			e.printStackTrace();
		}
		System.out.println("End of program");
	}
}
	
