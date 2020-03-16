package com.mrh.community.dto;

import com.mrh.community.model.User;
import lombok.Data;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/3/16 9:49
 **/

@Data
public class NotificationDTO {

    private Long id;

    private Long gmtCreate;

    private Integer status;

    private Long notifier;

    private String notifierName;

    //private String outerTitle;
    private String outerName;

    //此处按数据库内小写
    private Long outerid;

    private String typeName;

    private Integer type;
}
