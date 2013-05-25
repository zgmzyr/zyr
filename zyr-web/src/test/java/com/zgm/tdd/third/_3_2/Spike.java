package com.zgm.tdd.third._3_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;


import static org.junit.Assert.*;

public class Spike {

	@Test
	public void testFindStartAndEnd(){
		String srcString = "zgm is zyr, zyr also is zgm ";
		String regex = "(zyr)";
		
		Matcher matcher = Pattern.compile(regex).matcher(srcString);
		
		assertTrue(matcher.find());
		assertEquals("第一个匹配结果的第一个字符的索引错了", 7, matcher.start());
		assertEquals("第一个匹配结果的最后一个字符的索引错了", 9, matcher.end() - 1);
		
		assertTrue(matcher.find());
		assertEquals("第二个匹配结果的第一个字符的索引错了", 12, matcher.start());
		assertEquals("第二个匹配结果的最后一个字符的索引错了", 14, matcher.end() - 1);
		
		assertFalse("还有更多的匹配结果", matcher.find());
	}
}
