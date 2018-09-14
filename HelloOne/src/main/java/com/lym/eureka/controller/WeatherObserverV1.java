package com.lym.eureka.controller;

public class WeatherObserverV1 implements MyObserver{
	
	private float temp;
	private float humidity;
	private Subject weatherData;
	
	public WeatherObserverV1(Subject weatherData) {
		// TODO Auto-generated constructor stub
		this.weatherData=weatherData;
		weatherData.registerObserver(this);
	}


	public void display() {
		System.out.println("Current conditions:" + temp+"F degrees and "+humidity+"%humidity");
		
	}

	@Override
	public void update(String message) {
		
	}

	@Override
	public void updateV2(float temp, float humidity, float pressure) {
		// TODO Auto-generated method stub
		this.temp=temp; 
		this.humidity=humidity;
		display();
	}
	
}
