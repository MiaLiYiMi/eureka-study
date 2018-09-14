package com.lym.eureka.controller;

public class test {

	public static void main(String[] args) {
//		ConcreteSubject sub = new ConcreteSubject();
//
//		MyObserver userZhang = new ConcreteObserver("ZhangSan");
//		MyObserver userLi = new ConcreteObserver("LiSi");
//		MyObserver userWang = new ConcreteObserver("WangWu");
//
//		sub.registerObserver(userZhang);
//		sub.registerObserver(userLi);
//		sub.registerObserver(userWang);
//		sub.setInfomation("PHP是世界上最好用的语言！");
//		sub.removeObserver(userZhang);
//		
//		System.out.println("----------------------------------------------");
//		sub.setInfomation("JAVA是世界上最好用的语言！");
//		sub.removeObserver(userLi);
//		sub.removeObserver(userWang);
//		
//		System.out.println("----------------------------------------------");
//		sub.setInfomation("Python是世界上最好用的语言！");
//		
//		System.out.println("------Version 1------------------------------------");
//		WeatherDataSubjectV1 weatherSubV1=new WeatherDataSubjectV1();
//		MyObserver weatherObs=new WeatherObserverV1(weatherSubV1);
//		
//		weatherSubV1.setMeasurements(80, 75, 30.4f);
//		System.out.println("温度发生了变化>>>>>");
//		weatherSubV1.setMeasurements(81, 75, 30.4f);
//		System.out.println("湿度发生了变化>>>>>");
//		weatherSubV1.setMeasurements(81, 77, 30.6f);
		
		System.out.println("------Version 2-------------------------------------");
		WeatherDataSubjectV2 weatherSubV2=new WeatherDataSubjectV2();
		WeatherObserverV2 weatherObsV2=new WeatherObserverV2(weatherSubV2);
		weatherSubV2.setMeasurements(80, 75, 30.4f);
		System.out.println("温度发生了变化>>>>>");
		weatherSubV2.setMeasurements(81, 75, 30.4f);
		System.out.println("湿度发生了变化>>>>>");
		weatherSubV2.setMeasurements(81, 77, 30.6f);
		
		
	}
}
