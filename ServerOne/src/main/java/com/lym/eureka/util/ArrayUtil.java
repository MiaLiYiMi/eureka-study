package com.lym.eureka.util;

import java.util.Arrays;

public class ArrayUtil {

	public static void main(String[] args) {
		String[] str = "a,b,c,d,e,f,g,h,j,k".split(",");
		String[] ss = new String[str.length-1];
		System.arraycopy(str, 1, ss, 0, ss.length);
		System.out.println(Arrays.toString(ss));
	}

}
