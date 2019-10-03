package com.vendingmachine.main;

public enum Coin {
	FIVE("Five", 5), TEN("Ten",10), TWENTY("Twenty",20); 
	
	private String name;
	private int value;
	Coin(String name, int value) {
		this.name=name;
		this.value=value;
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
}
