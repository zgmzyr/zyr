package com.zgm.zen.responsibilityChain.example1;

public class Father implements IHandler {

	@Override
	public void handleMessage(IWomen women) {

		System.out.println("女儿的请示是： " + women.getRequest());
		System.out.println("父亲的回答是： 同意");
		
	}

}
