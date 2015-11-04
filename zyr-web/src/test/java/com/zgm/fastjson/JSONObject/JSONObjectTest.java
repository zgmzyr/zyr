package com.zgm.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class JSONObjectTest {

	@Test
	public void test() {
		System.out.println(JSON.toJSONString("zyr"));
		Map<String, String> map1 = new HashMap<>();
		map1.put("name", "zyr");
		map1.put("age", "18");
		System.out.println(JSON.toJSONString(map1));

	}
}
