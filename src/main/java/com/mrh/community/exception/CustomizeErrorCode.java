package com.mrh.community.exception;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/3/2 16:02
 **/


public enum CustomizeErrorCode implements ICustomizeErrorCode{

    QUESTION_NOT_FOUND(2001,"你找的话题不见了，可以换个试试?!"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中话题或者评论进行回复?!"),
    NO_LOGIN(2003,"用户未登录，请先登录再进行评论！"),
    SYS_ERROR(2004,"服务冒烟了，请稍候再试试！"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在！"),
    COMMENT_NOT_FOUND(2006,"回复的评论不存在了！"),
    COMMENT_IS_EMPTY(2007,"回复的评论不能为空！");


    private String message;
    private Integer code;

    CustomizeErrorCode(Integer code,String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
