/**
* Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
*/
package com.gzy.learn.designpattern.observer;
		
/**
* ClassName: Observer 抽象观察者角色类<br/>
*
* @author wangao110@hotmail.com
* @version 1.0
* @date 2016年9月2日
* @since JDK 1.7
*/
public interface Observer {
    public void update(String state);
    
    public void updates(Subject subject);
}
