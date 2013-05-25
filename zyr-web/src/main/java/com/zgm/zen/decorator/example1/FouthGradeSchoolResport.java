package com.zgm.zen.decorator.example1;

public class FouthGradeSchoolResport extends SchoolReport {

	@Override
	public void report() {
		
		System.out.println("尊敬的xxx家长： ");
		System.out.println("....");
		System.out.println("---语文62  ---数学22 体育99 自然44");
		System.out.println("..........");
		System.out.println("...............家长签名：  ");
	}

	@Override
	public void sign() {
		
	}

}
