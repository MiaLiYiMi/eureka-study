package com.lym.eureka.controller;
import java.util.Observable;
import java.util.Observer;

public class WeatherObserverV2 implements Observer{
	
	private float temp;
	private float humidity;
	private Observable observable;
	
	public WeatherObserverV2(Observable observable) {
		this.observable=observable;
		observable.addObserver(this);
	}

	public void display() {
		System.out.println("Current conditions:" + temp+"F degrees and "+humidity+"%humidity");
	}

	/*
	 * 在update()方法中,先确定观察者属于WeatherDataSubjectV2类型，然后利用getter方法取值
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherDataSubjectV2) {
			WeatherDataSubjectV2 v2=(WeatherDataSubjectV2) obs;
			this.temp=v2.getTemp(); 
			this.humidity=v2.getHumidity();
			display();
		}
	}
	
}
