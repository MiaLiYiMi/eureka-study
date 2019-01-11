package com.lym.eureka;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.lym.eureka.entity.User;

public class JsonTest {

	public static void main(String[] args) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("userName", "uuu");
		paramMap.put("eBankType", "lll");
		String json=JSONObject.toJSONString(paramMap);
		System.out.println(json);
		
		User user=JSONObject.parseObject(json, User.class);
		System.err.println(user.geteBankType());
	}

}
