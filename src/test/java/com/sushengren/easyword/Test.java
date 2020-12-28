package com.sushengren.easyword;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author sushengren
 */
public class Test {

    public static void main(String[] args) throws Exception {

        TestEntity testEntity = new TestEntity();
        testEntity.setValue1("北宋“富”字大狮子绣球藤花纹绫");
        testEntity.setValue2("一级");
        testEntity.setValue3("T0001");
        testEntity.setValue4("F0001");
        testEntity.setValue5("DA00001");
        testEntity.setValue6("2020");
        testEntity.setValue7("12");
        testEntity.setValue8("24");
        testEntity.setValue9("杰克");
        testEntity.setImg(new FileInputStream(new File("C:\\Users\\AD\\Pictures\\01.jpg")));


        File file = new File("C:\\Users\\AD\\Desktop\\CollectionFile.docx");
        FileOutputStream out = new FileOutputStream("C:\\Users\\AD\\Desktop\\CollectionFile1.docx");
        EasyWord.of(file).doWrite(testEntity).toOutputStream(out);

    }

}
