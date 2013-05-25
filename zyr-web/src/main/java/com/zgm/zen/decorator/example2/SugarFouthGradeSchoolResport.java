package com.zgm.zen.decorator.example2;

public class SugarFouthGradeSchoolResport extends FouthGradeSchoolResport {

	private void reportHighScore(){
		System.out.println("这次考试语文最高是75，数学是78，自然是80");
	}
	
	private void reportSort(){
		
		System.out.println("我是排名第38名。。。。");
	}

	
	public void report(){
		this.reportHighScore();
		this.report();
		this.reportSort();
	}
}
