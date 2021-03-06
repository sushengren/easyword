package com.sushengren.easyword.util;

/**
 * 异常工具类
 *
 * @author sushengren
 */
public class ExceptionUtil {

    /**
     * 获得完整消息，包括异常名，消息格式为：{SimpleClassName}: {ThrowableMessage}
     *
     * @param e 异常
     * @return 完整消息
     */
    public static String getMessage(Throwable e) {
        return null != e ? e.getClass().getSimpleName() + ": " + e.getMessage() : "null";
    }

}
