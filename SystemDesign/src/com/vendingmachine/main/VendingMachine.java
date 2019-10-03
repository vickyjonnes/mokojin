package com.vendingmachine.main;

import java.util.List;
import java.util.Set;

public interface VendingMachine {
	public Set<Item> showAllItems();
	public Inventory<Item> showAllItemsWithQuantity();
	public int selectItem(Item item) throws SoldOutException;
	public void takeCoin(Coin coin);
	public void addItems(Item item, int quantity);
	public void addChange(Coin coin, int quantity);
	public void reset();
	public Cart<Item, List<Coin>> collectItemAndChange() throws ChangeNotAvailableException,SoldOutException,NotFullPaidException;
}
