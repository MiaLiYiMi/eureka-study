package com.lym.eureka.controller;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject{
	
	//注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
    private List<MyObserver> list;
    private String message;

    public ConcreteSubject() {
        list = new ArrayList<MyObserver>();
    }
    
	@Override
	public void registerObserver(MyObserver o) {
		// TODO Auto-generated method stub
		list.add(o);
	}

	@Override
	public void removeObserver(MyObserver o) {
		// TODO Auto-generated method stub
		if(!list.isEmpty())
            list.remove(o);
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(int i = 0; i < list.size(); i++) {
			MyObserver oserver = list.get(i);
            oserver.update(message);
        }
	}
	
	public void setInfomation(String s) {
        this.message = s;
        System.out.println("主题更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }

}
