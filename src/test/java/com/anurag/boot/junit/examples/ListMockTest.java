package com.anurag.boot.junit.examples;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {

	private List list;

	@Before
	public void setup() {
		list = mock(List.class);
	}

	@Test
	public void size_basic() {

		when(list.size()).thenReturn(5);
		assertEquals(5, list.size());
	}

	@Test
	public void size_basic_return_multuiple_values() {
		when(list.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, list.size());
		assertEquals(10, list.size());
	}

	@Test
	public void return_with_generic_parameter() {
		when(list.get(anyInt())).thenReturn("Anurag");
		assertEquals("Anurag", list.get(0));
		assertEquals("Anurag", list.get(1));
	}
	
	@Test
	public void verifyMockMethods() {
		String value = (String) list.get(0);
		verify(list).get(0); 
		verify(list, atLeast(1)).get(0);
		verify(list, times(1)).get(0);
		verify(list, atLeastOnce()).get(0);
		//verify(list, never()).get(0);
	}
	
	@Test
	public void argumentCaptor() {
		list.add("Anurag");
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		verify(list).add(argumentCaptor.capture());
		assertEquals("Anurag", argumentCaptor.getValue());
		
	}
	
	@Test
	public void multipleArgumentCaptor() {
		list.add("Anurag");
		list.add("Annu");
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		verify(list,times(2)).add(argumentCaptor.capture());
		
		List<String> values = argumentCaptor.getAllValues();
		assertEquals("Anurag",values.get(0));
		assertEquals("Annu", values.get(1));
	}
	
	@Test
	public void mocking() {
		ArrayList mockArrayList = mock(ArrayList.class);
		System.out.println(mockArrayList.get(0));//null
		System.out.println(mockArrayList.size());//0
		mockArrayList.add("Test1");
		mockArrayList.add("Test2");
		System.out.println(mockArrayList.size());//0
		when(mockArrayList.size()).thenReturn(5);
		System.out.println(mockArrayList.size());//5
	}
	
	@Test
	public void spying() {
		ArrayList mockArrayList = spy(ArrayList.class);
		mockArrayList.add("Test1");
		System.out.println(mockArrayList.get(0));//null
		System.out.println(mockArrayList.size());//0
		mockArrayList.add("Test2");
		System.out.println(mockArrayList.size());//0
		when(mockArrayList.size()).thenReturn(5);
		System.out.println(mockArrayList.size());//5
	}

}
