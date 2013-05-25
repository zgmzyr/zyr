package com.zgm.zen.adapter.example1;

import java.util.HashMap;
import java.util.Map;

public class OuterUser implements IOuterUser {

	@Override
	public Map getUserBaseInfo() {
		HashMap baseInfoMap = new HashMap();
		baseInfoMap.put("userName", "张三");
		baseInfoMap.put("mobileNumber", "13333222");
		
		return baseInfoMap;
	}

	@Override
	public Map getUserHomeInfo() {
		HashMap homeInfo = new HashMap();
		homeInfo.put("homeTelNumber", "1223344");
		homeInfo.put("homeAddress", "北京朝阳门");
		
		return homeInfo;
	}
	
	public Map getUserOfficeInfo(){
		HashMap officeInfo = new HashMap();
		officeInfo.put("jobPosition", "老板");
		officeInfo.put("officeTelNumber", "2234324");
		
		return officeInfo;
	}

}
