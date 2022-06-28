package com.revature.BaseModels;

public class Items {

	private String carid;
	private String carYear;
	private String make;
	private String model;
	private String type;
	private int price;
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCarid() {
		return carid;
	}
	public void setCarid(String string) {
		this.carid = string;
	}
	public String getCarYear() {
		return carYear;
	}
	public void setCarYear(String carYear) {
		this.carYear = carYear;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Items [carid: " + carid + ", carYear: " + carYear + ", make: " + make + ", model: " + model + ", type: "
				+ type + ", price: " +"$" + price + ", status: " + status + "]";
	}
	
	
	
	
	
}
