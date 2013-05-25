package com.zgm.zen.interpreter.common;

import java.util.Stack;

public class Client  {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		Context ctx = new Context();
		
		Stack<Expression> stack = null;
		
		/*for(;;){
			//进行语法判断，并产生递归调用
		}*/
		
		//产生一个鵍听语法树，由各个具体的施法分析进行解析
		Expression exp = stack.pop();
		
		exp.interpreter(ctx);
	}

}
