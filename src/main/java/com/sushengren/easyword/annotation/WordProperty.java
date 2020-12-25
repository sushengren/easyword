package com.sushengren.easyword.annotation;

import com.sushengren.easyword.handle.FillTypeHandle;
import com.sushengren.easyword.handle.StringFillTypeHandle;

import java.lang.annotation.*;

/**
 * @author sushengren
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface WordProperty {

    /**
     * 对应标签的值，默认值为字段名
     */
    String value();

    /**
     * 填充处理
     */
    Class<? extends FillTypeHandle> handle() default StringFillTypeHandle.class;

}
