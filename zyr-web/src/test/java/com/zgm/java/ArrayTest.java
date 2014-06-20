package com.zgm.java;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

/**
 * @author zhouguangming
 * 创建时间: 2014年6月4日 下午3:24:25
 */
public class ArrayTest {

	
	@Test
	public void test() {
		int[] array = new int[3];
		System.out.println(array.toString());
		System.out.println(array.toString());
		
		
		int[] array2 = {1, 2, 3};
		System.out.println(array2);
		//打印集合中的元素，达不到效果
		System.out.println(new ArrayList(Arrays.asList(array2)));
	}
}
