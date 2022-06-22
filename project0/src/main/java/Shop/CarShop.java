package Shop;

import com.revature.util.*;
import java.util.Scanner;

public class CarShop {

	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		String username = "";
		String password = "";
		int end = 1;

		do {
			System.out.println("Hello! Welcome to Grizzlies Used Auto Shop");
			System.out.println();
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
		
}
