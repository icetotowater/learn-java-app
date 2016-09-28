/**
* Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
*/
package com.gzy.learn.effect.chapter02.item03.field;
		
/**
* ClassName: Elvis <br/>
*
* @author wangao110@hotmail.com
* @version 1.0
* @date 2016年9月28日
* @since JDK 1.7
*/
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    
    private Elvis() {
    }
    
    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }
    
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
