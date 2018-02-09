package com.boyuan.base;

/**
 * @author jiangbo
 * @date 2017\11\18 0018
 */
public class EasyhrException extends Exception {

    public EasyhrException(String message) {
        super(message);
    }

    public EasyhrException(String message,Throwable cause){
        super(message,cause);
    }
}
