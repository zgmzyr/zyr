package com.zgm.zen.strategy.calculator.method2;

/*public class Calculator {

	private final static String ADD_SYMBOL = "+";
	
	private final static String SUB_SYMBOL = "-";
	
	public int exec(int a, int b, String symbol){
		int result = 0;
		
		if(symbol.equals(ADD_SYMBOL)){
			result = this.add(a, b);
		}else if(symbol.equals(SUB_SYMBOL)){
			result = this.sub(a, b);
		}
		
		return result;
	}
	
	private int add(int a, int b){
		return a + b;
	}
	
	private int sub(int a, int b){
		return a - b;
	}
}*/

public class Calculator {

	private final static String ADD_SYMBOL = "+";
	
	private final static String SUB_SYMBOL = "-";
	
	public int exec(int a, int b, String symbol){
		return symbol.equals(ADD_SYMBOL) ? a + b : a - b;
	}
	
	
}
