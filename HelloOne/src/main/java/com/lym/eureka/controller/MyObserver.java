package com.lym.eureka.controller;

public interface MyObserver {
	//所有观察者都必须实update方法，以实现观察者接口
	public void update(String message);
	public void updateV2(float temp,float humidity,float pressure);
}
