package com.zgm.zen.flyweight.example2;

import com.zgm.zen.flyweight.example3_extends.ExtrinsicState;

public class Client2 {

	public static void main(String[] args) {

		/*ExtrinsicState state1 = new ExtrinsicState();
		state1.setSubject("科目1 ");
		state1.setLocation("上海");
		
		ExtrinsicState state2 = new ExtrinsicState();
		state1.setSubject("科目2 ");
		state1.setLocation("上海");
		*/
		
		String key1 = "科目1上海";
		String key2 = "科目1上海";
		
		SignInfoFactory.getSignInfo(key1);
		
		long currentTime = System.currentTimeMillis();
		for(int i = 0; i < 10000000; i++){
			SignInfoFactory.getSignInfo(key2);
			
		}
		
		long tailTime = System.currentTimeMillis();
		
		System.out.println("执行时间： " + (tailTime - currentTime) + "ms");
	}
}
