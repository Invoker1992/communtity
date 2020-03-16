package com.mrh.community.enums;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/3/15 21:55
 **/

public enum NotificationStatusEnum {
    UNREAD(0),
    READ(1);
    private int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }
}
