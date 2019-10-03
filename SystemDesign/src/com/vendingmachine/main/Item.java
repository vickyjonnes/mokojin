package com.vendingmachine.main;

public enum Item {
	PEPSI("Pepsi", 35), PARLE_G("Parle-G",5), LAYS("Lays",15), FROOTI("Frooti",10);
	
	private String name;
	private int price;
	Item(String name, int value) {
		this.name=name;
		this.price=value;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
}
