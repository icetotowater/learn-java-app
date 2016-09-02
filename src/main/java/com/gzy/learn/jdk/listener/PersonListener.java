/**
* Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
*/
package com.gzy.learn.jdk.listener;
		
/**
* ClassName: PersonListener 事件监听器<br/>
*
* @author wangao110@hotmail.com
* @version 1.0
* @date 2016年9月2日
* @since JDK 1.7
*/
public interface PersonListener {
    void doeat(Event e);
    
    void dorun(Event e);
}
