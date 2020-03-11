package com.mrh.community.dto;

import lombok.Data;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/3/2 21:34
 **/
@Data
public class CommentCreateDTO {

    private Long parentId;
    private String content;
    private Integer type;
}
