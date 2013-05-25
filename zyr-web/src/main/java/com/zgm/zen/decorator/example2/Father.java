package com.zgm.zen.decorator.example2;

public class Father {

	public static void main(String[] args){
		
		SchoolReport sr = new FouthGradeSchoolResport();
		
		sr.report();
		
		sr.sign("老三");
	}
}
