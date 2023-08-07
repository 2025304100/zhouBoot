package com.zhou.zhouboot.exception;

/**
 * @author zhougq
 **/
public class NoAuthorizedException extends Exception {
    private String url="";

    public NoAuthorizedException(String message,String url) {
        super(message);
        this.url=url;
    }
    public NoAuthorizedException(String message) {
        super(message);
    }
}

