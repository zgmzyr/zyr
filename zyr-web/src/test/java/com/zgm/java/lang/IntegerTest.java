package com.zgm.java.lang;

import org.junit.Test;

/**
 * @author zhouguangming
 * 创建时间: 2014年4月25日 下午2:46:48
 */
public class IntegerTest {

	@Test
	public void test() {
		Integer aa = new Integer (1);
    	Integer aa2 = new Integer (1);
    	System.out.println(aa + aa2);
        System.out.println( aa == aa2 );
        
    	Integer one1 = 1;
    	Integer one2 = 1;
        System.out.println( one1 == one2 );
        
        Integer one3 = new Integer (1);
        System.out.println( one1 == one3 );
	}
}
