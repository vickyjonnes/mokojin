package com.vendingmachine.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory<T> {
	private final Map<T, Integer> inventory =new HashMap<>();
	
	public boolean hasItem(T item) {
		return inventory.containsKey(item);
	}
	
	public Integer add(T item, Integer count) {
		return inventory.put(item, getCount(item)+count);
	}
	
	public Integer getCount(T item) {
		return inventory.get(item)==null?0:inventory.get(item);
	}
	
	public Integer deduct(T item) {
		if(hasItem(item)) {
			if(getCount(item)>1) {
				add(item, getCount(item)-1);
			}else if(getCount(item)==1) {
				inventory.remove(item);
			}
			return 1;
		}
		return -1;
	}
	
	public Integer deductMany(List<T> item) {
		for(T i:item) {
			if(hasItem(i)) {
				deduct(i);
			}else {
				return -1;
			}
		}
		return 1;
	}
	
	public void clear() {
		inventory.clear();
	}
	
	public Map<T, Integer> getAll(){
		return inventory;
	}
}
