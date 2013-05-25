package com.zgm.tdd.third._2_3;

import java.util.HashMap;
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
		String result = replaceVariables();
		checkForMissingValues(result);
		
		return result;
	}
	
	public String replaceVariables() {
		String result = this.templateText;
		
		for (Entry<String, String> entry : variables.entrySet()) {
			String regex = "\\$\\{" + entry.getKey() + "\\}";
			result = result.replaceAll(regex, entry.getValue());
		}
		
		return result;
	}
	
	public void checkForMissingValues(String result) {
		Matcher matcher = Pattern.compile(".*\\$\\{.+\\}.*").matcher(result);
		
		if (matcher.find()) {
			throw new MissingValueException("变量" + matcher.group() + "没有设置值");
		}
		/*if (result.matches(".*\\$\\{.+\\}.*")) {
			throw new MissingValueException();
		}*/
	}
	
	/*public String evaluate() {
		return templateText.replaceAll("\\$\\{name\\}", value);
//		return "Hello, " + this.value;
	}*/

}
