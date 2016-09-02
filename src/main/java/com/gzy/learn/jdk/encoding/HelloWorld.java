/**
* Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
*/
package com.gzy.learn.jdk.encoding;
		
/**
* ClassName: HelloWorld <br/>
*
* @author wangao110@hotmail.com
* @version 1.0
* @date 2016年9月1日
* @since JDK 1.7
*/
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println(System.getProperty("file.encoding"));
        System.getProperties().list(System.out);
    }
}
