package com.revature.BaseModels;

public class Offers {

	private int employeeid;
	private String username;
	private int carid;
	private String make;
	private String model;
	private int offer;
	private String status;
	
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
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
	public int getOffer() {
		return offer;
	}
	public void setOffer(int offer) {
		this.offer = offer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Offers [customer ID: " + employeeid + ", username: " + username + ", carID: " + carid + ", make: " + make
				+ ", model: " + model + ", offer: $" + offer + ", status: " + status + "]";
	}
	
}
