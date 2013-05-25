package com.zgm.tdd.fourth._5_1_3;

import java.util.ArrayList;
import org.junit.Test;

/**
 * 差值断言
 * @author zgm
 *
 */
public class DeltaAssertion {
	
	private ArrayList<String> list = new ArrayList<String>(); 
	
	@Test
	public void sizeOfListReflectsItemsAdedToIt() throws Exception {
		int sizeBefore = list.size();
		list.add("something");
		
		org.junit.Assert.assertEquals(sizeBefore + 1, list.size());
	}
}


