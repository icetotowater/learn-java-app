/**
* Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
*/
package com.gzy.learn.jdkapi.log;

import java.io.File;
import java.util.logging.Logger;

/**
* ClassName: TestMyLogManager <br/>
*
* @author wangao110@hotmail.com
* @version 1.0
* @date 2016年9月2日
* @since JDK 1.7
*/
public class TestMyLogManager {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/src/main/java/com/gzy/learn/jdkapi/log";
        System.setProperty("com.gaozhy.instanceRoot", path);
        Logger log = Logger.getLogger("sss");
        log.info("自定义logManager");
    }
}
