/**
 * Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
 */
package com.gzy.learn.jdk.listener;

/**
 * ClassName: Person 事件源<br/>
 * 设计一个Person类作为事件源，这个类的对象的行为(比如吃饭、跑步)可以被其它的对象监听
 * 
 * @author wangao110@hotmail.com
 * @version 1.0
 * @date 2016年9月2日
 * @since JDK 1.7
 */
public class Person {
    private PersonListener listener;

    public void eat() {
        if (listener != null) {
            listener.doeat(new Event(this));
        }
    }
    
    public void run() {
        if(listener != null) {
            listener.dorun(new Event(this));
        }
    }
    
    public void registerListener(PersonListener listener) {
        this.listener = listener;
    }
}
