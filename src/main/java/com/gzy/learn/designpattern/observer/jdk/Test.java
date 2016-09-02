/**
* Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
*/
package com.gzy.learn.designpattern.observer.jdk;

import java.util.Observer;

/**
* ClassName: Test <br/>
*
* @author wangao110@hotmail.com
* @version 1.0
* @date 2016年9月2日
* @since JDK 1.7
*/
public class Test {
    public static void main(String[] args) {
        // 创建被观察者对象
        Watched watched = new Watched();
        // 创建观察者对象
        Watcher o = new Watcher();
        // 注册监听
        watched.addObserver(o);
        
        // 给被观察者状态赋值
        watched.setData("start");
        watched.setData("run");
        watched.setData("stop");
    }
}
