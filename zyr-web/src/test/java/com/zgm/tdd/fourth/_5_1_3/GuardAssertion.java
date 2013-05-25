package com.zgm.tdd.fourth._5_1_3;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 防卫断言
 * @author zgm
 *
 */
public class GuardAssertion {
	
	@Test
	public void listIsNotLongerEmptyAfterAddingAnItemToIt() throws Exception {
		List<String> list = new ArrayList<String>();
		assertTrue(list.isEmpty());
		list.add("something");
		assertFalse(list.isEmpty());
	}
}


