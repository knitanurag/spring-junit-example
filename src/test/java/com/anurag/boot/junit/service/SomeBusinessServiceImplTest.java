package com.anurag.boot.junit.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.anurag.boot.junit.dao.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessServiceImplTest {
	
	@InjectMocks
	SomeBusinessServiceImpl someBusinessService;
	
	@Mock
	SomeDataService someDataService;
	
	

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
		when(someDataService.retrieveAllData()).thenReturn(new int[]{1,2,3});
		assertEquals(6, someBusinessService.calculateSum());
	}

}
