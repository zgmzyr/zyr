package com.zgm.zen.adapter.example2;

import java.util.HashMap;
import java.util.Map;

public class OuterUserHomeInfo implements IOuterUserHomeInfo {

	@Override
	public Map getUserHomeInfo() {
		HashMap homeInfo = new HashMap();
		homeInfo.put("homeTelNumber", "1223344");
		homeInfo.put("homeAddress", "北京朝阳门");
		
		return homeInfo;
	}

}
