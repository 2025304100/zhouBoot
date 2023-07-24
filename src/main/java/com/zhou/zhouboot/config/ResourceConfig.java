package com.zhou.zhouboot.config;

import com.zhou.zhouboot.interceptor.RepeatSubmitInterceptors;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * @author zhougq
 **/
@Configurable

public class ResourceConfig {

    //静态资源配置
    @Bean
    public  void  addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }
    //拦截器配置 拦截加载自定义注解增强功能

    @Bean
    public void addInterceptors(InterceptorRegistry registry, RepeatSubmitInterceptors interceptor){
        //registry.addInterceptor(interceptor).addPathPatterns("/**");
        registry.addInterceptor(interceptor).addPathPatterns("/**");


    }

}
