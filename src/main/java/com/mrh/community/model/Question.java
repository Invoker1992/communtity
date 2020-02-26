package com.mrh.community.model;

import lombok.Data;
import org.apache.ibatis.annotations.Insert;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/2/14 21:47
 **/

@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;

}