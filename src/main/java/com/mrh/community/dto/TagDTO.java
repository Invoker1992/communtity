package com.mrh.community.dto;

import lombok.Data;

import java.util.List;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/3/15 9:54
 **/
@Data
public class TagDTO {
    private String catetoryName;
    private List<String> tags;
}
