package com.lym.eureka;

import java.util.UUID;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilTest {
	
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	public static void main(String[] args) {
		UtilTest utilTest=new UtilTest();
		utilTest.compare();
//		utilTest.regexMobile("");
//		utilTest.getRandomUUID();
	}
	
	public void getRandomUUID() {
		UUID uuid=UUID.randomUUID();
		System.out.println(uuid);
	}

	public void regexMobile(String mobile) {
		//手机正则匹配
		String REGEX_MOBILE = "^[1][3-9][0-9]{9}$";
		System.out.println(Pattern.matches(REGEX_MOBILE, mobile));
				
	}
	
	public void compare() {
		Integer a=5;
		Integer b=5;
		Integer c=new Integer(5);
		System.out.println(a.equals(a));
		System.out.println(a.equals(b));
		System.out.println(c.equals(a));
		System.out.println(a==c);
		String aa="yeah";
		String cc="yeah";
		String bb=new String(new StringBuffer("yeah"));
		System.out.println(aa.equals(bb));
		System.out.println(aa==bb);
		System.out.println(aa.equals(cc));
		System.out.println(aa==cc);
	}
	

}
