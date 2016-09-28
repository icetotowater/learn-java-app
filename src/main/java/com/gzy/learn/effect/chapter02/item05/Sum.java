/**
* Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
*/
package com.gzy.learn.effect.chapter02.item05;
		
/**
* ClassName: Sum <br/>
*
* @author wangao110@hotmail.com
* @version 1.0
* @date 2016年9月28日
* @since JDK 1.7
*/
public class Sum {
    // Hideously slow program! Can you spot the object creation?
    public static void main(String[] args) {
        String sss = "Freedom are the eternal dream";
        System.out.println(sss.length());
        long start = System.currentTimeMillis();
        long sum = 0L;
        // Long sum = 0L; 时间要长的多
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(sum);
    }
}
