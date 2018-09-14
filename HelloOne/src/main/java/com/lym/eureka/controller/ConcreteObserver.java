package com.lym.eureka.controller;

public class ConcreteObserver implements MyObserver {

	private String name;
	private String message;
	
	public ConcreteObserver(String name) {
		this.name = name;
	}

	@Override
	public void update(String message) {
		this.message = message;
		display();
	}
	

	public void display() {
		System.out.println(name + " 收到推送消息： " + message);
	}

	@Override
	public void updateV2(float temp, float humidity, float pressure) {
	}
}
