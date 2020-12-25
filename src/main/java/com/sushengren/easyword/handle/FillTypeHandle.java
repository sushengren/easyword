package com.sushengren.easyword.handle;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.util.Set;

/**
 * 填充处理接口
 *
 * @author sushengren
 */
public interface FillTypeHandle {

    /**
     * 填充处理
     *
     * @param key       标签
     * @param value     标签值
     * @param runs      标签所在的{@link org.apache.poi.xwpf.usermodel.XWPFRun}
     * @param paragraph 段落
     */
    void handle(String key, Object value, Set<XWPFRun> runs, XWPFParagraph paragraph);

}
