package com.hackathon2014.glass;

public class BestRetailer {
	public String name = "";
		
	public double price = 0.0;
	
	
	public BestRetailer(String name, double price) {
		this.name = name;
		this.price = price;
		
	}
	
	public String toString() {
		String out = "Name: " + this.name + "\n";
		out += "Price: " + price + "\n";
		return out;
	}
}
