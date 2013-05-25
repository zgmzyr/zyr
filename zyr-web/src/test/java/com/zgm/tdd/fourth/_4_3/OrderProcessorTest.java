package com.zgm.tdd.fourth._4_3;

import org.junit.Test;

import com.zgm.tdd.fourth._4_3.OrderProcessor;
import com.zgm.tdd.fourth._4_3.PricingService;

public class OrderProcessorTest {

	@Test
	public void testOrderProcessByExploitingTheSeam() throws Exception {
		OrderProcessor p = new OrderProcessor() {
			@Override
			protected PricingService getPricingService() {
				return new FakePricingService(); //通过入侵点使用接缝
			}
		};
	}
}
