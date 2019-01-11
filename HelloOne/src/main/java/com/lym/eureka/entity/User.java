package com.lym.eureka.entity;

public class User {
	private String userName;
	private String sex;
	private Integer age;
	private String eBankType;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String geteBankType() {
		return eBankType;
	}
	public void seteBankType(String eBankType) {
		this.eBankType = eBankType;
	}
	
}
