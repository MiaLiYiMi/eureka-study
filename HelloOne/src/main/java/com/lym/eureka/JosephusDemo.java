package com.lym.eureka;

import java.util.regex.Pattern;

/**
 * 约瑟夫环问题
 * 递归
 * @author Administrator
 * @date 2018-9-18
 */
public class JosephusDemo {

	public static void main(String[] args) {
		// sum指的是总人数，key指的是每次最大报到的数值，n是第n次，该函数每次可以求出第n次扔海里的人的编号
		int sum=100;
		int key=13;
		for (int i = 1; i < 51; i++) {
			System.out.println(">>>>第"+i+"次");
			System.out.println("淘汰的编号是："+(1+getNumber(sum, key, i)));
			System.out.println();
		}
	}

	public static int getNumber(int sum, int key, int n) {
		if (n == 1) 
			return (sum + key - 1) % sum;
		else
			return (getNumber(sum - 1, key, n - 1) + key) % sum;
	}
	
	

}
