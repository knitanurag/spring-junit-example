package com.anurag.boot.junit.controller;


import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void item_basic_test() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andReturn();
		assertEquals("{\"id\":1,\"name\":\"Ball\",\"quantity\":10,\"price\":100}", result.getResponse().getContentAsString());
	}
	@Test
	public void item_basic_response_status_test() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"quantity\":10}")).andReturn();
		assertEquals("{\"id\":1,\"name\":\"Ball\",\"quantity\":10,\"price\":100}", result.getResponse().getContentAsString());
	}

}
