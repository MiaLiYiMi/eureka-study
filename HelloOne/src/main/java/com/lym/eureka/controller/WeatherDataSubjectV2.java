package com.lym.eureka.controller;

import java.util.Observable;

public class WeatherDataSubjectV2 extends Observable {

	private float temp;
	private float humidity;
	private float pressure;

	public WeatherDataSubjectV2() {}
	
	public float getTemp() {
		return temp;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}
	
	public void setMeasurements(float temp,float humidity,float pressure) {
		this.temp=temp;
		this.pressure=pressure;
		this.humidity=humidity;
		measurementsChanged();
	}
	
	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}

}
