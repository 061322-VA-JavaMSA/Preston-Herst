package com.revature.BaseModels;

public class CarsOwned {

	private int customerid;
	private String username;
	private String year;
	private String make;
	private String model;
	
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "CarsOwned [customerid=" + customerid + ", username=" + username + ", year=" + year + ", make=" + make
				+ ", model=" + model + "]";
	}
	
	
}
