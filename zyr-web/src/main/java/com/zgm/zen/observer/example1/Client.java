package com.zgm.zen.observer.example1;

public class Client {

	public static void main(String[] args) throws Exception{
		
		LiSi lisi = new LiSi();
		HanFeizi hanFeizi = new HanFeizi();
		
		Spy watchBreakfast = new Spy(hanFeizi, lisi, "breakfast");
		watchBreakfast.start();
		
		Thread.sleep(1000);
		
		Spy watchFun = new Spy(hanFeizi, lisi, "fun");
		watchFun.start();
		
		Thread.sleep(1000);
		
		hanFeizi.haveFun();
	}
}
