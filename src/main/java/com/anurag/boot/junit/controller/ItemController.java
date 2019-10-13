package com.anurag.boot.junit.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.boot.junit.model.Item;

@RestController
public class ItemController {
	
	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1, "Ball", 10, BigDecimal.valueOf(100));
		
	}
	

}
