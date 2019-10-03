package com.vendingmachine.main;

public class SoldOutException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String message;
	public SoldOutException(String messsage) {
		this.message=messsage;
	}
	public String getMessage() {
		return message;
	}
}
