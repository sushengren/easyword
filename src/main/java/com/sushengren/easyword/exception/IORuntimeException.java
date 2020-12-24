package com.sushengren.easyword.exception;

import com.sushengren.easyword.util.ExceptionUtil;

/**
 * IO运行时异常，常用于对IOException的包装
 *
 * @author sushengren
 */
public class IORuntimeException extends RuntimeException {
    private static final long serialVersionUID = 8247610319171014183L;

    public IORuntimeException(Throwable e) {
        super(ExceptionUtil.getMessage(e), e);
    }

    public IORuntimeException(String message) {
        super(message);
    }

    public IORuntimeException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
