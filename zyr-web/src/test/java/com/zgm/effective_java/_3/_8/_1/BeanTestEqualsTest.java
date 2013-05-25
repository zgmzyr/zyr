package com.zgm.effective_java._3._8._1;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class BeanTestEqualsTest {

	
	@Test
	public void testEquals() {
		List<BeanTestEquals> list1 = new ArrayList<BeanTestEquals>();
		List<BeanTestEquals> list2 = new ArrayList<BeanTestEquals>();
		/*list1.add(new BeanTestEquals(1, 1.23f, 1.23d, "zgm" ));
		list1.add(new BeanTestEquals(2, 4.56f, 4.56d, "zyr" ));
		list1.add(new BeanTestEquals(3, 1.23f, 1.23d, "zgmzyr" ));*/
		list1.add(new BeanTestEquals(3, 1.23f, 1.23d, null ));
//		list1.add(new BeanTestEquals(3, Float.NaN, 1.23d, null ));
		list1.add(new BeanTestEquals(3, -0.0f, 1.23d, null ));
		
		
		/*list2.add(new BeanTestEquals(1, 1.23f, 1.23d, "zgm" ));
		list2.add(new BeanTestEquals(2, 4.56f, 4.56d, "zyr" ));
		list2.add(new BeanTestEquals(3, 1.23f, 1.23d, "zgmzyr" ));*/
		list2.add(new BeanTestEquals(3, 1.23f, 1.23d, null ));
//		list2.add(new BeanTestEquals(3, Float.NaN, 1.23d, null ));
		list2.add(new BeanTestEquals(3, -0.0f, 1.23d, null ));
		
		
		assertEquals(list1, list2);
		
	}
	
}
