package com.sushengren.easyword;

import com.sushengren.easyword.annotation.WordProperty;
import com.sushengren.easyword.handle.PictureFillTypeHandle;

import java.io.InputStream;

/**
 * @author sushengren
 */
public class TestEntity {

    @WordProperty(value = "文物名称")
    private String name1;

    @WordProperty("文物级别")
    private String name2;

    @WordProperty("总登记号")
    private String name3;

    @WordProperty("分类号")
    private String name4;

    @WordProperty("档案编号")
    private String name5;

    @WordProperty("年")
    private String name6;

    @WordProperty("月")
    private String name7;

    @WordProperty("日")
    private String name8;

    private String userFiling;
    private String name;
    private String originalName;
    private String ageType;
    private String recorder;
    private String makeTime;
    private String quantity;
    private String textureSpecific;
    private String lustre;
    private String purpose;
    private String biography;
    private String length;

    @WordProperty(value = "img", handle = PictureFillTypeHandle.class)
    private InputStream img;

    public InputStream getImg() {
        return img;
    }

    public void setImg(InputStream img) {
        this.img = img;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }

    public String getName5() {
        return name5;
    }

    public void setName5(String name5) {
        this.name5 = name5;
    }

    public String getName6() {
        return name6;
    }

    public void setName6(String name6) {
        this.name6 = name6;
    }

    public String getName7() {
        return name7;
    }

    public void setName7(String name7) {
        this.name7 = name7;
    }

    public String getName8() {
        return name8;
    }

    public void setName8(String name8) {
        this.name8 = name8;
    }

    public String getUserFiling() {
        return userFiling;
    }

    public void setUserFiling(String userFiling) {
        this.userFiling = userFiling;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getAgeType() {
        return ageType;
    }

    public void setAgeType(String ageType) {
        this.ageType = ageType;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public String getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(String makeTime) {
        this.makeTime = makeTime;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTextureSpecific() {
        return textureSpecific;
    }

    public void setTextureSpecific(String textureSpecific) {
        this.textureSpecific = textureSpecific;
    }

    public String getLustre() {
        return lustre;
    }

    public void setLustre(String lustre) {
        this.lustre = lustre;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

}
