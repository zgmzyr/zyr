package com.zgm.tdd.third._2_6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//

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
			Assert.assertEquals("No value for foo", excepted.getMessage());
			
			System.out.println(excepted.getMessage());
		}
		
	}
	
	@Test(expected = MissingValueException.class)
	public void testMissValueException() throws Exception {
		new Template("${foo}").evaluate();
	}
	
	//会失败的测试
	@Test
	public void variablesGetProcessedJustOnce() {
		template.set( "one", "${one}" );
		template.set( "two", "${two}" );
		template.set( "three", "${three}" );
		template.evaluate();
	}
}
