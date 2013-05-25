package com.zgm.zen.flyweight.example3_extends;

import java.util.HashMap;

public class SignInfoFactory {

	private static HashMap<ExtrinsicState, SignInfo> pool = new HashMap<ExtrinsicState, SignInfo>();
	
	public static SignInfo getSignInfo(ExtrinsicState key){
		
		SignInfo result = null;
		
		if(!pool.containsKey(key)){
//			System.out.println(key + "------建立对象，并放置到池中");
			result = new SignInfo();
			pool.put(key, result);
		}else{
			result = pool.get(key);
//			System.out.println(key + "-----直接从池中取得");
		}
		
		
		return result;
	}
}
