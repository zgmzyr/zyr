package com.zgm.tdd.fourth._5_1_1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 结果状态验证
 * @author zgm
 *
 */
public class ResultingStateAssertion {
	
	@Test
	public void sizeOfListReflectsItemsAdedToIt() throws Exception {
		List<String> list = new ArrayList<String>();
		list.add("something");
		
		org.junit.Assert.assertEquals(1, list.size());
	}
}
