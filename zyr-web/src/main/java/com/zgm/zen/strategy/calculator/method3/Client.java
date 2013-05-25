package com.zgm.zen.strategy.calculator.method3;

import java.util.Arrays;

/**
 * 策略模式
 * @author Administrator
 *
 */
public class Client {

	private static final String ADD_SYMBOL = "+";
	
	private final static String SUB_SYMBOL = "-";
	
	public static void main(String[] args){
		
		int a = Integer.parseInt(args[0]);
		String symbol = args[1];
		int b = Integer.parseInt(args[2]);
		
		System.out.println("输入的参数为： " + Arrays.toString(args));
		
		Context context = null;
		
		if(symbol.equals(ADD_SYMBOL)){
			context = new Context(new Add());
		}else if(symbol.equals(SUB_SYMBOL)){
			context = new Context(new Sub());
		}
		
		System.out.println("运算结果为： " + a + symbol + b + "=" + context.exec(a, b, symbol));
	}
}
