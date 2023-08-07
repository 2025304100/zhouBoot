package com.zhou.zhouboot.interceptor.impl;

import com.zhou.zhouboot.annotation.RepealSubmit;
import com.zhou.zhouboot.interceptor.RepeatSubmitInterceptors;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhougq
 **/
@Component
public class RepeatSubmitInterceptorsImpl  extends RepeatSubmitInterceptors {
    @Override
    public boolean isRepeatSubmit(HttpServletRequest request, RepealSubmit annotation) {

        return false;
    }
}
