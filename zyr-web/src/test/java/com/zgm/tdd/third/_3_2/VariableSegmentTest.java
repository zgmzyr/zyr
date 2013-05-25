package com.zgm.tdd.third._3_2;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VariableSegmentTest {

	private Map<String, String> variables;
	
	@Before
	public void setUp() {
		this.variables = new HashMap<String, String>();
	}
	
	@Test
	public void variableEvaluatesToItsValue() throws Exception {
		String name = "myWar";
		String value = "myValue";
		Map<String, String> variables = new HashMap<String, String>();
		variables.put(name, value);
		
		assertEquals(value, new VariableSegment(name).evaluate(variables));
	}
	
	@Test
	public void missingVariableRaisesException() throws Exception {
		String name = "myVar";
		try {
			new VariableSegment(name).evaluate(variables);
			fail("Missing variable value should raise an exception");
		} catch (MissingValueException expected) {
			assertEquals("No value for ${" + name + "}", expected.getMessage());
		}
		
	}
}
