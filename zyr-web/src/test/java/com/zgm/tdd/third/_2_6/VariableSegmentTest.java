package com.zgm.tdd.third._2_6;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

import org.junit.Test;

public class VariableSegmentTest {

	@Test
	public void variableEvaluatesToItsValue() throws Exception {
		String name = "myWar";
		String value = "myValue";
		Map<String, String> variables = new HashMap<String, String>();
		variables.put(name, value);
		
		assertEquals(value, new VariableSegment(name).evaluate(variables));
	}
}
