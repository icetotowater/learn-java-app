/**
* Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
*/
package com.gzy.learn.designpattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
* ClassName: Watched 被观察者<br/>
*
* @author wangao110@hotmail.com
* @version 1.0
* @date 2016年9月2日
* @since JDK 1.7
*/
public class Watched extends Observable {
    private String data = "";
    
    public String getData() {
        return this.data;
    }
    
    public void setData(String data) {
        if (!this.data.equals(data)) {
            this.data = data;
            super.setChanged();
        }
        super.notifyObservers();
    }
    
    public void registerListener(Observer o) {
        this.addObserver(o);
    }
}
