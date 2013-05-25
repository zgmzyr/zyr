package com.zgm.tdd.third._2_6;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

import org.junit.Test;

public class PlainTextSegmentTest {

	@Test
	public void plainTextEvaluatesAsIs() throws Exception {
		Map<String, String> variables = new HashMap<String, String>();
		String text = "abc def";
		
		assertEquals(text, new PlainText(text).evaluate(variables));
	}
}
