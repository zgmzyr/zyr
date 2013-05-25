package com.zgm.tdd.second._2_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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

	/*public void set(String variable, String value) {
		this.value = value;
	}*/

	public String evaluate() {
		String result = this.templateText;
		
		for (Entry<String, String> entry : variables.entrySet()) {
			String regex = "\\$\\{" + entry.getKey() + "\\}";
			result = result.replaceAll(regex, entry.getValue());
		}
		
		if (result.matches(".*\\$\\{.+\\}.*")) {
			throw new MissingValueException();
		}
		
		return result;
	}
	
	/*public String evaluate() {
		return templateText.replaceAll("\\$\\{name\\}", value);
//		return "Hello, " + this.value;
	}*/

}
