package com.zgm.zen.adapter.example2;

import java.util.HashMap;
import java.util.Map;

public class OuterUserOfficeInfo implements IOuterUserOfficeInfo {

	@Override
	public Map getUserOfficeInfo(){
		HashMap officeInfo = new HashMap();
		officeInfo.put("jobPosition", "老板");
		officeInfo.put("officeTelNumber", "2234324");
		
		return officeInfo;
	}

}
