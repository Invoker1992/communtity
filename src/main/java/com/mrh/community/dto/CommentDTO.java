package com.mrh.community.dto;

import com.mrh.community.model.User;
import lombok.Data;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/3/9 20:02
 **/

@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private User user;
}
