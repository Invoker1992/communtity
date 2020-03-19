package com.mrh.community.dto;

import lombok.Data;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/3/19 15:25
 **/
@Data
public class QuestionQueryDTO {

    private String search;
    private Integer page;
    private Integer size;

}
