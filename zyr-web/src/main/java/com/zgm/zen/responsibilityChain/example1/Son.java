package com.zgm.zen.responsibilityChain.example1;

public class Son implements IHandler {

	@Override
	public void handleMessage(IWomen women) {

		System.out.println("母亲的请示是： " + women.getRequest());
		System.out.println("儿子的回答是： 同意");
		
	}

}
