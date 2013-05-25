package com.zgm.tdd.fourth._3_1;

public class PriceServiceTestDouble extends PricingService {

	private float discount;

	public PriceServiceTestDouble(float discount) {
		super();
		this.discount = discount;
	}
	
	public float getDiscountPercentage(Customer c, Product p) {
		return discount;
	}
	
}
