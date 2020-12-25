package com.sushengren.easyword;

import cn.hutool.core.util.ReflectUtil;
import com.sushengren.easyword.annotation.WordProperty;
import com.sushengren.easyword.handle.StringFillTypeHandle;
import com.sushengren.easyword.model.FillData;
import com.sushengren.easyword.util.MyReflectUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sushengren
 */
public class Test {

    public static void main(String[] args) throws Exception {

        TestEntity testEntity = new TestEntity();
        testEntity.setName1("北宋“富”字大狮子绣球藤花纹绫");
        testEntity.setName2("一级");
        testEntity.setName3("T0001");
        testEntity.setName4("F0001");
        testEntity.setName5("DA00001");
        testEntity.setName6("2020");
        testEntity.setName7("12");
        testEntity.setName8("24");

        testEntity.setName("北宋“富”字大狮子绣球藤花纹绫");
        testEntity.setOriginalName("北宋“富”字大狮子绣球藤花纹绫");
        testEntity.setAgeType("北宋");
        testEntity.setRecorder("柳大侠");
        testEntity.setMakeTime("北宋");
        testEntity.setQuantity("10件");
        testEntity.setTextureSpecific("铜");
        testEntity.setLustre("白色");
        testEntity.setPurpose("展览");
        testEntity.setBiography("李白");
        testEntity.setLength("200米");
        testEntity.setImg(new FileInputStream(new File("C:\\Users\\AD\\Pictures\\01.jpg")));

        Map<String, FillData> dataMap = new HashMap<>();
        List<Field> fieldList = MyReflectUtil.getFieldList(testEntity.getClass());
        for (Field field : fieldList) {
            WordProperty annotation = field.getAnnotation(WordProperty.class);
            Object fieldValue = ReflectUtil.getFieldValue(testEntity, field);
            if (annotation == null) {
                dataMap.put(field.getName(), new FillData(fieldValue, new StringFillTypeHandle()));
            } else {
                dataMap.put(annotation.value(), new FillData(fieldValue, annotation.handle().newInstance()));
            }
        }

        File file = new File("C:\\Users\\AD\\Desktop\\CollectionFile.docx");
        FileOutputStream out = new FileOutputStream("C:\\Users\\AD\\Desktop\\CollectionFile1.docx");
        EasyWord.of(file).doWrite(dataMap).toOutputStream(out);
    }

}
