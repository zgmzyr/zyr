package com.zgm.eclipse;

public class ErrorTest {
	public static int test = 0;
	
	public static void main(String[] args){
		
//		System.out.println( 10 / 0);
		
		System.out.println(factorial(6));
	}
	
	public static int factorial(int value){
		test++;
		if(0 == value){
			return value;
		}else{
			return value * factorial(value - 1);
		}
	}
}
