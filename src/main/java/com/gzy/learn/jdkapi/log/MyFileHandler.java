/**
 * Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
 */
package com.gzy.learn.jdkapi.log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

/**
 * ClassName: MyFileHandler <br/>
 *
 * @author wangao110@hotmail.com
 * @version 1.0
 * @date 2016年9月2日
 * @since JDK 1.7
 */
public class MyFileHandler extends StreamHandler {
    private WrapperStream wrappedStream;
    private String absoluteFileName = null;
    static final String LOG_FILENAME_PREFIX = "gaozhy";
    static final String LOG_FILENAME_SUFFIX = ".log";
    private String logFileName = LOG_FILENAME_PREFIX + LOG_FILENAME_SUFFIX;
    public static final MyFileHandler thisInstance = new MyFileHandler();

    public static synchronized MyFileHandler getInstance() {
        return thisInstance;
    }

    protected MyFileHandler() {
        try {
            setFormatter(new MyLogFormatter());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void publish(LogRecord paramLogRecord) {
        if (wrappedStream == null) {
            try {
                absoluteFileName = createFileName();
                openFile(absoluteFileName);
            } catch (Exception e) {
                throw new RuntimeException("Serious Error Couldn't open Log File" + e);
            }
        }
        super.publish(paramLogRecord);
        flush();

    }

    private void openFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                file.getParentFile().mkdir();
            }
            file.createNewFile();
        }
        FileOutputStream fout = new FileOutputStream(fileName, true);
        BufferedOutputStream bout = new BufferedOutputStream(fout);
        wrappedStream = new WrapperStream(bout, file.length());
        setOutputStream(wrappedStream);
    }

    private String createFileName() {
        String instDir = "";
        instDir = System.getProperty("com.gaozhy.instanceRoot");
        if (instDir == null || "".equals(instDir)) {
            instDir = ".";
        }
        return instDir + "/" + getLogFileName();
    }

    protected String getLogFileName() {
        return logFileName;
    }

    private class WrapperStream extends OutputStream {
        private OutputStream out;
        @SuppressWarnings("unused")
        private long written;

        public WrapperStream(OutputStream out, long written) {
            this.out = out;
            this.written = written;
        }

        public void write(int b) throws IOException {
            out.write(b);
            written++;
        }

        public void write(byte buff[]) throws IOException {
            out.write(buff);
            written += buff.length;
        }

        public void write(byte buff[], int off, int len) throws IOException {
            out.write(buff, off, len);
            written += len;
        }

        public void flush() throws IOException {
            out.flush();
        }

        public void close() throws IOException {
            out.close();
        }
    }
}
