package com.lym.eureka.controller;

public interface Subject {
	//这两个方法都需要一个观察者作为变量，该观察者是用来注册或删除的
	public void registerObserver(MyObserver o);
    public void removeObserver(MyObserver o);
    
    //当主题状态改变时，这个方法会被调用，以通知所有注册的观察者
    public void notifyObserver();

}
