package com.zgm.zen.strategy.calculator.method3;

public class Context {

	private Calculator cal = null;
	
	public Context(Calculator cal){
		this.cal = cal;
	}
	
	public int exec(int a, int b, String symbol){
		return cal.exec(a, b);
	}
	
	
}
