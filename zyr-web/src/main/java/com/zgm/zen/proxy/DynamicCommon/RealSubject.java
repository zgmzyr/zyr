package com.zgm.zen.proxy.DynamicCommon;

public class RealSubject implements Subject {

	public void doSomething(String str){
		System.out.println("业务处理: " + str);
	}
}
