/**
* Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
*/
package com.gzy.learn.jdkapi.log;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
* ClassName: MyLogManager <br/>
*
* @author wangao110@hotmail.com
* @version 1.0
* @date 2016年9月2日
* @since JDK 1.7
*/
public class MyLogManager extends LogManager {
    private static MyLogManager thisInstance;
    private static MyFileHandler handlerSingleton; 
    private Object lockObj = new Object();
    public MyLogManager() {
    }
    
    public static synchronized MyLogManager getInstance() {
        if (thisInstance == null) {
            thisInstance = new MyLogManager();
        }
        return thisInstance;
    }

    @Override
    public boolean addLogger(Logger paramLogger) {
        boolean rs = super.addLogger(paramLogger);
        synchronized(lockObj) {
            internalInitializeLogger(paramLogger);  
        }
        return rs;
    }

    /**
    * internalInitializeLogger:(这里用一句话描述这个方法的作用). <br/>
    *
    * @author wangao110@hotmail.com
    * @param paramLogger
    * @since JDK 1.7
    */
    private void internalInitializeLogger(Logger paramLogger) {
        Handler[] h = paramLogger.getHandlers();  
        for (int i = 0; i < h.length; i++) {  
            paramLogger.removeHandler(h[i]);  
        }  
        paramLogger.addHandler(getFileHandler());  
        paramLogger.setUseParentHandlers(false);  
  
        paramLogger.setLevel(Level.FINEST);// only for test
    }

    /**
    * getFileHandler:(这里用一句话描述这个方法的作用). <br/>
    *
    * @author wangao110@hotmail.com
    * @return
    * @since JDK 1.7
    */
    private Handler getFileHandler() {
        if (handlerSingleton == null) {  
            try {  
                handlerSingleton = MyFileHandler.getInstance();  
                handlerSingleton.setLevel(Level.ALL);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return handlerSingleton; 
        
    }

    /**
    * getLoggerResourceBundleName:(这里用一句话描述这个方法的作用). <br/>
    * @author wangao110@hotmail.com
    * @param name
    * @return
    * @since JDK 1.7
    */
    @SuppressWarnings("unused")
    private String getLoggerResourceBundleName(String loggerName) {
        String result = loggerName + "." + "LogStrings";  
        return result;  
        
    }
    
    
}
