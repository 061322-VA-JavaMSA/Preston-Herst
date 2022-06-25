package Shop;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.DBConnection;

public class CarShop {

	static Scanner sc = new Scanner(System.in);
	
	static Connection c;
	private static String url = "jdbc:postgresql://database-1.cgirejzkuupc.us-east-2.rds.amazonaws.com:5432/postgres";
	private static String username = "postgres";
	private static String password = "M0ch1las";
	
	public static void main(String[] args) {
		
		int end = 1;

		do {
			System.out.println("Hello! Welcome to Grizzlies Used Auto Shop");
			System.out.println();
			try {
			c = DBConnection.getSQLConnection(url, username, password);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("To login, press 1, to create a new account press 2.");
			System.out.print("option: ");
			int userChoice = sc.nextInt();
			System.out.println();
			
			if (userChoice == 1) {
				
				System.out.println("Please enter your username and password");
				
				System.out.print("username: ");
				username = sc.next();
				System.out.print("password: ");
				password = sc.next();
				
				
				
				
			}
			else if(userChoice == 2) {
				
//				createUser();
			}
			else {
				System.out.println("Exiting shop, goodbye!");
				end = 0;
			}
			System.out.println("username: " + username + "  " + "password: " + password);
			System.out.println();
			
		}while(end != 0);
		}
		
	public static void printCustomerMenu() {
		
	}
}
