package com.xiaochonzi.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by stone on 17/8/13.
 */
public class LogFactory {

    private static final Logger rootLogger;
    private static final Logger sysLogger;

    static {
        sysLogger = LoggerFactory.getLogger("sysLogger");
        rootLogger = LoggerFactory.getLogger(LogFactory.class);
    }

    public static Logger getRootLogger() {
        return rootLogger;
    }

    public static Logger getSysLogger() {
        return sysLogger;
    }
}
