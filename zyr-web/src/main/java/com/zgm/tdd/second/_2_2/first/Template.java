package com.zgm.tdd.second._2_2.first;

public class Template {
	private String value;
	public Template(String templateText) {
	}

	public void set(String variable, String value) {
		this.value = value;
	}

	public String evaluate() {
		return "Hello, " + this.value;
	}

}
