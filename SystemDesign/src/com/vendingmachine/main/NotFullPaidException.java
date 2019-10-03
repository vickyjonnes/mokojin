package com.vendingmachine.main;

public class NotFullPaidException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String message;
	private int remainigAmnt;
	public NotFullPaidException(String message, int remainigAmnt) {
		super();
		this.message = message;
		this.remainigAmnt = remainigAmnt;
	}
	public String getMessage() {
		return message+remainigAmnt;
	}
}
