/**
* Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
*/
package com.gzy.learn.effect.chapter02.item06;

import java.util.Arrays;

/**
* ClassName: Stack <br/>
*
* @author wangao110@hotmail.com
* @version 1.0
* @date 2016年9月28日
* @since JDK 1.7
*/
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    
    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    
    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }
    
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
//        return elements[--size];  不会被垃圾回收机制回收
        
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }
    
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
