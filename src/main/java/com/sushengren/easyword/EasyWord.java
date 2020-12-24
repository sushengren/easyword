package com.sushengren.easyword;

import com.sushengren.easyword.exception.IORuntimeException;
import com.sushengren.easyword.util.IoUtil;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

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
            }
        }

        public Builder doWrite(Map<String, Object> data) {
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

    private static void fill(XWPFParagraph paragraph, Map<String, Object> data) {
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            if (paragraph.getText().contains("{" + entry.getKey() + "}")) {
                System.out.println(paragraph.getText());
                for (XWPFRun run : paragraph.getRuns()) {
                    // if(run.text().contains("{"))

                    // System.out.println(run);
                }
            }
        }
    }

}
