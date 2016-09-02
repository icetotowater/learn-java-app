/**
 * Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
 */
package com.gzy.learn.jdkapi.log.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * ClassName: TestLog4j 测试log4j日志框架<br/>
 *
 * @author wangao110@hotmail.com
 * @version 1.0
 * @date 2016年9月2日
 * @since JDK 1.7
 */
public class TestLog4j {
    static {
        String path = System.getProperty("user.dir") + "/src/main/java/com/gzy/learn/jdkapi/log/log4j/";
        PropertyConfigurator.configure(path + "log4j.properties");
    }

    public static final Logger log = Logger.getLogger(TestLog4j.class);

    /**
     * 
     * @author wangao110@hotmail.com
     * @param args
     * @since JDK 1.7
     */
    public static void main(String[] args) {
        // all→debug→info→warn→error→fatal→off
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        log.fatal("fatal");
        
        if(log.isDebugEnabled()) {
            log.debug("调试信息");
        }
    }
}
