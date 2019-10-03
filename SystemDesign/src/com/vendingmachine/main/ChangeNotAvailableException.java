package com.vendingmachine.main;

public class ChangeNotAvailableException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String message;

	public ChangeNotAvailableException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
