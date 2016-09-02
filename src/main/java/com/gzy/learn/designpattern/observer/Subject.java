/**
* Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
*/
package com.gzy.learn.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
* ClassName: Subject 抽象主题角色类<br/>
*
* @author wangao110@hotmail.com
* @version 1.0
* @date 2016年9月2日
* @since JDK 1.7
*/
public abstract class Subject {
    private List<Observer> list = new ArrayList<Observer>();
    
    /**
     * 
    * attach:(注册观察者对象). <br/>
    *
    * @author wangao110@hotmail.com
    * @param observer
    * @since JDK 1.7
     */
    public void attach(Observer observer) {
        list.add(observer);
        System.out.println("Attached an observer.");
    }
    
    /**
     * 
    * detach:(删除观察者对象). <br/>
    *
    * @author wangao110@hotmail.com
    * @param observer
    * @since JDK 1.7
     */
    public void detach(Observer observer) {
        list.remove(observer);
        System.out.println("Detached an observer.");
    }
    /**
     * 
    * notifyObservers:(通知所有观察者). <br/>
    *
    * @author wangao110@hotmail.com
    * @since JDK 1.7
     */
    public void notifyObservers(String state) {
        for(Observer observer : list) {
            observer.update(state);
        }
    }
    
    public void notifyObservers() {
        for(Observer observer : list) {
            observer.updates(this);
        }
    }
}
