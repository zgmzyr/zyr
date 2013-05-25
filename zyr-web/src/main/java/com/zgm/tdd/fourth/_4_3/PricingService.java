package com.zgm.tdd.fourth._4_3;

public class PricingService {
	private static PricingService instance = new PricingService(); 
	
	
	private PricingService() {
		super();
	}


	public static PricingService getInstance() {
		return instance;
	}

}
