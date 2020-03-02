package com.mrh.community.exception;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/3/2 16:02
 **/


public enum CustomizeErrorCode implements ICustomizeErrorCode{

    QUESTION_NOT_FOUND("你找的话题不见了，可以换个试试?!");

    private String message;
    CustomizeErrorCode(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
