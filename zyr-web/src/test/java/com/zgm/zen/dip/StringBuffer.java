package com.zgm.zen.dip;

public class StringBuffer {
	public static void main(String [] args){
	String s1="hello";
	String s2="world";
	java.lang.StringBuffer s3= new java.lang.StringBuffer(s1);
	s3.append(s2);
	System.out.println(s1);
	System.out.println(s2);
	System.out.println(s3);
	}
	
}
