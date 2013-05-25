package com.zgm.zen.responsibilityChain.example2;

//public class Father implements IHandler {
public class Father extends Handler {

	
	public Father() {
		super(Handler.FATHER_LEVEL_REQUEST);
	}

	@Override
	protected void response(IWomen women) {

		System.out.println("--------女儿向父亲请示-------");
		
		System.out.println("女儿的请示是： " + women.getRequest());
		System.out.println("父亲的回答是： 同意");
	}

	/*@Override
	public void handleMessage(IWomen women) {

		System.out.println("女儿的请示是： " + women.getRequest());
		System.out.println("父亲的回答是： 同意");
		
	}*/
	
	

}
