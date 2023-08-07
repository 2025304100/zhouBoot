package com.zhou.zhouboot.interceptor;

import com.zhou.core.AjaxResult;
import com.zhou.utils.ServletUtils;
import com.zhou.zhouboot.annotation.RepealSubmit;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import com.alibaba.fastjson2.JSON;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
@Component
/**
 * @author zhougq
 **/
public abstract class RepeatSubmitInterceptors implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            System.out.println("RepeatSubmitInterceptors------------------------->");
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            RepealSubmit annotation = method.getAnnotation(RepealSubmit.class);
            if (annotation != null) {
                if (this.isRepeatSubmit(request, annotation)) {
                    AjaxResult ajaxResult = AjaxResult.error(annotation.message());
                    ServletUtils.renderString(response, JSON.toJSONString(ajaxResult));
                    return false;
                }
            }
            return true;
        }
        return true;
    }
    public abstract boolean isRepeatSubmit(HttpServletRequest request, RepealSubmit annotation) ;
}

