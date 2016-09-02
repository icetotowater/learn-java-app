/**
* Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
*/
package com.gzy.learn.jdk.listener;

/**
* ClassName: TestListener <br/>
*
* @author wangao110@hotmail.com
* @version 1.0
* @date 2016年9月2日
* @since JDK 1.7
*/
public class TestListener {
    public static void main(String[] args) {
        Person person = new Person();
        
        person.registerListener(new PersonListener() {

            public void doeat(Event e) {
                Person p = e.getSource();
                System.out.println(p + "在吃东西");
            }

            public void dorun(Event e) {
                Person p = e.getSource();
                System.out.println(p + "在跑步");
                
            }
            
        });
        
        person.eat();
        person.run();
    }
}
