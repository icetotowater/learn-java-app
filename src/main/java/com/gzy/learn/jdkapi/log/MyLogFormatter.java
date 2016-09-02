/**
 * Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
 */
package com.gzy.learn.jdkapi.log;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Formatter;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;

/**
 * ClassName: MyLogFormater <br/>
 *
 * @author wangao110@hotmail.com
 * @version 1.0
 * @date 2016年9月2日
 * @since JDK 1.7
 */
public class MyLogFormatter extends Formatter {

    private Date date = new Date();
    private HashMap<String, ResourceBundle> loggerResourceBundleTable;
    private LogManager logManager;
    private static final char FIELD_SEPARATOR = '|';
    private static final String CRLF = System.getProperty("line.separator");

    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");

    public MyLogFormatter() {
        super();
        loggerResourceBundleTable = new HashMap<String, ResourceBundle>();
        logManager = LogManager.getLogManager();
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * 
     * @see java.util.logging.Formatter#format(java.util.logging.LogRecord)
     */
    @Override
    public String format(LogRecord paramLogRecord) {
        return uniformLogFormat(paramLogRecord);

    }

    private String uniformLogFormat(LogRecord record) {
        try {
            String logMessage = record.getMessage();
            int msgLength = 150; // typical length of log record
            if (logMessage != null) {
                msgLength += logMessage.length();
            }
            StringBuilder recordBuffer = new StringBuilder(msgLength);

            // add date to log
            date.setTime(record.getMillis());
            recordBuffer.append(dateFormatter.format(date)).append(FIELD_SEPARATOR);
            // add log level and logger name to log
            recordBuffer.append(record.getLevel()).append(FIELD_SEPARATOR);
            recordBuffer.append(record.getLoggerName()).append(FIELD_SEPARATOR);

            if (logMessage == null) {
                logMessage = "The log message is null.";
            }
            if (logMessage.indexOf("{0}") >= 0) {
                try {
                    logMessage = java.text.MessageFormat.format(logMessage, record.getParameters());
                } catch (Exception e) {
                    // e.printStackTrace();
                }
            } else {
                ResourceBundle rb = getResourceBundle(record.getLoggerName());
                if (rb != null) {
                    try {
                        logMessage = MessageFormat.format(rb.getString(logMessage), record.getParameters());
                    } catch (java.util.MissingResourceException e) {
                    }
                }
            }
            recordBuffer.append(logMessage);
            recordBuffer.append(CRLF);

            return recordBuffer.toString();

        } catch (Exception ex) {
            return "Log error occurred on msg: " + record.getMessage() + ": " + ex;
        }
    }

    private synchronized ResourceBundle getResourceBundle(String loggerName) {
        if (loggerName == null) {
            return null;
        }
        ResourceBundle rb = (ResourceBundle) loggerResourceBundleTable.get(loggerName);

        if (rb == null) {
            rb = logManager.getLogger(loggerName).getResourceBundle();
            loggerResourceBundleTable.put(loggerName, rb);
        }
        return rb;
    }
}
