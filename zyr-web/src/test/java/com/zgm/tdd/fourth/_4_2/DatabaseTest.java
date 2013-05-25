package com.zgm.tdd.fourth._4_2;

import org.junit.Test;

import com.zgm.tdd.fourth._4_2.Database;

public class DatabaseTest {

	@Test
	public void testObjectExists() throws Exception {
		
		org.junit.Assert.assertTrue(Database.objectExists("123"));
	}
	
}
