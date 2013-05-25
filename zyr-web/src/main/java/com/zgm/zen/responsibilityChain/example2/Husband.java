package com.zgm.zen.responsibilityChain.example2;

//public class Husband implements IHandler {
public class Husband extends Handler {

	public Husband(){
		super(Handler.HUSBAND_LEVEL_REQUEST);
	}
	@Override
	protected void response(IWomen women) {
		System.out.println("--------------妻子向丈夫请示-------- ");
		
		System.out.println("妻子的请示是： " + women.getRequest());
		System.out.println("丈夫的回答是： 同意");		
	}

	/*@Override
	public void handleMessage(IWomen women) {

		System.out.println("妻子的请示是： " + women.getRequest());
		System.out.println("丈夫的回答是： 同意");
		
	}*/

}
