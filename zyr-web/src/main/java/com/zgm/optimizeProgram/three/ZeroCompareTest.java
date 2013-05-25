package com.zgm.optimizeProgram.three;

public class ZeroCompareTest {

	public static void main(String[] args){
		long startIndex, endIndex;
		int[] a = new int[2500000];
		
		startIndex = System.currentTimeMillis();
		
		for(int i = 0; i < a.length; i++){
			a[i] += i; 
		}
		
		endIndex = System.currentTimeMillis();
		System.out.println(endIndex - startIndex);
		
		
		int[] b = new int[10000000];
		
		startIndex = System.currentTimeMillis();
		
		for(int i = b.length; i <= 0; i--){
			b[i] += i;
		}
		
		endIndex = System.currentTimeMillis();
		System.out.println(endIndex - startIndex);
	}
}
