package com.sushengren.easyword.model;

import com.sushengren.easyword.handle.FillTypeHandle;

/**
 * 填充数据
 *
 * @author sushengren
 */
public class FillData {

    private Object value;
    private FillTypeHandle handle;

    public FillData(Object value, FillTypeHandle handle) {
        this.value = value;
        this.handle = handle;
    }

    public static FillData of(Object value, FillTypeHandle handle) {
        return new FillData(value, handle);
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public FillTypeHandle getHandle() {
        return handle;
    }

    public void setHandle(FillTypeHandle handle) {
        this.handle = handle;
    }

}
