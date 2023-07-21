package com.zhou.zhouboot.utils;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @author zhougq
 **/
public class MyVoToModel<T,V> {

    public   T voToModel(V v,T t){
        if (v!=null&&t!=null){
            HashMap<String, Object> stringObjectHashMap = getObjectFields(v);

            setFields(t,stringObjectHashMap);
        }
        return t;
    }
    /*注入属性值*/
    private void setFields(T t, HashMap<String, Object> stringObjectHashMap) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                //设置属性可访问
                field.setAccessible(true);
                field.set(t, stringObjectHashMap.get(field.getName()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /*获得对象属性的值*/
    private HashMap<String,Object> getObjectFields(V v) {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();

        Field[] fields = v.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                stringObjectHashMap.put(field.getName(), field.get(v));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return stringObjectHashMap;
    }
}
