package com.zgm.zen.interpreter.common;

import java.util.HashMap;


/**
 * 非终结符表达式
 * @author Administrator
 *
 */
public class NonterminalExpression extends Expression {

	//每个非终结符表达式都会对其他表达式依赖
	public NonterminalExpression(Expression... expressions){
		
	}
	
	@Override
	public Object interpreter(Context ctx) {
		//进行文法处理
		return null;
	}

}
