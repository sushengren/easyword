package com.sushengren.easyword.util;

import com.sushengren.easyword.exception.IORuntimeException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 图片处理工具
 *
 * @author sushengren
 */
public class ImageUtil {

    /**
     * 将的图像bytes转为 {@link BufferedImage}
     *
     * @param imageBytes 图像bytes
     * @return {@link BufferedImage}
     * @throws IORuntimeException IO异常
     */
    public static BufferedImage read(byte[] imageBytes) throws IORuntimeException {
        return read(new ByteArrayInputStream(imageBytes));
    }

    /**
     * 从流中读取图片
     *
     * @param imageStream 图片文件
     * @return 图片
     */
    public static BufferedImage read(InputStream imageStream) {
        try {
            return ImageIO.read(imageStream);
        } catch (IOException e) {
            throw new IORuntimeException(e);
        } finally {
            IoUtil.close(imageStream);
        }
    }

}
