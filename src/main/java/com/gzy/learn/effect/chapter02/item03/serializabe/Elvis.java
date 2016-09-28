/**
 * Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
 */
package com.gzy.learn.effect.chapter02.item03.serializabe;

import java.io.Serializable;

/**
 * ClassName: Elvis <br/>
 *
 * @author wangao110@hotmail.com
 * @version 1.0
 * @date 2016年9月28日
 * @since JDK 1.7
 */
public class Elvis implements Serializable {
    /**
    * serialVersionUID:TODO(用一句话描述这个变量表示什么).
    * @since JDK 1.7
    */
    private static final long serialVersionUID = 1L;
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    private Object readResolve() {
        // Return the one true Elvis and let the garbage collector
        // take care of the Elvis impersonator.
        return INSTANCE;
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
