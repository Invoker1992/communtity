package com.mrh.community.exception;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/3/2 15:40
 **/


public class CustomizeException extends RuntimeException {
    private String message;

    public CustomizeException(String message)
    {
        this.message = message;
    }

    public CustomizeException(ICustomizeErrorCode errorCode)
    {
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
