package com.zgm.java.util.concurrent.atomic;

import static org.junit.Assert.*;

import java.util.concurrent.atomic.AtomicLong;

import org.junit.Test;

/**
 * @author zhouguangming
 * 创建时间: 2014年4月14日 下午2:44:02
 */
public class AtomicLongTest {

	
	@Test
	public void test() {
		AtomicLong atomicLong = new AtomicLong(Long.MAX_VALUE);
		long a = atomicLong.addAndGet(2);
		assertTrue("", a == 0);
	}
}
