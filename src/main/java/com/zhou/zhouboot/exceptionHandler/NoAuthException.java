package com.zhou.zhouboot.exceptionHandler;

import com.zhou.zhouboot.exception.NoAuthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author zhougq
 **/
@ControllerAdvice
public class NoAuthException {
    @ExceptionHandler(value = NoAuthorizedException.class)
    public String handleNoAuthException(NoAuthorizedException e) {
        System.out.println("没有权限");
        return "redirect:/login.html";
    }
}
