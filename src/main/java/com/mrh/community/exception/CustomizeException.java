package com.mrh.community.exception;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/3/2 15:40
 **/


public class CustomizeException extends RuntimeException {
    private String message;
    private Integer code;

    public CustomizeException(ICustomizeErrorCode errorCode)
    {
        this.code=errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
