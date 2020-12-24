package com.sushengren.easyword;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sushengren
 */
public class Ber {

    private static Map<String, Object> dataMap = new HashMap<>();

    static {
        dataMap.put("文物名称", "北宋“富”字大狮子绣球藤花纹绫");
        dataMap.put("文物级别", "一级");
        dataMap.put("总登记号", "T0001");
        dataMap.put("分类号", "F0001");
        dataMap.put("档案编号", "DA00001");
        dataMap.put("年", "2020");
        dataMap.put("月", "12");
        dataMap.put("日", "24");


        dataMap.put("userFiling", "柳大侠");
        dataMap.put("name", "北宋“富”字大狮子绣球藤花纹绫");
        dataMap.put("originalName", "北宋“富”字大狮子绣球藤花纹绫");
        dataMap.put("ageType", "北宋");
        dataMap.put("recorder", "柳大侠");
        dataMap.put("makeTime", "北宋");
        dataMap.put("quantity", "10件");
        dataMap.put("textureSpecific", "铜");
    }

    public static void main(String[] args) throws Exception {

        File file = new File("C:\\Users\\AD\\Desktop\\CollectionFile.docx");
        FileOutputStream out = new FileOutputStream("C:\\Users\\AD\\Desktop\\CollectionFile1.docx");

        EasyWord.of(file).doWrite(dataMap).toOutputStream(out);
    }

    private void paragraphs() {

    }

}
