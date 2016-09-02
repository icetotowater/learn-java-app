/**
* Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
*/
package com.gzy.learn.designpattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
* ClassName: Watcher 观察者<br/>
*
* @author wangao110@hotmail.com
* @version 1.0
* @date 2016年9月2日
* @since JDK 1.7
*/
public class Watcher implements Observer {

    public void update(Observable paramObservable, Object paramObject) {
        System.out.println("状态发生变化：" + ((Watched)paramObservable).getData());
        
    }
    
}
