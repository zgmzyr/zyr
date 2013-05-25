package com.zgm.tdd.second._2_5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//��Ӵ�����

public class TemplateTest {
	Template template;
	
	@Before
	public void setUp() throws Exception {
		template = new Template("${one}, ${two}, ${three}");
		
		template.set("one", "1");
		template.set("two", "2");
		template.set("three", "3");
	}
	
	
	@Test
	public void multipleVariables() throws Exception {
		
		Assert.assertEquals("1, 2, 3", template.evaluate());
	}
	
	@Test
	public void unknowVariablesAreIngnored() throws Exception {
		
		template.set("doesNotExist", "whatever");
		
		Assert.assertEquals("1, 2, 3", template.evaluate());
	}
	
	@Test
	public void missingValueRaisesException() throws Exception {
		try{
			new Template("${foo}").evaluate();
			Assert.fail("evalue() should throw an exception if ");
		} catch (MissingValueException excepted) {
			Assert.assertEquals("变量${foo}没有设置值", excepted.getMessage());
			
			System.out.println(excepted.getMessage());
		}
		
//		new Template("${foo}").evaluate();
//		Assert.fail("evalue() should throw an exception if һ���û�б���ֵ");
		
	}
	
	@Test(expected = MissingValueException.class)
	public void testMissValueException() throws Exception {
		new Template("${foo}").evaluate();
	}
	
}
