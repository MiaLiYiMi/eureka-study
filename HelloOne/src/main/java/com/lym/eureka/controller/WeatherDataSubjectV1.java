package com.lym.eureka.controller;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataSubjectV1 implements Subject {
	private List<MyObserver> list;
	private float temp;
	private float humidity;
	private float pressure;


	 public WeatherDataSubjectV1() {
	        list = new ArrayList<MyObserver>();
	    }
	
	 
	@Override
	public void registerObserver(MyObserver o) {
		list.add(o);
	}

	@Override
	public void removeObserver(MyObserver o) {
		if(!list.isEmpty())
            list.remove(o);
	}

	//在这里把主题的状态告诉每一个观察者
	@Override
	public void notifyObserver() {
		for(int i = 0; i < list.size(); i++) {
			MyObserver oserver = list.get(i);
            oserver.updateV2(temp,humidity,pressure);
        }
		
	}
	
	//主题状态更新是通知观察者
	public void measurementsChanged() {
		notifyObserver();
	}
	
	
	public void setMeasurements(float temp,float humidity,float pressure) {
		this.temp=temp;
		this.pressure=pressure;
		this.humidity=humidity;
		measurementsChanged();
		
	}

}
