package com.sushengren.easyword.handle;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.util.Set;

/**
 * 字符串类型处理
 *
 * @author sushengren
 */
public class StringFillTypeHandle implements FillTypeHandle {

    @Override
    public void handle(String key, Object value, Set<XWPFRun> runs, XWPFParagraph paragraph) {
        for (XWPFRun r : runs) {
            r.setText(r.text().replaceAll("\\{", ""), 0);
            r.setText(r.text().replaceAll("}", ""), 0);
            r.setText(r.text().replaceAll(key, value != null ? value.toString() : ""), 0);
        }
    }

}
