package com.zgm.zen.interpreter.example1;

import java.util.HashMap;

public class VarExpression extends Expression {

	private String key;
	
	
	public VarExpression(String key) {
		super();
		this.key = key;
	}

	@Override
	public int interpreter(HashMap<String, Integer> var) {

		return var.get(this.key);
	}

}
