/**
* Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
*/
package com.gzy.learn.jdkapi.log;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* ClassName: TestJul JDK自带日志测试<br/>
*
* @author wangao110@hotmail.com
* @version 1.0
* @date 2016年9月2日
* @since JDK 1.7
*/
public class TestJul {
    public static final Logger log = Logger.getLogger(TestJul.class.toString());
    
    static {
        Handler console = new ConsoleHandler();
        console.setLevel(Level.SEVERE);
        log.addHandler(console);
    }
    /**
     * 
    * @author wangao110@hotmail.com
    * @param args
    * @since JDK 1.7
     */
    public static void main(String[] args) {
        // all-finest-finer-fine-config-info-warning-server-off
        // 级别一次升高，后面的日志级别会屏蔽之前的级别
        log.setLevel(Level.INFO);
        log.finest("finest");
        log.finer("finer");
        log.fine("fine");
        log.config("config");
        log.info("info");
        log.warning("warning");
        log.severe("server");
        
        Logger logger = Logger.getAnonymousLogger();
        logger.info("anonymous");
    }
}
