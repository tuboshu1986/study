package com.moko.erp.productmanage.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.*;

public class BeanUtil {

    /**
     * 返回注解EntityInfo定义的实体类的名称，如果类型没有EntityInfo修饰则返回""
     *
     * @param obj
     * @return String
     * @throws
     * @Title: beanName
     * @Description:
     * @author 黄泊
     * @date 2018年9月17日
     */
    public static <T> String beanName(Object obj) {
        return beanName(obj.getClass());
    }

    /**
     * 获取clazz(包含)至lastSuperClazz(包含)的继承链上的所有class，如果lastSuperClazz为null，
     * 则取默认值Object.class
     *
     * @param clazz
     * @return List<Class   <   ?       extends       Object>>
     * @throws
     * @Title: getClasses
     * @Description:
     * @author 黄泊
     * @date 2018年9月10日
     */
    public static List<Class<? extends Object>> getClasses(
            Class<? extends Object> clazz,
            Class<? extends Object> lastSuperClazz) {
        List<Class<? extends Object>> rst = new ArrayList<>();
        if (clazz == null)
            return rst;
        if (lastSuperClazz == null)
            lastSuperClazz = Object.class;
        rst.add(clazz);
        while (lastSuperClazz != clazz) {
            clazz = clazz.getSuperclass();
            rst.add(clazz);
        }

        return rst;
    }

    /**
     * 获取属性的指定类型的注解，若指定类型的注解不存在则返回null
     *
     * @param f
     * @param annotationClazz
     * @return T
     * @throws
     * @Title: getFieldAnnotation
     * @Description:
     * @author 黄泊
     * @date 2018年9月10日
     */
    public static <T extends Annotation> T getFieldAnnotation(Field f,
                                                              Class<? extends T> annotationClazz) {
        if (f == null || annotationClazz == null)
            return null;
        try {
            return f.getAnnotation(annotationClazz);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 获取对象属性的值并转换为字符串返回，如果值为空则返回空字符串""
     *
     * @param obj       对象
     * @param fieldName 属性名
     * @return
     * @throws  String
     * @throws
     * @Title: fieldStringValue
     * @Description:
     * @author 黄泊
     * @date 2018年9月10日
     */
    public static String fieldStringValue(Object obj, String fieldName) {
        try {
            Field f = getField(obj.getClass(), fieldName);
            Object val = stringValue(obj, f);
            if (val == null) {
                return "";
            } else {
                return val.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取值或者返回null
     * @param obj
     * @param fieldName
     * @return
     */
    public static Object fieldValue(Object obj, String fieldName){
        return fieldValue(obj, getField(obj.getClass(), fieldName));
    }

    /**
     * 获取值或者返回null
     * @param obj
     * @param field
     * @return
     */
    public static Object fieldValue(Object obj, Field field){
        if(obj == null)
            return null;
        try {
            return field.get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 属性的字符串值，如果获取失败返回null
     *
     * @param obj
     * @param f
     * @return String
     * @throws
     * @Title: stringValue
     * @Description:
     * @author 黄泊
     * @date 2018年9月17日
     */
    public static String stringValue(Object obj, Field f) {
        try {
            return f.get(obj).toString();
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 设置基本类型属性的值
     *
     * @date 2018年9月21日
     */
    public static void setValue(Object obj, Field f, String val) {
        try {
            Class<? extends Object> type = f.getType();
            if (Integer.class.equals(type))
                f.set(obj, Integer.parseInt(val));
            else if (BigDecimal.class.equals(type))
                f.set(obj, new BigDecimal(val));
            else if (Float.class.equals(type))
                f.set(obj, Float.parseFloat(val));
            else if (Double.class.equals(type))
                f.set(obj, Double.parseDouble(val));
            else if (Long.class.equals(type))
                f.set(obj, Long.parseLong(val));
            else if (Short.class.equals(type))
                f.set(obj, Short.parseShort(val));
            else if (String.class.equals(type))
                f.set(obj, val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取类型以及类型所有父类的属性
     *
     * @param clazz
     * @return List<Field>
     * @throws
     * @Title: getFields
     * @Description:
     * @author 黄泊
     * @date 2018年9月17日
     */
    public static List<Field> getFields(Class<? extends Object> clazz) {
        List<Field> rst = new ArrayList<Field>();
        List<Class<? extends Object>> lst = getClasses(clazz, null);
        for (Class<? extends Object> c : lst) {
            try {
                Field[] fs = c.getDeclaredFields();
                for (Field f : fs) {
                    f.setAccessible(true);
                    rst.add(f);
                }
            } catch (Exception e) {
            }
        }
        return rst;
    }

    /**
     * 从clazz和它的父类中获取属性名name指定的属性
     *
     * @param clazz
     * @param name
     * @return Field
     * @throws
     * @Title: getField
     * @Description:
     * @author 黄泊
     * @date 2018年9月10日
     */
    public static Field getField(Class<? extends Object> clazz, String name) {
        Field rst = null;
        List<Class<? extends Object>> lst = getClasses(clazz, null);
        for (Class<? extends Object> c : lst) {
            try {
                rst = c.getDeclaredField(name);
            } catch (Exception e) {
            }
            if (rst != null) {
                rst.setAccessible(true);
                break;
            }

        }
        return rst;
    }

    /**
     * 将from中非null的属性值复制到对象to的同名属性中
     *
     * @param from
     * @param to
     */
    public static void copyFieldIfNotNull(Object from, Object to) {
        getFields(from.getClass()).forEach(field -> {
            Field toField = getField(to.getClass(), field.getName());
            if(toField == null)
                return;
            if(toField.getType().equals(field.getType())){
                Object val = fieldValue(from, field);
                try {
                    if(val != null)
                        toField.set(to, val);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 将from中包含在fnames中的属性值复制到对象to的同名属性中，静态属性除外
     *
     * @param from
     * @param to
     * @param fnameSet
     */
    public static void copyFields(Object from, Object to, Set<String> fnameSet) {
        getFields(from.getClass()).forEach(field -> {
            if(!fnameSet.contains(field.getName()) || Modifier.isStatic(field.getModifiers()))
                return;

            Field toField = getField(to.getClass(), field.getName());
            if(toField == null)
                return;

            if(toField.getType().equals(field.getType())){
                Object val = fieldValue(from, field);
                try {
                    toField.set(to, val);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 将from中包含在fnames中的属性值复制到对象to的同名属性中，静态属性除外
     *
     * @param from
     * @param to
     * @param fnames
     */
    public static void copyFields(Object from, Object to, String[] fnames) {
        Set<String> modifyProperties = new HashSet<String>();
        modifyProperties.addAll(Arrays.asList(fnames));
        copyFields(from, to, modifyProperties);
    }


}
