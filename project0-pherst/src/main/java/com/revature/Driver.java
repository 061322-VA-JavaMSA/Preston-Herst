package com.revature;

import com.revature.BaseModels.Customer;
import com.revature.BaseModels.Employee;
import com.revature.BaseModels.Items;
import com.revature.DAO.CarsOwnedPostgres;
import com.revature.DAO.CustomerPostgres;
import com.revature.DAO.EmployeePostgres;
import com.revature.DAO.ItemsPostgres;
import com.revature.DAO.OffersPostgres;

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
		
		String name ="";
		String pass = "";
			int x = 0;
			int createOrLogin = 0;
			do {
				do {
					System.out.println("Welcome to Grizzlies Used Auto Shop!");
					System.out.println();
					
					System.out.println("Would you like to login or create a user?");
					System.out.println("Press 1 to login and 2 to create a user");
					System.out.println();
					
					System.out.print("Option: ");
					createOrLogin = sc.nextInt();
					
					if(createOrLogin == 1) {
						
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
						}
					else if(createOrLogin == 2) {
						System.out.println("What kind of user account would you like to create");
						System.out.print("(employee or customer): ");
						String position = sc.next();
						
						System.out.println();
						System.out.print("Enter your name: ");
						String cuName = sc.next();
						System.out.print("Enter your email: ");
						String cuEmail = sc.next();
						System.out.print("Enter your username: ");
						String cuUser = sc.next();
						System.out.print("Enter your password: ");
						String cuPass = sc.next();
						
						if(position.equals("employee")) {
							System.out.println("Adding employee");
							x =2;
						}
						else if(position.equals("customer")) {
							try{
								CustomerPostgres.addCustomer(cuName, cuEmail, cuUser, cuPass);
							}catch(Exception e) {
								e.printStackTrace();
							}
							x =2;
						}
					}
					}while (x != 2);
					
					try{
						ItemsPostgres.listOfItems();
						
						if(shopCustomer.Login(name) == 1) {
							
							int option =0;
							int back = 0;
							
							while (back != 2) {
								
								Customer.printMenu();
								System.out.print("option: ");
								option = sc.nextInt();
								
								if(option == 1) {
									back = shopCustomer.viewAllItems();
								}
								else if(option ==2) {
									back = shopCustomer.makeAnOffer(name);
								}
								else if(option ==3) {
									CarsOwnedPostgres.listOfCarsOwned(name);
								}
								else if(option ==4) {
									OffersPostgres.viewAllOffers();
								}
								else if(option == 5) {
									break;
								}
							}	
						}
						else if(shopEmployee.Login(name) ==1) {
						
							int option;
							int back = 0;
							while (back != 2) {
								Employee.printMenu();
								
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
								else if (option == 3) {
									OffersPostgres.viewAllOffers();
								}
								else if (option == 4) {
									break;
								}
							}	
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
				System.out.println("press 1 to end the program, 2 to return to login screen");
				System.out.print("Option: ");
				int endp = sc.nextInt();
				
				if(endp == 1) {
					x =1;
					System.out.println("Goodbye!");
				}
			}while (x != 1);	
	}
}
