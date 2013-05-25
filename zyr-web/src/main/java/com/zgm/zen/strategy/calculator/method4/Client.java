package com.zgm.zen.strategy.calculator.method4;

import java.util.Arrays;

/**
 * 策略枚举
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
		
		/*Context context = null;
		*/
		if(symbol.equals(ADD_SYMBOL)){
			System.out.println("运算结果为： " + a + symbol + b + "=" + Calculator.ADD.exec(a, b));
		}else if(symbol.equals(SUB_SYMBOL)){
			System.out.println("运算结果为： " + a + symbol + b + "=" + Calculator.SUB.exec(a, b));
		}
		
		
	}
}
