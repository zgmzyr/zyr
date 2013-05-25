package com.zgm.tdd.second._2_4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//别忘了重构

public class TemplateTest {
	Template template;
	
	@Before
	public void setUp() throws Exception {
		template = new Template("${one}, ${two}, ${three}");
		
		template.set("one", "1");
		template.set("two", "2");
		template.set("three", "3");
	}
	
	/*@Test
	public void oneVariable() throws Exception {
		Template template = new Template("Hello, ${name}");
		template.set("name", "Reader");
		Assert.assertEquals("Hello, Reader", template.evaluate());
	}*/
	
	/*@Test
	public void differentValue() throws Exception {
		Template template = new Template("Hello, ${name}");
		template.set("name", "zgm");
		Assert.assertEquals("Hello, zgm", template.evaluate());
	}*/
	
	@Test
	public void multipleVariables() throws Exception {
		
		Assert.assertEquals("1, 2, 3", template.evaluate());
	}
	
	@Test
	public void unknowVariablesAreIngnored() throws Exception {
		
		template.set("doesNotExist", "whatever");
		
		Assert.assertEquals("1, 2, 3", template.evaluate());
	}
	
	
	
}
