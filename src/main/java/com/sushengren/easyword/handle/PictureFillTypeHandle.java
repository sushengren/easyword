package com.sushengren.easyword.handle;

import com.sushengren.easyword.util.ImageUtil;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Set;

/**
 * 图片类型处理
 *
 * @author sushengren
 */
public class PictureFillTypeHandle implements FillTypeHandle {

    @Override
    public void handle(String key, Object value, Set<XWPFRun> runs, XWPFParagraph paragraph) {
        for (XWPFRun run : runs) {
            run.setText(run.text().replaceAll("\\{", ""), 0);
            run.setText(run.text().replaceAll("}", ""), 0);
            run.setText(run.text().replaceAll(key, ""), 0);
        }

        InputStream in;
        if (value instanceof InputStream) {
            in = (InputStream) value;
        } else if (value instanceof byte[]) {
            byte[] bytes = (byte[]) value;
            in = new ByteArrayInputStream(bytes);
        } else {
            throw new IllegalArgumentException("无效的图片属性");
        }

        BufferedImage read = ImageUtil.read(in);
        int width = read.getWidth();
        int height = read.getHeight();

        XWPFRun run = runs.iterator().next();
        addPicture(run, in, width, height);
    }

    private void addPicture(XWPFRun run, InputStream in, int width, int height) {
        try {
            run.addPicture(in, XWPFDocument.PICTURE_TYPE_JPEG, "01.jpg", Units.toEMU(width), Units.toEMU(height));
        } catch (Exception e) {
            throw new IllegalArgumentException("插入图片异常", e);
        } finally {
            // IoUtil.close(in);
        }
    }

}
