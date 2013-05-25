package com.zgm.tdd.third._2_6;

import java.util.Map;

public interface Segment {

	void appendTo(StringBuilder result, Map<String, String> variables);
	
	String evaluate(Map<String, String> variable);

}
