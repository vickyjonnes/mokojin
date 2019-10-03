package com.vendingmachine.test;

import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.vendingmachine.main.Cart;
import com.vendingmachine.main.Coin;
import com.vendingmachine.main.Inventory;
import com.vendingmachine.main.Item;
import com.vendingmachine.main.SoldOutException;
import com.vendingmachine.main.VendingMachine;
import com.vendingmachine.main.VendingMachineImpl;

@RunWith(JUnit4.class)
public class VendingMachineTest {
	private Inventory<Item> itemInventory;
	private Inventory<Coin> changeInventory;
	private VendingMachine vm;
	
	@Before
	public void init() {
		itemInventory=new Inventory<>();
		changeInventory=new Inventory<>();
		Stream.of(Item.values()).forEach((i)->itemInventory.add(i, 10));
		Stream.of(Coin.values()).forEach((i)->changeInventory.add(i, 5));
		vm=new VendingMachineImpl(itemInventory,changeInventory);
	}
	
	@Test
	public void testShowAllItem() {
		Assert.assertFalse(vm.showAllItems().isEmpty());
		vm.showAllItems().forEach(System.out::println);
	}
	
	@Test
	public void testSelectAvailableItem() {
		Item selection = Item.PEPSI;
		Assert.assertEquals(selection.getPrice(), 35);
	}
	
	@Test(expected=SoldOutException.class)
	public void testSelectUnAvailableItem() {
		Inventory<Item> items=new Inventory<>();
		items.add(Item.FROOTI, 3);
		VendingMachine v=new VendingMachineImpl(items, null);
		v.selectItem(Item.LAYS);
	}
	
	@Test
	public void testAddItem() {
		vm.addItems(Item.LAYS, 3);
		Assert.assertEquals(Integer.valueOf(13), vm.showAllItemsWithQuantity().getCount(Item.LAYS));
	}
	
	@Test
	public void testCollectItemAndChange() {
		vm.takeCoin(Coin.TWENTY);
		vm.takeCoin(Coin.TWENTY);
		vm.selectItem(Item.PEPSI);
		Cart<Item, List<Coin>> cart=vm.collectItemAndChange();
		
		Assert.assertNotNull(cart);
		
		Assert.assertEquals(Item.PEPSI, cart.getItem());
		
		Assert.assertFalse(cart.getChange().isEmpty());
		
		Assert.assertEquals(Coin.FIVE, cart.getChange().get(0));
	}
	
}
