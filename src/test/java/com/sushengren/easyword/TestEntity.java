package com.sushengren.easyword;

import com.sushengren.easyword.annotation.WordProperty;
import com.sushengren.easyword.handle.PictureFillTypeHandle;

import java.io.InputStream;

/**
 * @author sushengren
 */
public class TestEntity {

    @WordProperty(value = "文物名称")
    private String value1;

    @WordProperty("文物级别")
    private String value2;

    @WordProperty("总登记号")
    private String value3;

    @WordProperty("分类号")
    private String value4;

    @WordProperty("档案编号")
    private String value5;

    @WordProperty("年")
    private String value6;

    @WordProperty("月")
    private String value7;

    @WordProperty("日")
    private String value8;

    @WordProperty("制档人")
    private String value9;

    @WordProperty(value = "图片", handle = PictureFillTypeHandle.class)
    private InputStream img;

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    public String getValue4() {
        return value4;
    }

    public void setValue4(String value4) {
        this.value4 = value4;
    }

    public String getValue5() {
        return value5;
    }

    public void setValue5(String value5) {
        this.value5 = value5;
    }

    public String getValue6() {
        return value6;
    }

    public void setValue6(String value6) {
        this.value6 = value6;
    }

    public String getValue7() {
        return value7;
    }

    public void setValue7(String value7) {
        this.value7 = value7;
    }

    public String getValue8() {
        return value8;
    }

    public void setValue8(String value8) {
        this.value8 = value8;
    }

    public String getValue9() {
        return value9;
    }

    public void setValue9(String value9) {
        this.value9 = value9;
    }

    public InputStream getImg() {
        return img;
    }

    public void setImg(InputStream img) {
        this.img = img;
    }

}
