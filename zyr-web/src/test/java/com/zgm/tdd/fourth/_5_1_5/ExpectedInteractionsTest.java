
package com.zgm.tdd.fourth._5_1_5;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * 交互验证
 * @author zgm
 *
 */
public class ExpectedInteractionsTest {

	private List<Customer> delivered;
	
	@Before
	public void setup() {
		delivered = new ArrayList<Customer>();
	}
	
	private class MockCustomer extends Customer {
		@Override
		public void onPaperDelivery(DailyPaper paper) {
			delivered.add(this);
		}
	}
	
	
	@Test
	public void paperBoyShouldDeliverPapers() throws Exception {
		Customer david = new MockCustomer();
		Customer esther = new MockCustomer();
		
		PaperBoy paperBoy = new PaperBoy();
		paperBoy.addToRoute(david);
		paperBoy.addToRoute(esther);
		
		paperBoy.deliver(new DailyPaper());
		
		assertTrue(delivered.contains(david));
		assertTrue(delivered.contains(esther));
	}
	
	
}
