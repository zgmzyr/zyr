package com.zgm.tdd.fourth._3_3;

import org.junit.Test;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.zgm.tdd.fourth._3_1.Customer;
import com.zgm.tdd.fourth._3_1.OrderProcessor;
import com.zgm.tdd.fourth._3_1.PriceServiceTestDouble;
import com.zgm.tdd.fourth._3_1.PricingService;
import com.zgm.tdd.fourth._3_1.Product;
import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;

public class OrderProcessEasymockTest {

	@Test
	public void testOrderProcesorWithEasyMock() throws Exception {
		float initialBalance = 100.0f;
		float listPrice = 30.0f;
		float discount = 10.0f;
		float expectedBalance = (initialBalance - (listPrice * (1 - discount / 100)));
		
		Customer customer = new Customer(initialBalance);
		Product product = new Product("TDD in Action", listPrice);
		
		PricingService mock = createMock(PricingService.class);
		expect(mock.getDiscountPercentage(customer, product))
			.addReturn(discount);
		replay(mock);
		
		//act
		OrderProcessor processor = new OrderProcessor();
		processor.setPricingService(mock);
		processor.process(new Order(customer, product));
		
		//assert
		assertEquals(String.valueOf(expectedBalance), customer.getBalance(), 0.001f);
		verify(mock);
	}
}
