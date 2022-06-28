package com.revature.BaseModels;

public class Customer {
	
	private int id;
	private String name;
	private String username;
	private String email;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", password="
				+ password + "]";
	}
	public static void printMenu() {
		System.out.println("1: View all items in the shop");
		System.out.println("2: Make an offer for a vehicle");
		System.out.println("3: View items you own");
		System.out.println("4: View remaining payments");
	}
	
	
	
}
