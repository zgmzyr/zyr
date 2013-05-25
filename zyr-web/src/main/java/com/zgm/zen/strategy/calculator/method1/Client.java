package com.zgm.zen.strategy.calculator.method1;

import java.util.Arrays;

public class Client {

	public static void main(String[] args){
		
		int a = Integer.parseInt(args[0]);
		String symbol = args[1];
		int b = Integer.parseInt(args[2]);
		
		System.out.println("输入的参数为： " + Arrays.toString(args));
		
		Calculator cal = new Calculator();
		System.out.println("运算结果为： " + a + symbol + b + "=" + cal.exec(a, b, symbol));
	}
}
