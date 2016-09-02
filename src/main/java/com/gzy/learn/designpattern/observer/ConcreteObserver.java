/**
* Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
*/
package com.gzy.learn.designpattern.observer;
		
/**
* ClassName: ConcreteObserver 具体观察者角色类<br/>
*
* @author wangao110@hotmail.com
* @version 1.0
* @date 2016年9月2日
* @since JDK 1.7
*/
public class ConcreteObserver implements Observer {
    private String observerState;

    public void update(String state) {
        this.observerState = state;
        System.out.println("推模型观察者状态为：" + this.observerState);
        
    }

    public void updates(Subject subject) {
        this.observerState = ((ConcreteSubject)subject).getState();
        System.out.println("拉模型观察者状态为：" + this.observerState);
    }

}
