/**
* Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
*/
package com.gzy.learn.designpattern.observer;
		
/**
* ClassName: ConcreteSubject具体主题角色类 <br/>
*
* @author wangao110@hotmail.com
* @version 1.0
* @date 2016年9月2日
* @since JDK 1.7
*/
public class ConcreteSubject extends Subject {
    private String state;
    
    public String getState() {
        return state;
    }
    
    public void change(String newState) {
        this.state = newState;
        System.out.println("主题状态为：" + state);
//        this.notifyObservers(state);
        this.notifyObservers();
    }
}
