package com.zgm.tdd.fourth._4_3;

/**
 * 隔离依赖
 * @author zgm
 *
 */

public class OrderProcessor {

	public void process(Order order) {
//		PricingService service = PricingService.getInstance();
		PricingService service = this.getPricingService(); //这就是接缝
	}

	private PricingService getPricingService() {
		return PricingService.getInstance(); //入侵点
	}
}
