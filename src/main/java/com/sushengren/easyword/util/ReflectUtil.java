package com.sushengren.easyword.util;

import com.sushengren.easyword.exception.UtilException;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

/**
 * 反射工具
 *
 * @author sushengren
 */
public class ReflectUtil {

    /**
     * 字段缓存
     */
    private static final WeakHashMap<Class<?>, List<Field>> FIELDS_CACHE = new WeakHashMap<>();

    /**
     * 获得一个类中所有字段列表，包括其父类中的字段
     *
     * @param clazz 类
     * @return 字段列表
     * @throws SecurityException 安全检查异常
     */
    public static List<Field> getFieldList(Class<?> clazz) throws SecurityException {
        List<Field> fieldList = FIELDS_CACHE.get(clazz);
        if (fieldList == null) {
            fieldList = getFieldListDirectly(clazz, true);
            FIELDS_CACHE.put(clazz, fieldList);
        }
        return fieldList;
    }

    /**
     * 获得一个类中所有字段列表，直接反射获取，无缓存
     *
     * @param clazz                类
     * @param withSuperClassFields 是否包括父类的字段列表
     * @return 字段列表
     * @throws SecurityException 安全检查异常
     */
    public static List<Field> getFieldListDirectly(Class<?> clazz, boolean withSuperClassFields) throws SecurityException {
        List<Field> result = new ArrayList<>();
        Class<?> searchType = clazz;
        while (searchType != null) {
            result.addAll(Arrays.asList(searchType.getDeclaredFields()));
            searchType = withSuperClassFields ? searchType.getSuperclass() : null;
        }
        return result;
    }

    /**
     * 获取字段值
     *
     * @param obj   对象，static字段则此字段为null
     * @param field 字段
     * @return 字段值
     */
    public static Object getFieldValue(Object obj, Field field) {
        if (null == field) {
            return null;
        }
        if (obj instanceof Class) {
            obj = null;
        }

        setAccessible(field);
        try {
            return field.get(obj);
        } catch (IllegalAccessException e) {
            throw new UtilException("IllegalAccess for " + field.getDeclaringClass() + "." + field.getName(), e);
        }
    }

    /**
     * 设置方法为可访问（私有方法可以被外部调用）
     *
     * @param <T>              AccessibleObject的子类，比如Class、Method、Field等
     * @param accessibleObject 可设置访问权限的对象，比如Class、Method、Field等
     * @return 被设置可访问的对象
     */
    public static <T extends AccessibleObject> T setAccessible(T accessibleObject) {
        if (null != accessibleObject && !accessibleObject.isAccessible()) {
            accessibleObject.setAccessible(true);
        }
        return accessibleObject;
    }

}
