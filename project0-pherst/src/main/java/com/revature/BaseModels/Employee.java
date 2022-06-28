package com.revature.BaseModels;

public class Employee {

	private int employeeid;
	private String name;
	private String username;
	private String email;
	private String password;
	
	public int getId() {
		return employeeid;
	}
	public void setId(int id) {
		this.employeeid = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;		
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static void printMenu() {
		System.out.println("Employee Menu:");
		System.out.println("1: View items in shop");
		System.out.println("2: view pending orders");
		System.out.println("3: View all payments");
	}
	@Override
	public String toString() {
		return "Customer [id=" + employeeid + ", name=" + name + ", username=" + username + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
}
