package com.zgm.tdd.second._2_2.first;

import org.junit.Assert;
import org.junit.Test;


public class TemplateTest {
	
	@Test
	public void oneVariable() throws Exception {
		Template template = new Template("Hello, ${name");
		template.set("name", "Reader");
		Assert.assertEquals("Hello, Reader", template.evaluate());
	}
	
	@Test
	public void differentValue() throws Exception {
		Template template = new Template("Hello, ${name");
		template.set("name", "zgm");
		Assert.assertEquals("Hello, zgm", template.evaluate());
	}
}
