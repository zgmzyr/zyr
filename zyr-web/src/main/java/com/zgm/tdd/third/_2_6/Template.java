package com.zgm.tdd.third._2_6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Template {
//	private String value;
	private Map<String, String> variables;
	private String templateText;
	
	public Template(String templateText) {
		this.variables = new HashMap<String, String>();
		this.templateText = templateText;
	}
	
	public void set(String name, String value) {
		this.variables.put(name, value);
	}

	
	public String evaluate() {
		/*String result = replaceVariables();
		checkForMissingValues(result);
		
		return result;*/
		/*TemplateParse parse = new TemplateParse();
		List<String> segments = parse.parse(templateText);
		StringBuilder result = new StringBuilder();
		
		for (String segment : segments) {
			this.append(segment, result);
		}
		
		return result.toString();*/
		
		TemplateParse parse = new TemplateParse();
		List<String> segments = parse.parse(templateText);
		
		return this.concatenate(segments);
	}

	private String concatenate(List<String> segments) {
		StringBuilder result = new StringBuilder();
		
		for (String segment : segments) {
			this.append(segment, result);
		}
		
		return result.toString();
	}
	
	private void append(String segment, StringBuilder result) {
		/*if (segment.startsWith("${") && segment.endsWith("}")) {
			String var = segment.substring(2, segment.length() - 1);
			
			if (!variables.containsKey(var)) {
				throw new MissingValueException("No value for " + var);
			}
			
			result.append(variables.get(var));
		} else {
			result.append(segment);
		}*/
		
		if (isVariable(segment)) {
			evaluateVariable(segment, result);
		} else {
			result.append(segment);
		}
		
	}

	private void evaluateVariable(String segment, StringBuilder result) {
		String var = segment.substring(2, segment.length() - 1);
		
		if (!variables.containsKey(var)) {
			throw new MissingValueException("No value for " + var);
		}
		
		result.append(variables.get(var));
	}

	static public  boolean isVariable(String segment) {
		return segment.startsWith("${") && segment.endsWith("}");
	}


}
