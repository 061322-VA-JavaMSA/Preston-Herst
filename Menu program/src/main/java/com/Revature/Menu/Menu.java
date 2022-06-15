package com.Revature.Menu;
import java.util.Scanner;

public class Menu {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
//		loginScreen();
		menu();
		sc.close();
	}
	
//	public static void loginScreen() {
//		String username = "admin";
//		String password = "pass";
//		
//		System.out.println("Please enter your username");
//		String usernameInput = sc.nextLine();
//		System.out.println("Please enter your password");
//		String passwordInput = sc.nextLine();
//		
//		if(username.equals(usernameInput) && password.equals(passwordInput)) {
//			System.out.println("Welcome!");
//		} else {
//			System.out.println("Invalid credentials.");
//		}
//	}
	public static void menu() {
		/*
		 * Menu that gives a user multiple options:
		 * 	- 1: get a random number
		 *  - 2: reverse a String of the user's choice
		 *  - 3: exit the program
		 *  
		 *  this menu should repeat until the user decides to exit
		 */
		
		System.out.println("Please choose from the options below: ");
		System.out.println("1-Random Number \n2-Reverse String \n3-Exit program");
		System.out.print("Option: ");
		int userOption = sc.nextInt();
		
		switch(userOption) {
		case 1:
			double rand = Math.random();
			System.out.println("Random Number: "+ rand);
			break;
		case 2:
			System.out.println("Enter a String: ");
			String str = sc.nextLine();
			StringBuilder reverseStr = new StringBuilder(str);
			System.out.println("Reversed String: " + reverseStr.reverse());
			break;
		case 3:
			System.out.println("Goodbye!");
			System.exit(0);
		}
		
	}

}
