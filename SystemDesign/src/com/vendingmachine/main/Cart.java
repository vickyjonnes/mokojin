package com.vendingmachine.main;

public class Cart<T1, T2> {
	private T1 item;
	private T2 change;
	
	public Cart(T1 first, T2 second) {
		this.item=first;
		this.change=second;
	}
	
	public T1 getItem() {
		return item;
	}
	public T2 getChange() {
		return change;
	}
}
