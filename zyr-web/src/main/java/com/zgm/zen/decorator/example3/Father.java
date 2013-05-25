package com.zgm.zen.decorator.example3;

public class Father {

	/*public static void main(String[] args){
		
		SchoolReport sr = new FouthGradeSchoolResport();
		
		sr.report();
		
		sr.sign("老三");
	}*/
	
	public static void main(String[] args){
		
		SchoolReport sr = new FouthGradeSchoolResport();
		
		sr = new HighScoreDecorator(sr);
		
		sr = new SortDecorator(sr);
		
		sr.report();
		
		sr.sign("老三");
	}
}
