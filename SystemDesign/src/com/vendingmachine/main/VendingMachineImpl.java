package com.vendingmachine.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class VendingMachineImpl implements VendingMachine {

	private Inventory<Item> itemInventory;
	private Inventory<Coin> changeInventory;
	public Item currentItem;
	public int currentBalance;
	
	public VendingMachineImpl(Inventory<Item> itemInventory, Inventory<Coin> changeInventory) {
		this.itemInventory=itemInventory;
		this.changeInventory=changeInventory;
	}
	
	@Override
	public Set<Item> showAllItems() {
		return itemInventory.getAll().keySet();
	}
	
	@Override
	public Inventory<Item> showAllItemsWithQuantity() {
		return itemInventory;
	}

	@Override
	public int selectItem(Item item) throws SoldOutException {
		if(itemInventory.hasItem(item)) {
			currentItem=item;
			return item.getPrice();
		}
		throw new SoldOutException(item+" is not available in inventory.");
	}

	@Override
	public void takeCoin(Coin coin) {
		currentBalance=currentBalance+coin.getValue();
	}

	@Override
	public void addItems(Item item, int quantity) {
		int count=itemInventory.add(item, quantity);
		System.out.println(count+" "+item.getName()+ "added to the inventory");
	}

	@Override
	public void addChange(Coin coin, int quantity) {
		int count=changeInventory.add(coin, quantity);
		System.out.println(count+" Coins of "+coin.getName()+" rupees are added to the inventory");
	}

	@Override
	public void reset() {
		itemInventory.clear();
		changeInventory.clear();
		System.out.println("Nothing in vending machine");
	}

	@Override
	public Cart<Item, List<Coin>> collectItemAndChange()
			throws ChangeNotAvailableException, SoldOutException, NotFullPaidException {
		Item item=currentItem;
		List<Coin> change=Collections.EMPTY_LIST;
		if(itemInventory.hasItem(currentItem)) {
			if(isFullPaid()) {
				if(isChangeAvailable()) {
					item=collectItem(item);
					if(item!=null) {
						change=collectChange();
					}else {
						throw new SoldOutException("Item is not available right now");
					}
				}else {
					throw new ChangeNotAvailableException("Change is not available");
				}
			}else {
				throw new NotFullPaidException("Payment remaining", currentItem.getPrice()-currentBalance);
			}
		}else {
			throw new SoldOutException("Item is not available right now");
		}
		return new Cart<Item, List<Coin>>(item, change);
	}
	
	private boolean isFullPaid() {
		if(currentBalance>=currentItem.getPrice()) {
			return true;
		}
		return false;
	}
	
	private Item collectItem(Item item) {
		int result = itemInventory.deduct(item);
		if(result>0) {
			System.out.println("Item Inventory Updated successfully.");
			return item;
		}
		return null;
	}
	
	private boolean isChangeAvailable() {
		try {
			getChange();
		}catch(ChangeNotAvailableException e) {
			return false;
		}
		return true;

	}

	private List<Coin> collectChange(){
		List<Coin> change=Collections.EMPTY_LIST;
		if(isChangeAvailable()) {
			change=getChange();
		}
		if(!change.isEmpty()) {
			changeInventory.deductMany(change);
		}
		return change;
	}
	
	private List<Coin> getChange() throws ChangeNotAvailableException{
		List<Coin> change=new ArrayList<>();
		int remainingAmount=currentBalance-currentItem.getPrice();
		while(remainingAmount!=0) {
			if(remainingAmount>=Coin.TWENTY.getValue() && changeInventory.hasItem(Coin.TWENTY)) {
				remainingAmount=remainingAmount-Coin.TWENTY.getValue();
				change.add(Coin.TWENTY);
			}else if(remainingAmount>=Coin.TEN.getValue() && changeInventory.hasItem(Coin.TEN)) {
				remainingAmount=remainingAmount-Coin.TEN.getValue();
				change.add(Coin.TEN);
			}else if(remainingAmount>=Coin.FIVE.getValue() && changeInventory.hasItem(Coin.FIVE)) {
				remainingAmount=remainingAmount-Coin.FIVE.getValue();
				change.add(Coin.FIVE);
			}else {
				throw new ChangeNotAvailableException("Chnage not available for amount "+remainingAmount);
			}
		}
		return change;
	}

	
}
