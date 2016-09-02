/**
 * Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
*/
package com.gzy.learn.designpattern.observer;
		
/**
* ClassName: Client 客户端类<br/>
*
* @author wangao110@hotmail.com
* @version 1.0
* @date 2016年9月2日
* @since JDK 1.7
*/
public class Client {
    public static void main(String[] args) {
        // 创建主题对象
        ConcreteSubject subject = new ConcreteSubject();
        // 创建观察者对象
        Observer observer = new ConcreteObserver();
        // 将观察者对象登记到主题对象上
        subject.attach(observer);
        // 改变主题的状态
        subject.change("new state");
    }
}
