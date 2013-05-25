package com.zgm.tdd.second._2_3;

import org.junit.Assert;
import org.junit.Test;
//广度优先，深度优先

public class TemplateTest {
	
	@Test
	public void oneVariable() throws Exception {
		Template template = new Template("Hello, ${name}");
		template.set("name", "Reader");
		Assert.assertEquals("Hello, Reader", template.evaluate());
	}
	
	@Test
	public void differentValue() throws Exception {
		Template template = new Template("Hello, ${name}");
		template.set("name", "zgm");
		Assert.assertEquals("Hello, zgm", template.evaluate());
	}
	
	@Test
	public void multipleVariables() throws Exception {
		Template template = new Template("${one}, ${two}, ${three}");
		
		template.set("one", "1");
		template.set("two", "2");
		template.set("three", "3");
		
		Assert.assertEquals("1, 2, 3", template.evaluate());
	}
	
	@Test
	public void unknowVariablesAreIngnored() throws Exception {
		Template template = new Template("Hello, ${name}");
		template.set("name", "Reader");
		template.set("doesnotexist", "Hi");
		
		Assert.assertEquals("Hello, Reader", template.evaluate());
	}
	
}
