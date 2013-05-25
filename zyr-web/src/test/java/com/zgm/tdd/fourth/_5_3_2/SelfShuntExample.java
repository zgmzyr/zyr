package com.zgm.tdd.fourth._5_3_2;

/**
 * 测试模式 ：
 * 2.自分流模式 
 * @author zgm
 *
 */

public class SelfShuntExample implements PricingService {

	@Override
	public float getDiscountPercentage(Customer c, Product p) {
		return 10.0f;
	}
	
	@Test
	public void testOrderProcessorWithMockObject() throws Exception {
		
	}
}
