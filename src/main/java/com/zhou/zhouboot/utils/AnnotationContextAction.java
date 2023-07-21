package com.zhou.zhouboot.utils;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhougq
 **/
public class AnnotationContextAction {
    private static AnnotationConfigApplicationContext annotationContextAction;

    private static void init() {
        annotationContextAction = new AnnotationConfigApplicationContext();
        //配置扫描地址
        annotationContextAction.scan("com.zhou.zhouboot");
        //必须调用refresh方法，否则会报错
        annotationContextAction.refresh();
    }

    public static Object getSpringBean(String name) {

        return annotationContextAction.getBean(name);
    }

    public static Object getSpringBean(Class clazz) {
        if (annotationContextAction == null) {
            init();
        }
        return annotationContextAction.getBean(clazz);
    }
}
