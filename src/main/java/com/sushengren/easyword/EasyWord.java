package com.sushengren.easyword;

import com.sushengren.easyword.annotation.WordProperty;
import com.sushengren.easyword.exception.IORuntimeException;
import com.sushengren.easyword.handle.StringFillTypeHandle;
import com.sushengren.easyword.model.FillData;
import com.sushengren.easyword.util.IoUtil;
import com.sushengren.easyword.util.ReflectUtil;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author sushengren
 */
public class EasyWord {

    public static Builder of(File file) {
        return of(IoUtil.toStream(file));
    }

    public static Builder of(InputStream in) {
        return new Builder(in);
    }

    public static class Builder {

        private InputStream inputStream;
        private XWPFDocument document;

        Builder(InputStream inputStream) {
            this.inputStream = inputStream;
            try {
                document = new XWPFDocument(inputStream);
            } catch (IOException e) {
                throw new IORuntimeException("解析文档异常", e);
            } finally {
                IoUtil.close(inputStream);
            }
        }

        public Builder doWrite(Object data) {
            Map<String, FillData> dataMap = new HashMap<>();
            List<Field> fieldList = ReflectUtil.getFieldList(data.getClass());
            for (Field field : fieldList) {
                WordProperty annotation = field.getAnnotation(WordProperty.class);
                Object fieldValue = ReflectUtil.getFieldValue(data, field);
                if (annotation == null) {
                    dataMap.put(field.getName(), FillData.of(fieldValue, new StringFillTypeHandle()));
                } else {
                    try {
                        dataMap.put(annotation.value(), FillData.of(fieldValue, annotation.handle().newInstance()));
                    } catch (Exception e) {
                        throw new IllegalArgumentException(annotation.handle() + "无法创建实例");
                    }
                }
            }
            return doWrite(dataMap);
        }

        public Builder doWrite(Map<String, FillData> data) {
            for (XWPFTable table : document.getTables()) {
                for (XWPFTableRow row : table.getRows()) {
                    for (XWPFTableCell tableCell : row.getTableCells()) {
                        for (XWPFParagraph paragraph : tableCell.getParagraphs()) {
                            fill(paragraph, data);
                        }
                    }
                }
            }
            for (XWPFParagraph paragraph : document.getParagraphs()) {
                fill(paragraph, data);
            }
            return this;
        }

        /**
         * 用流的方式输出文档，此方法会关闭流
         *
         * @param os 输出流
         */
        public void toOutputStream(OutputStream os) {
            try {
                document.write(os);
            } catch (IOException e) {
                throw new IORuntimeException("输出文档异常", e);
            } finally {
                IoUtil.close(inputStream);
            }
        }

    }

    /**
     * 将数据填充到段落
     *
     * @param paragraph 段落
     * @param data      填充数据
     */
    private static void fill(XWPFParagraph paragraph, Map<String, FillData> data) {
        boolean read = false;
        StringBuilder key = new StringBuilder();
        Set<XWPFRun> runs = new HashSet<>();
        for (XWPFRun run : paragraph.getRuns()) {
            for (String s : run.text().split("")) {
                if ("}".equals(s)) {
                    runs.add(run);
                    read = false;

                    FillData fillData = data.get(key.toString());
                    if (fillData != null) {
                        fillData.getHandle().handle(key.toString(), fillData.getValue(), runs, paragraph);
                    }

                    runs.clear();
                    key.delete(0, key.length());
                }
                if (read) {
                    runs.add(run);
                    key.append(s);
                }
                if ("{".equals(s)) {
                    runs.add(run);
                    read = true;
                }
            }
        }
    }

}
