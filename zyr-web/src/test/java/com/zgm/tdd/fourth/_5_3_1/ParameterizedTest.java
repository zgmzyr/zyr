package com.zgm.tdd.fourth._5_3_1;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 测试模式： 
 * 1. 参数化测试
 * @author zgm
 *
 */

@RunWith(Parameterized.class)
public class ParameterizedTest {
//	public int expected, input1, input2;
	private int expected, input1, input2;
	
	@Parameters
//	private static Collection<Object[]> parameters() {
	public static Collection<Object[]> parameters() {  //必须为public
		Object[][] data = new Object[][] {
				{0, 0, 0}, {1, 1, 0},
				{2, 1, 1}, {3, 2, 1},
				{4, 3, 1}, {5, 5, 0},
				{6, 8, -2}
		
		};
			
		return Arrays.asList(data);
	}
	
	public ParameterizedTest(int expected, int input1, int input2) {
		this.expected = expected;
		this.input1 = input1;
		this.input2 = input2;
	}
	
	@Test
	public void executeParameterizedTest() throws Exception {
		System.out.println(expected + " = " + input1 + " + " + input2 );
		org.junit.Assert.assertEquals(expected, new Calculator().add(input1, input2));
	}
}
