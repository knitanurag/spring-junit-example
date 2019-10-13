package com.anurag.boot.junit.controller.spike;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	
	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"quantity\":10,\"price\":100}";

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void jsonAssert() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\"}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}

}
