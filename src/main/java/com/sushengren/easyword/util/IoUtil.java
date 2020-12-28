package com.sushengren.easyword.util;

import com.sushengren.easyword.exception.IORuntimeException;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;

/**
 * IO工具类
 *
 * @author sushengren
 */
public class IoUtil {

    /**
     * 文件转为流
     *
     * @param file 文件
     * @return {@link FileInputStream}
     */
    public static FileInputStream toStream(File file) {
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new IORuntimeException(e);
        }
    }

    /**
     * 从流中读取bytes，读取完毕后关闭流
     *
     * @param in 输入流
     * @return bytes
     */
    public static byte[] readBytes(final InputStream in) {
        try {
            return IOUtils.toByteArray(in);
        } catch (IOException e) {
            throw new IORuntimeException(e);
        } finally {
            close(in);
        }
    }

    /**
     * 关闭<br>
     * 关闭失败不会抛出异常
     *
     * @param closeable 被关闭的对象
     */
    public static void close(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (Exception e) {
                // 静默关闭
            }
        }
    }

}
