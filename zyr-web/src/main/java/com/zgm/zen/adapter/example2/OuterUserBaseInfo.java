package com.zgm.zen.adapter.example2;

import java.util.HashMap;
import java.util.Map;

public class OuterUserBaseInfo implements IOuterUserBaseInfo {

	@Override
	public Map getUserBaseInfo() {
		HashMap baseInfoMap = new HashMap();
		baseInfoMap.put("userName", "张三");
		baseInfoMap.put("mobileNumber", "13333222");
		
		return baseInfoMap;
	}

}
