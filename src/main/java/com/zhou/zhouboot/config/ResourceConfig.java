package com.zhou.zhouboot.config;

import com.zhou.zhouboot.interceptor.RepeatSubmitInterceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * @author zhougq
 **/
@Configuration
public class ResourceConfig implements WebMvcConfigurer {

    @Autowired
    private RepeatSubmitInterceptors interceptor;
    //静态资源配置
//    @Bean
    public  void  addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/","classpath:/static/img");
    }
    //拦截器配置 拦截加载自定义注解增强功能

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //registry.addInterceptor(interceptor).addPathPatterns("/**");
        System.out.println("拦截器配置启动");
        registry.addInterceptor(interceptor).addPathPatterns("/**");


    }

}
