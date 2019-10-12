package com.anurag.boot.junit.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.anurag.boot.junit.dao.SomeDataService;

public class SomeBusinessServiceImpl implements SomeBusinessService {

	@Autowired
	SomeDataService someDataService;
	
	
	@Override
	public int calculateSum(){
		int[] values = someDataService.retrieveAllData();
		int sum = 0;
		for(int value : values) {
			sum += value;
		}
		return sum;
	}
}
