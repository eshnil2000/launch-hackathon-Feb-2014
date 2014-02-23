package com.hackathon2014.glass;

public class Product {

	
	public String description = "";
	
	public String imageUrl = "";
	
	public double price = 0.0;
	
	
	public Product(String desc, String img, double price) {
		this.description = desc;
		this.imageUrl = img;
		this.price = price;
		
	}
	
	public String toString() {
		String out = "Description: " + this.description + "\n";
		out += "ImageUrl: " + imageUrl + "\n";
		out += "Price: " + price + "\n";
		return out;
	}
}
