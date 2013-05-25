package com.zgm.tdd.fourth._3_1;

import org.junit.Test;
import static org.junit.Assert.*;

public class OrderProcessorTest {

	@Test
	public void testOrderProcessoWithMockObject() throws Exception {
		float initialBalance = 100.0f;
		float listPrice = 30.0f;
		float discount = 10.0f;
		float expectedBalance = (initialBalance - (listPrice * (1 - discount / 100)));
		
		Customer customer = new Customer(initialBalance);
		Product product = new Product("TDD in Action", listPrice);
		OrderProcessor processor = new OrderProcessor();
		PricingService service = new PriceServiceTestDouble(discount);
		processor.setPricingService(service);
		
		processor.process(new Order(customer, product));
		
		assertEquals(String.valueOf(expectedBalance), customer.getBalance(), 0.001f);
	}
}
