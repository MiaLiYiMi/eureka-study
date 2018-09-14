package com.lym.eureka.util;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class WeiXinTest {

	private String url = "https://192.168.1.101/";

	private String weixinUrl = "https://api.weixin.qq.com/sns/jscode2session?appid={0}&secret={1}&js_code={2}&grant_type=authorization_code";
	// "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

	public void test() {
		HttpClientUtil httpClientUtil = new HttpClientUtil();
		String httpOrgCreateTest = url + "httpOrg/create";
		Map<String, String> createMap = new HashMap<String, String>();
		createMap.put("authuser", "*****");
		createMap.put("authpass", "*****");
		createMap.put("orgkey", "****");
		createMap.put("orgname", "****");
		String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest, createMap);
		System.out.println("result:" + httpOrgCreateTestRtn);
	}

	public void weixin() {
		HttpClientUtil httpClientUtil = new HttpClientUtil();
		String appId = "wx755d804ffcd7f745";
		String secret = "d18a37bfc67feadb1ac4f96be7a33d96";

		String jsCode = "sasdfsdvwe123";
		String url = MessageFormat.format(weixinUrl, appId, secret, jsCode);
		System.out.println("---------------request="+url);
		String result = httpClientUtil.doGet(url);
		
		
		JSONObject resultObj =JSON.parseObject(result);
		if(resultObj.get("code").equals("0")) {
			if(resultObj.get("data").toString().contains("openid")) {
				
			}else {
				System.out.println(result);
			}
			
		}
		
	}

	public static void main(String[] args) {
		WeiXinTest main = new WeiXinTest();
		main.weixin();
	}

}
