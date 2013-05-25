package com.zgm.tdd.fourth._2_3;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConceptTest {

	/**
	 * 基于状态的测试
	 */
	@Test
	public void listShouldNotBeEmptyAfterAddingSomethingToIt() {
		List<String> list = new ArrayList<String>();
		assertTrue(list.isEmpty());
		list.add("somethng");
		assertFalse(list.isEmpty());
	}
}
