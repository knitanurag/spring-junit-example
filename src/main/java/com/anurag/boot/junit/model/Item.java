package com.anurag.boot.junit.model;

import java.math.BigDecimal;

public class Item {

	private int id;
	private String name;
	private int quantity;
	private BigDecimal price;

	public Item(int id, String name, int quantity, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return String.format("Item[%d, %s, %d, %.2f]", id, name, price, quantity);
	}

}
