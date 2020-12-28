package com.sushengren.easyword.exception;

import com.sushengren.easyword.util.ExceptionUtil;

/**
 * 工具类异常
 *
 * @author sushengren
 */
public class UtilException extends RuntimeException {

    private static final long serialVersionUID = -1L;

    public UtilException(Throwable e) {
        super(ExceptionUtil.getMessage(e), e);
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
