package com.zgm.zen.interpreter.example1;

import java.util.HashMap;

public class AddExpression extends SymbolExpression {

	public AddExpression(Expression left, Expression right) {
		super(left, right);
	}

	public int interpreter(HashMap<String, Integer> var){
		return super.left.interpreter(var) + super.right.interpreter(var);
	}
	
	
}
